package com.li.library.tabfragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public abstract class TabFragment extends Fragment {

    private View mViewContainer;
    private ViewPager mFragmentPager;
    protected TabLayout mTabLayout;
    private FragmentStatePagerAdapter mPagerAdapter;

    @NonNull
    private TabLayout.OnTabSelectedListener mTabSelectedListener =
            new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    setSelect(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mViewContainer != null) {
            return mViewContainer;
        }
        return mViewContainer = inflater.inflate(
                getLayoutId(),
                container,
                false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentPager = view.findViewById(R.id.view_pager);
        mTabLayout = view.findViewById(R.id.tab_layout);

        //初始化tablayout
        mTabLayout.setOnTabSelectedListener(mTabSelectedListener);
        List<TabLayout.Tab> tabList = getTabList();
        for (TabLayout.Tab tab : tabList) {
            mTabLayout.addTab(tab);
        }

        //初始化fragment
        List<Fragment> fragmentList = getFragmentList();
        mPagerAdapter = new FragmentStatePagerAdapter(getFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        mFragmentPager.setAdapter(mPagerAdapter);
        mFragmentPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    @LayoutRes
    protected abstract int getLayoutId();

    @NonNull
    protected abstract List<TabFragmentItem> getTabFragmentItems();

    // 选中某页
    private void setSelect(int position) {
        mFragmentPager.setCurrentItem(position);
    }

    //获得所有的tab
    @NonNull
    private List<TabLayout.Tab> getTabList() {
        List<TabLayout.Tab> tabs = new ArrayList<>();
        List<TabFragmentItem> tabFragmentItems = getTabFragmentItems();
        for (TabFragmentItem tabFragmentItem : tabFragmentItems) {
            tabs.add(tabFragmentItem.mTab);
        }
        return tabs;
    }

    //获得所有fragment
    @NonNull
    private List<Fragment> getFragmentList() {
        List<Fragment> fragments = new ArrayList<>();
        List<TabFragmentItem> tabFragmentItems = getTabFragmentItems();
        for (TabFragmentItem tabFragmentItem : tabFragmentItems) {
            fragments.add(tabFragmentItem.mFragment);
        }
        return fragments;
    }
}