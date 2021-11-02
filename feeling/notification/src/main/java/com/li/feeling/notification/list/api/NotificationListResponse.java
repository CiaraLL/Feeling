package com.li.feeling.notification.list.api;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.li.feeling.model.notification.FeelingBaseNotification;

/**
 * description: 通知列表的接口回执
 */
// TODO: 各类通知都有自己单独的接口？
public class NotificationListResponse implements Serializable {

  @SerializedName("notificationList")
  @NonNull
  public List<FeelingBaseNotification> mNotificationList; // 列表数据

  @SerializedName("footerTip")
  public String mFooterTip; // 底部提示(前段滑到底部时的提示)

  public NotificationListResponse(
      @NonNull List<FeelingBaseNotification> notificationList,
      String footerTip) {
    mNotificationList = notificationList;
    mFooterTip = footerTip;
  }

}
