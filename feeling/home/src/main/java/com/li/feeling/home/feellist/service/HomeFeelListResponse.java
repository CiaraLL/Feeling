package com.li.feeling.home.feellist.service;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.li.feeling.model.Feel;

/**
 * description: feel列表接口的返回
 */
public class HomeFeelListResponse implements Serializable {

  @SerializedName("feelList")
  @NonNull
  public List<Feel> mFeelList; // 列表数据

  @SerializedName("footerTip")
  public String mFooterTip; // 底部提示(前段滑到底部时的提示)

  public HomeFeelListResponse(@NonNull List<Feel> mFeelList, String mFooterTip) {
    this.mFeelList = mFeelList;
    this.mFooterTip = mFooterTip;
  }
}
