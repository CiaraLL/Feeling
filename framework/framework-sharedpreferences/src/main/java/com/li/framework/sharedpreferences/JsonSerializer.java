package com.li.framework.sharedpreferences;

import androidx.annotation.NonNull;

/**
 * description: json序列化
 */
public interface JsonSerializer {

  /**
   * 序列化
   *
   * @param object 原数据
   * @return json
   */
  @NonNull
  String serialize(@NonNull Object object);

}
