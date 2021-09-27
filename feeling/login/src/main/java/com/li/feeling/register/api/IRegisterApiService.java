package com.li.feeling.register.api;

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

public interface IRegisterApiService {

    IRegisterApiService sRegisterApiService = RetrofitManager.getInstance().create(
        new FeelingRetrofitConfig(FeelingUrl.REGISTER, SchedulerManager.NETWORKING),
        IRegisterApiService.class);

    static IRegisterApiService get() {
        return sRegisterApiService;
    }

    @FormUrlEncoded
    @POST("feeling/user/register")
    Observable<FeelingResponse<User>> register(@Field("phone") String phone, @Field("password") String password);
}
