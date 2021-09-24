package com.li.library.retrofit_utlity;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import rx.Scheduler;

/**
 * description: retrofit的一些配置
 */
public interface IRetrofitConfig {

  // gson
  @NonNull
  Gson getGson();

  // 一般用域名
  @NonNull
  String getBaseUrl();

  // 用于配置一些请求配置，比如超时、添加一些拦截器(okHttpClient.addIntercept)
  @NonNull
  OkHttpClient getClient();

  // rxJava在订阅(Subscribe)时用的调度器：其实就是网络请求时用什么调度器
  Scheduler getSubscribeScheduler();

}
