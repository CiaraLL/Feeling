package com.li.feeling.feellist.service;

import androidx.annotation.NonNull;

import com.li.framework.network.FeelingResponse;
import com.li.framework.network.FeelingRetrofitConfig;
import com.li.framework.network.FeelingUrl;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.retrofit_utlity.RetrofitManager;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * description: feel列表数据服务
 */
public interface IHomeFeelListApiService {

  // 单例
  @NonNull
  IHomeFeelListApiService sFeelListApiService = RetrofitManager.getInstance().create(
      new FeelingRetrofitConfig(FeelingUrl.HOME_FEEL_LIST, SchedulerManager.NETWORKING),
      IHomeFeelListApiService.class);

  @NonNull
  static IHomeFeelListApiService get() {
    return sFeelListApiService;
  }

  // 获取列表数据
  @POST("/feeling/feel/home/list")
  Observable<FeelingResponse<HomeFeelListResponse>> getFeelListData();

}
