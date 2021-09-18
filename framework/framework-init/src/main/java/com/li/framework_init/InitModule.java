package com.li.framework_init;

import android.content.Context;
import androidx.annotation.NonNull;

/**
 * description: 用于模块初始化
 */
public interface InitModule {

  /**
   * 模块初始化的入口
   */
  void init(@NonNull Context context);

}
