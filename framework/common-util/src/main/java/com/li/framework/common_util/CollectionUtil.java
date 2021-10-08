package com.li.framework.common_util;

import java.util.Collection;

import androidx.annotation.Nullable;

/**
 * description: 集合的工具类
 */
public class CollectionUtil {

  public static boolean isEmpty(@Nullable Collection collection) {
    return collection == null || collection.isEmpty();
  }

}
