package com.li.framework.common_util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.NonNull;

/**
 * description: 时间工具类
 */
public class TimeUtil {

  // 一些格式
  public enum TimeFormat {

    DATE_FORMAT_HMS("HH:mm:ss", Locale.US),
    DATE_FORMAT_MS("mm:ss", Locale.US),
    DATE_FORMAT_HM("HH:mm", Locale.US),
    DATE_FORMAT_HMSS("HH:mm:ss:SSS", Locale.US),
    DATE_FORMAT_MSS("mm:ss:SSS", Locale.US),
    DATE_FORMAT_MD_HM_EN("MM-dd HH:mm", Locale.US),
    DATE_FORMAT_YY_MM_DD_HH_MM_SS("yyyy.MM.dd HH:mm:ss", Locale.US);

    String mPattern;
    Locale mLocale;

    TimeFormat(String pattern, Locale locale) {
      mPattern = pattern;
      mLocale = locale;
    }

  }

  // 获得格式化的事件
  public static String getFormatTime(long time, @NonNull TimeFormat timeFormat) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeFormat.mPattern,timeFormat.mLocale);
    return simpleDateFormat.format(new Date(time));
  }

}
