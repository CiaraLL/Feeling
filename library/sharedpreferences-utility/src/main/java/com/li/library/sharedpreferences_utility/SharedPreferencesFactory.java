package com.li.library.sharedpreferences_utility;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;

import com.tencent.mmkv.MMKV;

/**
 * description: SharedPreferences工厂
 */
public class SharedPreferencesFactory {

  // 初始化
  public static void init(@NonNull Context context) {
    MMKV.initialize(context);
  }

  // 获得一个SharedPreferences对象
  @NonNull
  public static SharedPreferences get(String key) {
    // 多进程模式
    // TODO: 9/27/21 为啥用多进程模式
    return MMKV.mmkvWithID(key, MMKV.MULTI_PROCESS_MODE);
  }

}
