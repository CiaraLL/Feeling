package com.li.feeling.userdeatil.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.li.feeling.model.Feel;

/**
 * description: 用户详情页面--feel列表接口的response
 */
public class UserDetailFeelListResponse implements Serializable {

  @SerializedName("feelList")
  public List<Feel> mFeelList; // 列表数据

  @SerializedName("footerTip")
  public String mFooterTip; // 底部提示(前段滑到底部时的提示)

}
