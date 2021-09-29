package com.li.framework.common_util;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;

import com.li.framework.app.ContextService;

/**
 * description: 颜色的工具类
 */
public class ColorUtil {

  // 获得某颜色资源对用的颜色值
  public static int color(@ColorRes int colorRes) {
    return ContextCompat.getColor(ContextService.getAppContext(), colorRes);
  }

}
