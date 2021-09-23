package com.li.tabfragment;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

/**
 * tabFragment的"一页"
 */
public class TabFragmentItem {

  @NonNull
  public TabLayout.Tab mTab;
  @NonNull
  public Fragment mFragment;

  public TabFragmentItem(@NonNull TabLayout.Tab tab, @NonNull Fragment fragment) {
    mTab = tab;
    mFragment = fragment;
  }
}
