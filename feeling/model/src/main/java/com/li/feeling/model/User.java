package com.li.feeling.model;

import java.io.Serializable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * description: 用户信息
 */
public class User implements Serializable {

  // 空数据
  @NonNull
  public static final User EMPTY = new User();

  @SerializedName("id")
  public String mId;
  @SerializedName("phone")
  public String mPhone; // 手机号
  @SerializedName("password")
  public String mPassword; // 密码
  @SerializedName("nickname")
  public String mNickName; // 昵称
  @SerializedName("sex")
  public String mSex; // 性别,M代表男，F代表女

}
