package com.li.feeling.home;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.google.android.material.tabs.TabLayout;
import com.li.feeling.find.FindFragment;
import com.li.feeling.homefeelinglist.HomeFeelingListFragment;
import com.li.feeling.message.MessageFragment;
import com.li.feeling.mine.MineFragment;
import com.li.tabfragment.TabFragment;
import com.li.tabfragment.TabFragmentDelegates;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页面fragment
 */
public class HomeTabFragment extends TabFragment {

    @Override
    @LayoutRes
    protected int getLayoutId() {
        return R.layout.fragment_home_layout;
    }

    @Override
    protected List<TabFragmentDelegates> getFragmentDelegates() {
        List<TabFragmentDelegates> fragmentDelegates = new ArrayList<>();
        fragmentDelegates.add(getFeelingListDelegates());
        fragmentDelegates.add(getFindListDelegates());
        fragmentDelegates.add(getMessageListDelegates());
        fragmentDelegates.add(getMineFragmentDelegate());
        return fragmentDelegates
                ;
    }

    @NonNull
    private TabFragmentDelegates getFeelingListDelegates() {
        TabLayout.Tab tab = mTabLayout.newTab();
        tab.setCustomView(getTabView("主页"));
        return new TabFragmentDelegates(tab, new HomeFeelingListFragment());
    }

    private TabFragmentDelegates getMessageListDelegates(){
        TabLayout.Tab tab = mTabLayout.newTab();
        tab.setCustomView(getTabView("消息"));
        return new TabFragmentDelegates(tab,new MessageFragment());
    }

    private TabFragmentDelegates getFindListDelegates(){
        TabLayout.Tab tab = mTabLayout.newTab();
        tab.setCustomView(getTabView("发现"));
        return new TabFragmentDelegates(tab,new FindFragment());
    }
    @NonNull
    private TabFragmentDelegates getMineFragmentDelegate() {
        TabLayout.Tab tab = mTabLayout.newTab();
        tab.setCustomView(getTabView("我的"));
        return new TabFragmentDelegates(tab, new MineFragment());
    }

    /**
     * 构建tab的view
     *
     * @param tabText tab的文字
     * @return
     */
    private View getTabView(@NonNull String tabText) {
        TextView textView = new TextView(getContext());
        textView.setText(tabText);
        textView.setTextSize(15);
        textView.setGravity(Gravity.CENTER);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(layoutParams);
        return textView;
    }
}