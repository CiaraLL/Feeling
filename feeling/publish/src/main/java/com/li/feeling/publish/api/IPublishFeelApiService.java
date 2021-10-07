package com.li.feeling.publish.api;

import androidx.annotation.NonNull;

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
 * 发布feel的服务
 */
public interface IPublishFeelApiService {

  @NonNull
  IPublishFeelApiService sPublishService = RetrofitManager.getInstance()
      .create(new FeelingRetrofitConfig(FeelingUrl.PUBLISH, SchedulerManager.NETWORKING),
          IPublishFeelApiService.class);

  @NonNull
  static IPublishFeelApiService get() {
    return sPublishService;
  }

  @FormUrlEncoded
  @POST("/feeling/feel/publish")
  Observable<FeelingResponse<Boolean>> publish(
      @Field("userId") long userId, @Field("contentText") String contentText);
}
