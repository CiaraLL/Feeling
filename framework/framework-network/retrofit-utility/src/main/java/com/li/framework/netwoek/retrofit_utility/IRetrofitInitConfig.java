package com.li.framework.netwoek.retrofit_utility;

import android.content.Context;
import androidx.annotation.NonNull;

/**
 * description:用于retrofit模块初始化化的一些数据
 * 和IRetrofitConfig的区别是，IRetrofitConfig是网络请求的时候需要的必须的配置，比如一个请求必须要有url、gson解析器、okHttpClient等。
 * 而InitConfig是我们的retrofit封装这个模块需要的一些基本配置信息，比如上下文context、设备信息等
 */
public interface IRetrofitInitConfig {

  @NonNull
  public Context getContext();

}
