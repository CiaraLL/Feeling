package com.li.framework.retrofit_utility;

import static java.util.concurrent.TimeUnit.SECONDS;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;

/**
 * description: IRetrofitConfig的基类
 */
public abstract class BaseRetrofitConfig implements IRetrofitConfig {

  @NonNull
  @Override
  public Gson buildGson() {
    return GsonHolder.sGson;
  }

  @NonNull
  @Override
  public OkHttpClient buildClient() {
    return ClientHolder.sOkHttpClient;
  }

  // 默认就是一个没有任何自定义配置的gson对象
  private static class GsonHolder {
    static Gson sGson = new Gson();
  }

  // 只配置了超时时间
  private static class ClientHolder {
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
