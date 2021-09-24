package com.li.feeling.init.initmodule;

import android.content.Context;
import androidx.annotation.NonNull;

import com.li.framework_init.InitModule;
import com.li.library.retrofit_utlity.IRetrofitInitConfig;
import com.li.library.retrofit_utlity.RetrofitManager;

/**
 * description: 用于Retrofit初始化
 */
public class RetrofitInitModule implements InitModule {

  public static RetrofitInitModule getInstance() {
    return RetrofitInitModuleHolder.INSTANCE;
  }

  private static class RetrofitInitModuleHolder {
    static RetrofitInitModule INSTANCE = new RetrofitInitModule();
  }

  @Override
  public void init(@NonNull Context context) {
    IRetrofitInitConfig initConfig = new IRetrofitInitConfig() {
      @NonNull
      @Override
      public Context getContext() {
        return context;
      }
    };
    RetrofitManager.getInstance().init(initConfig);
  }

}
