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

  private Retrofit createRetrofit(@NonNull IRetrofitConfig retrofitConfig) {
    return null;
  }

}
