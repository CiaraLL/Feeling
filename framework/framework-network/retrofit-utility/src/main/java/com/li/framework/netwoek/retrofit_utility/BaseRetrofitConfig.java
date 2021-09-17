package com.li.framework.netwoek.retrofit_utility;

import static java.util.concurrent.TimeUnit.SECONDS;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;

/**
 * description: IRetrofitConfig的基类：
 * 配置的基本实现，后面有什么通用的配置都可以在这里实现
 * 推荐库的使用方的自定义的retrofitConfig继承该类,需要自定义的具体内容再去子类化即可
 */
public abstract class BaseRetrofitConfig implements IRetrofitConfig {

  // 默认的超时时间
  private final static int DEFAULT_API_TIMEOUT_SEC = 10;

  private static volatile OkHttpClient sHttpClient = null;

  @NonNull
  @Override
  public Gson getGson() {
    return GsonHolder.sGson;
  }

  @NonNull
  @Override
  public OkHttpClient getClient() {
    // 用静态内部类做单例就比较麻烦了(createOkHttpClientBuilder函数是要被子类定制的)，因此直接用双重检查锁
    if (sHttpClient == null) {
      synchronized (BaseRetrofitConfig.class) {
        if (sHttpClient == null) {
          sHttpClient = createOkHttpClientBuilder(DEFAULT_API_TIMEOUT_SEC).build();
        }
      }
    }
    return sHttpClient;
  }

  /**
   * 用于对okHttpClient进行配置:超时时间、各种拦截器(例如发送请求时可以配置header)
   * 子类可以重载该方法(添加自己的配置)
   *
   * @param timeoutSec 超时时间
   */
  // TODO: 9/17/21 后面加上添加header的拦截器
  @NonNull
  protected OkHttpClient.Builder createOkHttpClientBuilder(int timeoutSec) {
    return new OkHttpClient.Builder()
        .connectTimeout(timeoutSec, SECONDS)
        .readTimeout(timeoutSec, SECONDS)
        .writeTimeout(timeoutSec, SECONDS);
  }

  // 默认就是一个没有任何自定义配置的gson对象
  private static class GsonHolder {
    static Gson sGson = new Gson();
  }

}
