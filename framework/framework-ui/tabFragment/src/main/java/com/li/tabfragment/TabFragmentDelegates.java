package com.li.tabfragment;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class TabFragmentDelegates {

    @NonNull
    public TabLayout.Tab mTab;
    @NonNull
    public Fragment mFragment;

    public TabFragmentDelegates(@NonNull TabLayout.Tab mTab, @NonNull Fragment mFragment) {
        this.mTab = mTab;
        this.mFragment = mFragment;
    }
}
