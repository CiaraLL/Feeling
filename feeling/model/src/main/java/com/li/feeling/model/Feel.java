package com.li.feeling.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * description: feel
 */
public class Feel implements Serializable {

  @SerializedName("id")
  public long mId;
  // 所属者
  @SerializedName("user")
  public User mUser;
  // 发布时间
  @SerializedName("publishTime")
  public long mPublishTime;
  // 内容文案
  @SerializedName("contentText")
  public String mContentText;

  // 点赞数
  @SerializedName("likeNum")
  public int mLikeNum;

  // 自己是否点赞过
  @SerializedName("isLike")
  public boolean mIsLike;

  public Feel() {

  }
}
