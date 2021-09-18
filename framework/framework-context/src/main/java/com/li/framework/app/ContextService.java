package com.li.framework.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;

/**
 * description: 用于提供context上下文
 */
public class ContextService {

  // 该app进程下的Application对象
  private static Application sApplication;

  /**
   * 不允许业务调用，只能在启动的时候去设置
   */
  public static void setAppContext(@NonNull Application application) {
    sApplication = application;
  }

  // 全局上下文
  @NonNull
  public static Application getAppContext() {
    return sApplication;
  }

  // 获得当前的context,如果有activity正在运行，那么取最上层的activity
  @NonNull
  public static Context getCurrentContext() {
    // TODO: 9/17/21 获取当前最上层的activity
    Activity activity = null;
    return activity == null ? sApplication : activity;
  }

}
