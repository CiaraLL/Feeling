package com.li.feeling.home;

import java.util.ArrayList;
import java.util.List;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.google.android.material.tabs.TabLayout;
import com.li.feeling.feellist.HomeFeelListFragment;
import com.li.feeling.message.MessageFragment;
import com.li.feeling.mine.MineFragment;
import com.li.tabfragment.TabFragment;
import com.li.tabfragment.TabFragmentItem;

/**
 * 首页面fragment
 */
public class HomeTabFragment extends TabFragment {

  // tab标签的文字大小
  private static final float TAB_TEXT_SIZE = 15f;

  @Override
  @LayoutRes
  protected int getLayoutId() {
    return R.layout.fragment_home_layout;
  }

  @NonNull
  @Override
  protected List<TabFragmentItem> getTabFragmentItems() {
    List<TabFragmentItem> tabFragmentItems = new ArrayList<>();
    tabFragmentItems.add(getFeelingListItem());
    tabFragmentItems.add(getMessageListItem());
    tabFragmentItems.add(getMineFragmentItem());
    return tabFragmentItems;
  }

  @NonNull
  private TabFragmentItem getFeelingListItem() {
    TabLayout.Tab tab = mTabLayout.newTab();
    tab.setCustomView(getTabView("主页"));
    return new TabFragmentItem(tab, new HomeFeelListFragment());
  }

  private TabFragmentItem getMessageListItem() {
    TabLayout.Tab tab = mTabLayout.newTab();
    tab.setCustomView(getTabView("消息"));
    return new TabFragmentItem(tab, new MessageFragment());
  }

  @NonNull
  private TabFragmentItem getMineFragmentItem() {
    TabLayout.Tab tab = mTabLayout.newTab();
    tab.setCustomView(getTabView("我的"));
    return new TabFragmentItem(tab, new MineFragment());
  }

  /**
   * 构建tab的view
   *
   * @param tabText tab的文字
   */
  @NonNull
  private View getTabView(@NonNull String tabText) {
    TextView textView = new TextView(getContext());
    textView.setText(tabText);
    textView.setTextSize(TAB_TEXT_SIZE);
    textView.setGravity(Gravity.CENTER);
    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT);
    textView.setLayoutParams(layoutParams);
    return textView;
  }

}