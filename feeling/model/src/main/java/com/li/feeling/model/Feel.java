package com.li.feeling.model;

import java.io.Serializable;

/**
 * description: feel
 */
public class Feel implements Serializable {

  // 所属者
  public User mUser;
  // 发布时间
  public long mPublishTime;
  // 内容文案
  public String mContentText;

  // 点赞数
  public int mLikeNum;

}
