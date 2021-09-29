package com.li.fragment.base_page.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * description: fragment基类
 */
public abstract class BaseFragment extends Fragment {

  // fragment的根view
  @Nullable
  private View mRootView;

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    // 该方法会被调用多次，因此缓存了mRootView
    if (mRootView == null) {
      mRootView = inflater.inflate(getLayoutResId(), container, false);
    }
    return mRootView;
  }

  // fragment的布局
  @LayoutRes
  protected abstract int getLayoutResId();

}
