package com.li.feeling.model.notification;

/**
 * description: 通知
 */
public interface FeelingNotification {

  /**
   * 消息的类型
   */
  @FeelingNotificationType
  int getType();

}
