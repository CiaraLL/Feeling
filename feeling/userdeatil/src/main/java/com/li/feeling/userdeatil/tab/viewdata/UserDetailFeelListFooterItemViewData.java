package com.li.feeling.userdeatil.tab.viewdata;

import com.li.library.recycler.LiRecyclerItemViewData;

public class UserDetailFeelListFooterItemViewData implements LiRecyclerItemViewData {

  // 提示文案
  public String mTip;

  public UserDetailFeelListFooterItemViewData(String tip) {
    mTip = tip;
  }

  @Override
  public int getItemViewDataType() {
    return UserDetailFeelListItemViewDataType.FOOTER_TYPE;
  }
}
