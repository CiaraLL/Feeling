package com.li.library.retrofit_utlity;

import androidx.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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
    // 调用方指定的RxJava订阅(subscribe)过程中使用的调度器
    if (retrofitConfig.getSubscribeScheduler() != null) {
      builder.addCallAdapterFactory(
          RxJava2CallAdapterFactory.createWithScheduler(retrofitConfig.getSubscribeScheduler()));
    } else {
      builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    return builder.build();
  }
}
