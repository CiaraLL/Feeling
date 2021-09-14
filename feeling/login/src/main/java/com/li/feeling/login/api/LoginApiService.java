package com.li.feeling.login.api;

import com.li.feeling.login.LoginFragment;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * description: 登陆的请求
 */
public interface LoginApiService {

  // 登陆请求
  @FormUrlEncoded
  @POST("/user/login")
  Call<LoginFragment.User> login(@Field("account") String account, @Field("password") String password);

}
