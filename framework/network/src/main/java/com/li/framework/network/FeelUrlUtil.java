package com.li.framework.network;

import androidx.annotation.NonNull;

/**
 * description: 用来处理{@link FeelingUrl}的工具类
 */
public class FeelUrlUtil {

  // 获得url
  @NonNull
  public static String getUrl(@NonNull FeelingUrl feelingUrl) {
    return feelingUrl.mShceme + "://" + feelingUrl.mHost + ":" + feelingUrl.mPort;
  }

}
