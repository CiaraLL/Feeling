package com.li.feeling.notification.list.viewdata;

import com.li.feeling.notification.list.viewdata.type.NotificationListItemViewDataType;
import com.li.library.recycler.LiRecyclerItemViewData;

/**
 * feel点赞item
 */
public class NotificationListFeelLikeItemViewData implements LiRecyclerItemViewData{

  // 头像
  public int mAvatarResId;
  // 时间
  public String mTime;
  // 名字
  public String mName;
  // 通知文案
  public String mContent;

  @Override
  public int getItemViewDataType() {
    return NotificationListItemViewDataType.FEEL_LIKE;
  }
}
