package com.li.feeling.model.notification;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * description: 通知的类型
 */

@Retention(RetentionPolicy.SOURCE)
public @interface FeelingNotificationType {

  int FEEL_LIKE = 1; // 点赞通知

}
