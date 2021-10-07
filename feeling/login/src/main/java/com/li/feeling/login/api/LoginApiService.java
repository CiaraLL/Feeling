package com.li.feeling.login.api;

import com.li.feeling.model.User;
import com.li.framework.network.FeelingResponse;
import com.li.framework.network.FeelingRetrofitConfig;
import com.li.framework.network.FeelingUrl;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.retrofit_utlity.RetrofitManager;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * description: 登陆的请求
 */
public interface LoginApiService {

  // 单例
  LoginApiService sLoginApiService = RetrofitManager.getInstance()
      .create(new FeelingRetrofitConfig(FeelingUrl.LOGIN, SchedulerManager.NETWORKING),
          LoginApiService.class);

  static LoginApiService get() {
    return sLoginApiService;
  }

  // 登陆请求
  @FormUrlEncoded
  @POST("feeling/user/login")
  Observable<FeelingResponse<User>> login(
      @Field("phone") String phone,
      @Field("password") String password);

}


