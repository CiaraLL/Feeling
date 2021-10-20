package com.li.feeling.common.like.likeservice;

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

// Feel点赞
public interface IFeelLikeApiService {

  //单例
  @NonNull
  IFeelLikeApiService sHomeFeelListLikeApiService = RetrofitManager.getInstance().create(
      new FeelingRetrofitConfig(FeelingUrl.LIKE, SchedulerManager.NETWORKING),
      IFeelLikeApiService.class);

  static IFeelLikeApiService get() {
    return sHomeFeelListLikeApiService;
  }

  //点赞
  @FormUrlEncoded
  @POST("feeling/feel/like")
  Observable<FeelingResponse<Boolean>> like(
      @Field("feelId") long feelId,
      @Field("userId") long userId);

  //取消点赞
  @FormUrlEncoded
  @POST("/feeling/feel/cancellike")
  Observable<FeelingResponse<Boolean>> cancelLike(
      @Field("feelId") long feelId,
      @Field("userId") long userID);
}
