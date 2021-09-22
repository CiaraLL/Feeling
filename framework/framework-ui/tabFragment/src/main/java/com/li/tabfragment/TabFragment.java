package com.li.tabfragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.li.framework.tabfragment.R;

import java.util.ArrayList;
import java.util.List;

public abstract class TabFragment extends Fragment {

    private View mViewContainer;
    private ViewPager mFragmentPager;
    protected TabLayout mTabLayout;
    private FragmentStatePagerAdapter mPagerAdapter;

    private TabLayout.OnTabSelectedListener mTabSelectedListener = new TabLayout.OnTabSelectedListener() {
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

    private void setSelect(int position) {
        mFragmentPager.setCurrentItem(position);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mViewContainer != null) {
            return mViewContainer;
        }
        return mViewContainer = inflater.inflate(getLayoutId(), container, false);
    }

    protected abstract int getLayoutId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentPager = view.findViewById(R.id.fragment_pager);
        mTabLayout = view.findViewById(R.id.tab_container);

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

    private List<TabLayout.Tab> getTabList() {
        List<TabLayout.Tab> tabs = new ArrayList<>();
        List<TabFragmentDelegates> fragmentDelegates = getFragmentDelegates();
        for (TabFragmentDelegates tabFragmentDelegates : fragmentDelegates) {
            tabs.add(tabFragmentDelegates.mTab);
        }
        return tabs;
    }

    protected abstract List<TabFragmentDelegates> getFragmentDelegates();

    private List<Fragment> getFragmentList() {
        List<Fragment> fragments = new ArrayList<>();
        List<TabFragmentDelegates> fragmentDelegates = getFragmentDelegates();
        for (TabFragmentDelegates tabFragmentDelegates : fragmentDelegates) {
            fragments.add(tabFragmentDelegates.mFragment);
        }
        return fragments;
    }
}