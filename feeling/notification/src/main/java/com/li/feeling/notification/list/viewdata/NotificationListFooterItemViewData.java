package com.li.feeling.notification.list.viewdata;

import com.li.feeling.notification.list.viewdata.type.NotificationListItemViewDataType;
import com.li.library.recycler.LiRecyclerItemViewData;

/**
 * 底部item的数据
 */
public class NotificationListFooterItemViewData implements LiRecyclerItemViewData {

  //提示文案
  public String mTip;

  public NotificationListFooterItemViewData(String tip) {
    mTip = tip;
  }

  @Override
  public int getItemViewDataType() {
    return NotificationListItemViewDataType.FOOTER;
  }
}
