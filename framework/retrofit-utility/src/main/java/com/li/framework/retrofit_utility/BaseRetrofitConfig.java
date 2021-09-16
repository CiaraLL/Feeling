package com.li.framework.retrofit_utility;

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

  @NonNull
  @Override
  public Gson getGson() {
    return GsonHolder.sGson;
  }

  @NonNull
  @Override
  public OkHttpClient getClient() {
    return OkHttpClientHolder.sOkHttpClient;
  }

  // 默认就是一个没有任何自定义配置的gson对象
  private static class GsonHolder {
    static Gson sGson = new Gson();
  }

  // 只配置了超时时间
  private static class OkHttpClientHolder {
    // 默认的超时时间
    private final static int DEFAULT_API_TIMEOUT_SEC = 10;

    static OkHttpClient sOkHttpClient = createOkHttpClient();

    @NonNull
    private static OkHttpClient createOkHttpClient() {
      return new OkHttpClient.Builder()
          .connectTimeout(DEFAULT_API_TIMEOUT_SEC, SECONDS)
          .readTimeout(DEFAULT_API_TIMEOUT_SEC, SECONDS)
          .writeTimeout(DEFAULT_API_TIMEOUT_SEC, SECONDS)
          .build();
    }
  }

}
