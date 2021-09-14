package com.li.framework.retrofit_utility;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

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

  public <T> T create(Class<T> service) {
    return new Retrofit.Builder()
        .baseUrl("http://192.168.1.8:8080")
        .addConverterFactory(GsonConverterFactory.create()) //gson的转换工厂
        .build()
        .create(service);
  }

}
