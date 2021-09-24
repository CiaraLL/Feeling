package com.li.library.sharedpreferences_utility;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;

import com.tencent.mmkv.MMKV;

/**
 * description: 对SharedPreferences的封装
 */
// TODO: 9/23/21 增加存储和读取数据的方法
public class LiSharedPreferences {

  // 初始化
  public static void init(@NonNull Context context) {
    MMKV.initialize(context);
  }

  // 获得一个SharedPreferences对象
  @NonNull
  public static SharedPreferences get(String key) {
    // 多进程模式
    return MMKV.mmkvWithID(key, MMKV.MULTI_PROCESS_MODE);
  }

}
