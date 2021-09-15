package com.li.framework.retrofit_utility;

import androidx.annotation.NonNull;

import retrofit2.Retrofit;

/**
 * description: retrofit工厂
 */
public class RetrofitFactory {

  public static Retrofit create(@NonNull IRetrofitConfig retrofitConfig) {
    return new Retrofit.Builder().build();
  }

}
