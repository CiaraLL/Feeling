package com.li.message.like.viewdata;

import android.widget.ImageView;
import android.widget.TextView;

import com.li.library.recycler.LiRecyclerItemViewData;

/**
 * 点赞消息列表的内容item
 */
public class HomeMessageListMessageItemViewData implements LiRecyclerItemViewData{

  //头像
  public int mAvatarResId;
  //点赞的时间
  public String  mTime;
  //点赞的用户名字
  public String mName;

  @Override
  public int getItemViewDataType() {
    return HomeMessageListItemViewDataType.MESSAGE_ITEM;
  }
}
