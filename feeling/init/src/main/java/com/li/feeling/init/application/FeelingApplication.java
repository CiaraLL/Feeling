package com.li.feeling.init.application;

import android.app.Application;
import android.content.Context;

/**
 * description: 整个app的application: app的启动点
 */
public class FeelingApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
  }

  // 调用时机比onCreate()早
  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
  }

}
