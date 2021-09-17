package com.li.feeling.init.initmodule;

import android.content.Context;
import androidx.annotation.NonNull;

import com.li.framework.netwoek.retrofit_utility.IRetrofitInitConfig;
import com.li.framework.netwoek.retrofit_utility.RetrofitManager;
import com.li.framework_init.InitModule;

/**
 * description: 用于Retrofit初始化
 */
public class RetrofitInitModule implements InitModule {

  @Override
  public void init() {
    IRetrofitInitConfig initConfig = new IRetrofitInitConfig() {
      @NonNull
      @Override
      public Context getContext() {
        // TODO: 9/17/21 传入context
        return null;
      }
    };
    RetrofitManager.getInstance().init(initConfig);
  }

}