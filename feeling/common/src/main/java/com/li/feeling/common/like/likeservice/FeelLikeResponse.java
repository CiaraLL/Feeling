package com.li.feeling.common.like.likeservice;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.li.feeling.model.notification.FeelingNotification;

/**
 * 点赞接口的回执
 */
public class FeelLikeResponse implements Serializable {

  // 点赞的feelId
  @SerializedName("feelId")
  public long mFeelId;

  // 该feel的点赞数
  @SerializedName("likeNum")
  public int mLikeNum;

}
