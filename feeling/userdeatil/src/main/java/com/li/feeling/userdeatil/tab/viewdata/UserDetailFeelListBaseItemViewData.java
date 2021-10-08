package com.li.feeling.userdeatil.tab.viewdata;

import androidx.annotation.DrawableRes;

import com.li.library.recycler.LiRecyclerItemViewData;

public class UserDetailFeelListBaseItemViewData implements LiRecyclerItemViewData {

  // 头像资源
  @DrawableRes
  public int mAvatarResId;

  public UserDetailFeelListBaseItemViewData() {
  }

  public UserDetailFeelListBaseItemViewData(int avatarResId, String name, String time,
      String contentText, int likeNum) {
    mAvatarResId = avatarResId;
    mName = name;
    mTime = time;
    mContentText = contentText;
    mLikeNum = likeNum;
  }

  // 姓名
  public String mName;
  // 时间
  public String mTime;
  // 内容
  public String mContentText;
  // 点赞数
  public int mLikeNum;

  @Override
  public int getItemViewDataType() {
    return UserDetailFeelListItemViewDataType.FEEL_TYPE;
  }
}
