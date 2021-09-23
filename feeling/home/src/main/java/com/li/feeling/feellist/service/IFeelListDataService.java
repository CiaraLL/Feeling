package com.li.feeling.feellist.service;

import java.util.List;

import androidx.annotation.NonNull;

import com.li.feeling.model.Feel;

/**
 * description: feel列表数据服务
 */
public interface IFeelListDataService {

  // 获取列表数据
  @NonNull
  List<Feel> getFeelListData();

}
