package com.li.feeling.userdeatil.tab.feellist;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.fragment.base_page.fragment.BaseFragment;

/**
 * description: 用户详情页面的feel列表，目前有两种列表
 * 1. 用户自己发布的feel列表
 * 2. 用户点赞的feel列表
 */
public abstract class UserDetailFeelListBaseFragment extends BaseFragment {
  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }
}
