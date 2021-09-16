package com.li.framework.retrofit_utility;

import androidx.annotation.NonNull;

import retrofit2.Retrofit;

/**
 * description: 对retrofit的封装
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

  /**
   * 入口方法
   *
   * @param retrofitConfig 调用方对要使用的retrofit的配置
   * @param serviceType    apiService
   * @return apiService的动态代理
   */
  @NonNull
  public <T> T create(@NonNull IRetrofitConfig retrofitConfig, @NonNull Class<T> serviceType) {
    return createRetrofit(retrofitConfig).create(serviceType);
  }

  // 创建retrofit对象
  @NonNull
  private Retrofit createRetrofit(@NonNull IRetrofitConfig retrofitConfig) {
    return RetrofitFactory.create(retrofitConfig);
  }

}
