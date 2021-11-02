package com.li.feeling.model.notification;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * description: 通知的基类
 */
public abstract class FeelingBaseNotification implements Serializable {

  public static final String TYPE_KEY = "type";

  // 类型
  @SerializedName(TYPE_KEY)
  @FeelingNotificationType
  private int mType;

  // 通知的时间
  @SerializedName("time")
  private long mTime;

  public FeelingBaseNotification(@FeelingNotificationType int type, long time) {
    mType = type;
    mTime = time;
  }

  public int getType() {
    return mType;
  }

  public long getTime() {
    return mTime;
  }

  public void setTime(long time) {
    mTime = time;
  }

}
