package com.li.framework.retrofit_utility;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;

/**
 * description: retrofit的一些配置
 */
public interface IRetrofitConfig {

  // gson
  @NonNull
  Gson buildGson();

  // 一般用域名
  @NonNull
  String buildBaseUrl();

  // 用于配置一些请求配置，比如超时、添加一些拦截器(okHttpClient.addIntercept)
  @NonNull
  OkHttpClient buildClient();

}
