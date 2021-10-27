package com.li.message.like.viewdata;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

/**
 * 点赞消息列表Item 的类型
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({HomeMessageListItemViewDataType.MESSAGE_ITEM,
    HomeMessageListItemViewDataType.MESSAGE_FOOTER})
public @interface HomeMessageListItemViewDataType {

  int MESSAGE_ITEM = 1;//消息内容item
  int MESSAGE_FOOTER = 2;//消息footerItem
}
