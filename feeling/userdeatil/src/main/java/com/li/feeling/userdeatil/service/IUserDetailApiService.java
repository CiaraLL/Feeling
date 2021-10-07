package com.li.feeling.userdeatil.service;

import androidx.annotation.NonNull;

import com.li.framework.network.FeelingResponse;
import com.li.framework.network.FeelingRetrofitConfig;
import com.li.framework.network.FeelingUrl;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.retrofit_utlity.RetrofitManager;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * description: 用户详情页面的service
 */
public interface IUserDetailApiService {

  // 单例
  @NonNull
  IUserDetailApiService sApiService = RetrofitManager.getInstance().create(
      new FeelingRetrofitConfig(FeelingUrl.USER_DETAIL, SchedulerManager.NETWORKING),
      IUserDetailApiService.class);

  @NonNull
  static IUserDetailApiService get() {
    return sApiService;
  }

  // 获取用户自己发布的feel列表数据
  @POST("/feeling/feel/user/published/list")
  Observable<FeelingResponse<UserDetailFeelListResponse>> getUserPublishedFeelListData();

  // 获取用户点赞的feel列表数据
  @POST("/feeling/feel/user/like/list")
  Observable<FeelingResponse<UserDetailFeelListResponse>> getUserLikeFeelListData();

}
