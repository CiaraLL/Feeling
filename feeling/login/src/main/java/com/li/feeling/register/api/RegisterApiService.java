package com.li.feeling.register.api;

import com.li.feeling.model.Feel;
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

public interface RegisterApiService {

    RegisterApiService mRegisterApiService = RetrofitManager.getInstance().create(
            new FeelingRetrofitConfig(FeelingUrl.REGISTER, SchedulerManager.NETWORKING)
            , RegisterApiService.class);

    static RegisterApiService get() {
        return mRegisterApiService;
    }

    @FormUrlEncoded
    @POST("feeling/user/register")
    Observable<FeelingResponse<User>> register(@Field("account") String account, @Field("password") String password);
}
