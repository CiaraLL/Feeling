package com.li.feeling.notification.list.api;

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
 * description: 通知的api服务
 */
public interface INotificationApiService {

  // 单例
  @NonNull
  INotificationApiService sNotificationApiService =
      RetrofitManager.getInstance().create(
          new FeelingRetrofitConfig(FeelingUrl.NOTIFICATION, SchedulerManager.NETWORKING),
          INotificationApiService.class);

  @NonNull
  static INotificationApiService get() {
    return sNotificationApiService;
  }

  // 获取通知列表
  @POST("/feeling/feel/notification/list")
  @FormUrlEncoded
  Observable<FeelingResponse<NotificationListResponse>> getNotificationListData(@Field("userId") long userId);

}
