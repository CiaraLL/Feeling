package com.li.feeling.common.like.likeservice;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.li.feeling.model.notification.FeelingNotification;

public class FeelLikeResponse implements Serializable {

  //通知列表数据
  @SerializedName("notificationList")
  @NonNull
  public List<FeelingNotification> mNotificationList;

  //底部提示
  @SerializedName("footerTip")
  @NonNull
  public String mFooterTip;

  public FeelLikeResponse(
      @NonNull List<FeelingNotification> notificationList, @NonNull String footerTip) {
    mNotificationList = notificationList;
    mFooterTip = footerTip;
  }
}
