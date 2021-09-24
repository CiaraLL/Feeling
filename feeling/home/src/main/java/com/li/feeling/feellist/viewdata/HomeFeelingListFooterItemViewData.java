package com.li.feeling.feellist.viewdata;


import com.li.library.recycler.LiRecyclerItemViewData;

/**
 * description: home页面的feel列表的footerItem的数据
 */
public class HomeFeelingListFooterItemViewData implements LiRecyclerItemViewData {

  // 提示文案
  public String mTip;

  public HomeFeelingListFooterItemViewData(String tip) {
    mTip = tip;
  }

  @Override
  public int getItemViewDataType() {
    return HomeFeelListItemViewDataType.FOOTER_TYPE;
  }

}