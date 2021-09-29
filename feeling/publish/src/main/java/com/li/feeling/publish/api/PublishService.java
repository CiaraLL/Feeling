package com.li.feeling.publish.api;

import com.li.feeling.model.Feel;
import com.li.framework.network.FeelingResponse;
import com.li.framework.network.FeelingRetrofitConfig;
import com.li.framework.network.FeelingUrl;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.retrofit_utlity.RetrofitManager;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PublishService {

  PublishService sPublishService = RetrofitManager.getInstance()
      .create(new FeelingRetrofitConfig(FeelingUrl.PUBLISH, SchedulerManager.NETWORKING),
          PublishService.class);

  static PublishService get(){
    return sPublishService;
  }

  @FormUrlEncoded
  @POST("/feeling/user/publish")
  Observable<FeelingResponse<Feel>> publish();
}
