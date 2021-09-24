package com.li.library.retrofit_utlity;

import androidx.annotation.NonNull;

import retrofit2.Retrofit;

/**
 * description: 对retrofit的封装
 * 依赖关系是，manager根据调用方传递来的IRetrofitConfig来构建retrofit对象，然后用retrofit对象来构建调用方传递进来的service
 * IRetrofitConfig内部生成某些配置信息(比如构建请求的header等)依赖于RetrofitInitConfig，
 * RetrofitInitConfig也是桥接着retrofit封装模块和外界，比如模块依赖的context就是外界通过RetrofitInitConfig传递进来的
 */
public class RetrofitManager {

  // 单例
  public static RetrofitManager getInstance() {
    return RetrofitManagerHolder.INSTANCE;
  }

  // 静态内部类实现单例模式
  private static class RetrofitManagerHolder {
    static RetrofitManager INSTANCE = new RetrofitManager();
  }

  // 保证在整个app启动的时候就赋值,因此此处标记为NonNull
  @NonNull
  private IRetrofitInitConfig mInitConfig;

  public void init(@NonNull IRetrofitInitConfig initConfig) {
    mInitConfig = initConfig;
  }

  /**
   * 创建service实例(实际上返回的是该service的proxy)
   *
   * @param retrofitConfig 调用方对要使用的retrofit的配置
   * @param serviceType    apiService
   * @return apiService的动态代理
   */
  @NonNull
  public <T> T create(@NonNull IRetrofitConfig retrofitConfig, @NonNull Class<T> serviceType) {
    return createRetrofit(retrofitConfig).create(serviceType);
  }

  // 创建retrofit实例
  @NonNull
  private Retrofit createRetrofit(@NonNull IRetrofitConfig retrofitConfig) {
    return RetrofitFactory.create(retrofitConfig);
  }

}
