package com.li.framework.retrofit_utility;

import androidx.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * description: retrofit工厂
 */
public class RetrofitFactory {

  /**
   * 创建retrofit的方法
   *
   * @param retrofitConfig 配置信息
   */
  public static Retrofit create(@NonNull IRetrofitConfig retrofitConfig) {
    Retrofit.Builder builder = new Retrofit.Builder()
        .baseUrl(retrofitConfig.getBaseUrl())
        .addConverterFactory(GsonConverterFactory.create(retrofitConfig.getGson()))
        .client(retrofitConfig.getClient());
    // 调用方指定的RxJava订阅(subscribe)时的调度器
    if (retrofitConfig.getSubscribeScheduler() != null) {
      builder.addCallAdapterFactory(
          RxJavaCallAdapterFactory.createWithScheduler(retrofitConfig.getSubscribeScheduler()));
    } else {
      builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
    }
    return builder.build();
  }

}
