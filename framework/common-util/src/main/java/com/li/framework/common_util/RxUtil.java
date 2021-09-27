package com.li.framework.common_util;

import androidx.annotation.Nullable;

import io.reactivex.disposables.Disposable;

/**
 * description: RxJava的一些工具方法
 */
public class RxUtil {

  // 销毁一个disposable
  public static void dispose(@Nullable Disposable disposiable) {
    if (disposiable != null) {
      disposiable.dispose();
    }
  }

}
