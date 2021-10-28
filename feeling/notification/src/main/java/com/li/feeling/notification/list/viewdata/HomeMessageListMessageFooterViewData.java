package com.li.feeling.notification.list.viewdata;

import com.li.library.recycler.LiRecyclerItemViewData;

/**
 * 点赞消息列表的底部item的数据
 */
public class HomeMessageListMessageFooterViewData implements LiRecyclerItemViewData {

  //提示文案
  public String mTip;

  public HomeMessageListMessageFooterViewData(String tip) {
    mTip = tip;
  }

  @Override
  public int getItemViewDataType() {
    return HomeMessageListItemViewDataType.MESSAGE_FOOTER;
  }
}
