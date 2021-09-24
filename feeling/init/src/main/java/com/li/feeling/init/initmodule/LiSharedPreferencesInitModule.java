package com.li.feeling.init.initmodule;

import android.content.Context;
import androidx.annotation.NonNull;

import com.li.framework_init.InitModule;
import com.li.library.sharedpreferences_utility.LiSharedPreferences;

/**
 * description: 初始化SharedPreference
 */
public class LiSharedPreferencesInitModule implements InitModule {

  public static LiSharedPreferencesInitModule getInstance() {
    return LiSharedPreferencesInitModuleHolder.INSTANCE;
  }

  private static class LiSharedPreferencesInitModuleHolder {
    static LiSharedPreferencesInitModule INSTANCE = new LiSharedPreferencesInitModule();
  }

  @Override
  public void init(@NonNull Context context) {
    LiSharedPreferences.init(context);
  }

}
