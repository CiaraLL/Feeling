package com.li.feeling.home.feellist.viewdata;

import androidx.annotation.DrawableRes;

import com.li.library.recycler.LiRecyclerItemViewData;


/**
 * description: home页面的feel列表的feelItem的数据
 */
public class HomeFeelingListFeelItemViewData implements LiRecyclerItemViewData {

  // 头像资源
  @DrawableRes
  public int mAvatarResId;
  // 姓名
  public String mName;
  // 时间
  public String mTime;
  // 内容
  public String mContentText;
  // 点赞数
  public int mLikeNum;
  // 点赞过
  public boolean mIsLike;

  @Override
  public int getItemViewDataType() {
    return HomeFeelListItemViewDataType.FEEL_TYPE;
  }

}
