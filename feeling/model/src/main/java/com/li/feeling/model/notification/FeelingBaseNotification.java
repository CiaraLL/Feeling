package com.li.feeling.model.notification;

/**
 * description: 通知的基类
 */
public abstract class FeelingBaseNotification implements FeelingNotification{

  // 通知的时间
  private long mTime;

  public FeelingBaseNotification(long time) {
    mTime = time;
  }

  public long getTime() {
    return mTime;
  }

  public void setTime(long time) {
    mTime = time;
  }

}
