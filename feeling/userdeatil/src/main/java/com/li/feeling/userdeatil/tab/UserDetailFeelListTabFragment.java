package com.li.feeling.userdeatil.tab;

import java.util.ArrayList;
import java.util.List;

import android.content.res.ColorStateList;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;

import com.google.android.material.tabs.TabLayout;
import com.li.feeling.userdeatil.R;
import com.li.feeling.userdeatil.tab.feellist.like.UserDetailLikeFeelListFragment;
import com.li.feeling.userdeatil.tab.feellist.published.UserDetailPublishedFeelListFragment;
import com.li.framework.common_util.ColorUtil;
import com.li.library.tabfragment.TabFragment;
import com.li.library.tabfragment.TabFragmentItem;

/**
 * description: 用户详情页面的feel列表tabFragment
 */
public class UserDetailFeelListTabFragment extends TabFragment {

  // tab标签的文字大小
  private static final float TAB_TEXT_SIZE = 15f;
  // tab选中和未选中时的文案颜色
  @ColorRes
  private static final int TAB_TEXT_SELECTED_COLOR =
      ColorUtil.color(R.color.color_base_cyan_6);
  @ColorRes
  private static final int TAB_TEXT_UNSELECT_COLOR = ColorUtil.color(R.color.color_base_black);

  @Override
  protected int getLayoutId() {
    return R.layout.fragment_user_detail_tab_layout;
  }

  @NonNull
  @Override
  protected List<TabFragmentItem> getTabFragmentItems() {
    List<TabFragmentItem> tabFragmentItems = new ArrayList<>();
    tabFragmentItems.add(getUserPublishedFeelListItem());
    tabFragmentItems.add(getUserLikeFeelListItem());
    return tabFragmentItems;
  }

  // 用户发布的feel列表
  @NonNull
  private TabFragmentItem getUserPublishedFeelListItem() {
    TabLayout.Tab tab = mTabLayout.newTab();
    tab.setCustomView(getTabView("Feel"));
    return new TabFragmentItem(tab, new UserDetailPublishedFeelListFragment());
  }

  // 用户点赞的feel列表
  private TabFragmentItem getUserLikeFeelListItem() {
    TabLayout.Tab tab = mTabLayout.newTab();
    tab.setCustomView(getTabView("点赞"));
    return new TabFragmentItem(tab, new UserDetailLikeFeelListFragment());
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
    textView.setTextColor(new ColorStateList(
        new int[][]{
            new int[]{android.R.attr.state_selected},
            new int[]{-android.R.attr.state_selected}},
        new int[]{TAB_TEXT_SELECTED_COLOR, TAB_TEXT_UNSELECT_COLOR}));
    textView.setGravity(Gravity.CENTER);
    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT);
    textView.setLayoutParams(layoutParams);
    return textView;
  }

}
