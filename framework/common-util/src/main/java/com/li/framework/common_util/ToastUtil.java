package com.li.framework.common_util;

import android.widget.Toast;
import androidx.annotation.NonNull;

import com.li.framework.app.ContextService;

/**
 * description:
 */
public class ToastUtil {

  /**
   * toast
   * 为啥单独封装一个统一的方法：
   * 1. 想弹一个toast
   * 不需要写模版代码{@link Toast#makeText(android.content.Context, java.lang.CharSequence, int)}
   * 2. 如果我们要对app的toast进行一定的配置，比如颜色、位置等等，那么不可能让toast方自己每次弹的时候都自己去配置，
   * 一是自己配置写很多代码；二是如果后期我们对整个app的toast配置进行更改，那么需要改动所有的toast的业务代码
   *
   * @param tip 要提示的文案
   */
  public static void showToast(@NonNull String tip) {
    Toast.makeText(ContextService.getAppContext(), tip, Toast.LENGTH_SHORT).show();
  }

}
