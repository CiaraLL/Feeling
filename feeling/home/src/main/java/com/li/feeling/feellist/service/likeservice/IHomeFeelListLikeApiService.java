package com.li.feeling.feellist.service.likeservice;

import androidx.annotation.NonNull;

import com.li.feeling.model.Feel;
import com.li.framework.network.FeelingResponse;
import com.li.framework.network.FeelingRetrofitConfig;
import com.li.framework.network.FeelingUrl;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.retrofit_utlity.RetrofitManager;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IHomeFeelListLikeApiService {

  //单例
  @NonNull
  IHomeFeelListLikeApiService sHomeFeelListLikeApiService = RetrofitManager.getInstance().create(
      new FeelingRetrofitConfig(FeelingUrl.LIKE, SchedulerManager.NETWORKING),
      IHomeFeelListLikeApiService.class);

  static IHomeFeelListLikeApiService get() {
    return sHomeFeelListLikeApiService;
  }

  //点赞
  @FormUrlEncoded
  @POST("feeling/feel/home/list/like")
  Observable<FeelingResponse<Boolean>> like(
      @Field("feelId") long feelId,
      @Field("userId") long userId);

  //取消点赞
  @FormUrlEncoded
  @POST("feeling/feel/home/list/like")
  Observable<FeelingResponse<Boolean>> cancelLike(
      @Field("feelId") long feelId,
      @Field("userId") long userID);
}
