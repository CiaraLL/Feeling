package com.li.framework.ui.utility;

import android.os.SystemClock;
import android.view.View;

/**
 * description: 用来过滤点击事件
 */
public abstract class DuplicatedClickFilter implements View.OnClickListener {

  // 一秒内只允许响应一次点击
  private static final long CLICK_INTERVAL_MS = 1000L;

  // 上一次点击的时间
  private long mLastClickTimeMs;

  @Override
  public void onClick(View view) {
    long currentTimeMS = SystemClock.elapsedRealtime();
    if (currentTimeMS - mLastClickTimeMs > CLICK_INTERVAL_MS) {
      // mLastClickTimeMs的赋值一定不能放在handleClickEvent之后，
      // 因为不确定handleClickEvent函数内会执行多久才结束，比如这个函数执行了1.5秒
      mLastClickTimeMs = currentTimeMS;
      handleClickEvent();
    }
  }

  // 子类实现具体的点击事件处理
  protected abstract void handleClickEvent();

}
