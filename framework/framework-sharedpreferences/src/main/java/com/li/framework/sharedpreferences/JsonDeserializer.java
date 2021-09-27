package com.li.framework.sharedpreferences;

import java.lang.reflect.Type;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * description: 反序列化
 */
public interface JsonDeserializer {

  /**
   * 反序列化
   *
   * @param json 序列化的内容
   * @param type 要反序列化的类型
   */
  @Nullable
  <T> T deserialize(@Nullable String json, @NonNull Type type);

}
