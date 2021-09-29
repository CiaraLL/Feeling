package com.li.framework.sharedpreferences;

import java.lang.reflect.Type;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.library.sharedpreferences_utility.SharedPreferencesFactory;

/**
 * description: SharedPreferences工具类
 */
public class SharedPreferencesHelper {

  // 空字符串
  private static final String EMPTY_STR = "";

  // sp唯一的实例
  @NonNull
  private static SharedPreferences sSharedPreferences;

  // 用于序列化和反序列化
  @NonNull
  private static JsonSerializer sSerializer;
  @NonNull
  private static JsonDeserializer sDeserializer;

  // 初始化
  public static void init(
      @NonNull Context context,
      @NonNull String key,
      @NonNull JsonSerializer serializer,
      @NonNull JsonDeserializer deserializer) {
    SharedPreferencesFactory.init(context);

    sSharedPreferences = SharedPreferencesFactory.get(key);
    sSerializer = serializer;
    sDeserializer = deserializer;
  }

  // 获取sp实例
  @NonNull
  public static SharedPreferences obtainSharedPreferences() {
    return sSharedPreferences;
  }

  // 存储
  public static void put(@NonNull String key, @NonNull Object object) {
    SharedPreferences.Editor edit = sSharedPreferences.edit();
    edit.putString(key, sSerializer.serialize(object));
    edit.apply();
  }

  // 读取
  @Nullable
  public static <T> T get(@NonNull String key, @NonNull Type type) {
    String value = sSharedPreferences.getString(key, EMPTY_STR);
    if (value == null || value.equals(EMPTY_STR)) {
      return null;
    }
    return sDeserializer.deserialize(value, type);
  }

  // 用于读取String类型
  @NonNull
  public static String getString(@NonNull String key, @NonNull String defaultValue) {
    String value = get(key, String.class);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }

  // 读取boolean
  public static boolean getBoolean(@NonNull String key, boolean defaultValue) {
    Boolean value = get(key, Boolean.class);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }

  // 读取int
  public static int getInt(@NonNull String key, int defaultValue) {
    Integer value = get(key, Boolean.class);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }

}
