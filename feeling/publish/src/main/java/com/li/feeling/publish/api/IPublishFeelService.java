package com.li.feeling.publish.api;

import androidx.annotation.NonNull;

import com.li.feeling.model.Feel;
import com.li.framework.network.FeelingResponse;
import com.li.framework.network.FeelingRetrofitConfig;
import com.li.framework.network.FeelingUrl;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.retrofit_utlity.RetrofitManager;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IPublishFeelService {

  @NonNull
  IPublishFeelService sPublishService = RetrofitManager.getInstance()
      .create(new FeelingRetrofitConfig(FeelingUrl.PUBLISH, SchedulerManager.NETWORKING),
          IPublishFeelService.class);

  @NonNull
  static IPublishFeelService get() {
    return sPublishService;
  }

  @FormUrlEncoded
  @POST("/feeling/feel/publish")
  Observable<FeelingResponse<Feel>> publish();
}
