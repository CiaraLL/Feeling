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

  // 是否是第一次{@link onViewCreated}方法,因为fragment的onCreateView是会被多次调用的
  private boolean mIsFirstCallViewCreatedMethod = true;

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

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    onViewCreated(view, savedInstanceState, mIsFirstCallViewCreatedMethod);
    mIsFirstCallViewCreatedMethod = false;
  }

  /**
   * 推荐子类使用该方法
   * 为啥重载了onViewCreated方法呢，是因为该方法可以通过
   * 注意子类不能调super.onViewCreated
   * @param isFirstCall 该参数分辨出是否是第一次调用
   */
  public void onViewCreated(
      @NonNull View view,
      @Nullable Bundle savedInstanceState,
      boolean isFirstCall) { }

  // fragment的布局
  @LayoutRes
  protected abstract int getLayoutResId();


}
