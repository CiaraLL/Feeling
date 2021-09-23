package com.li.feeling.feellist.service;

import java.util.ArrayList;
import java.util.List;

import android.os.SystemClock;
import androidx.annotation.NonNull;

import com.li.feeling.model.Feel;
import com.li.feeling.model.User;

/**
 * description: 一个简单的实现类
 */
public class IFeelListDataServiceImpl implements IFeelListDataService {

  @NonNull
  @Override
  public List<Feel> getFeelListData() {
    List<Feel> feelList = new ArrayList<>();
    for (int i = 0; i < 20; ++i) {
      Feel feel = new Feel();
      feel.mUser = new User();
      feel.mUser.mNickName = i + "莉莉";
      feel.mPublishTime = SystemClock.elapsedRealtime();
      feel.mContentText = i + "内容文案";
      feel.mLikeNum = i;

      feelList.add(feel);
    }
    return feelList;
  }
}
