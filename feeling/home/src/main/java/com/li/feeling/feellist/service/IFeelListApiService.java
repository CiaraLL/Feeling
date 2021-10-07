package com.li.feeling.feellist.service;

import androidx.annotation.NonNull;

import com.li.framework.network.FeelingResponse;
import com.li.framework.network.FeelingRetrofitConfig;
import com.li.framework.network.FeelingUrl;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.retrofit_utlity.RetrofitManager;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * description: feel列表数据服务
 */
public interface IFeelListApiService {

  // 单例
  @NonNull
  IFeelListApiService sFeelListApiService = RetrofitManager.getInstance().create(
      new FeelingRetrofitConfig(FeelingUrl.FEEL_LIST, SchedulerManager.NETWORKING),
      IFeelListApiService.class);

  @NonNull
  static IFeelListApiService get() {
    return sFeelListApiService;
  }

  // 获取列表数据
  @POST("/feeling/feel/list")
  Observable<FeelingResponse<FeelListResponse>> getFeelListData();

}
