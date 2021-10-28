package com.li.feeling.notification.list.viewdata.type;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

/**
 * 通知列表Item 的类型
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({NotificationListItemViewDataType.FEEL_LIKE,
    NotificationListItemViewDataType.FOOTER})
public @interface NotificationListItemViewDataType {

  int FOOTER = 1;
  int FEEL_LIKE = 2; // feel的点赞

}
