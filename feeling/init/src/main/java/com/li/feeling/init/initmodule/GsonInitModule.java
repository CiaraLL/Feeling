package com.li.feeling.init.initmodule;

import android.content.Context;
import androidx.annotation.NonNull;

import com.li.feeling.model.notification.FeelingBaseNotification;
import com.li.feeling.model.notification.sd.FeelingNotificationDeserializer;
import com.li.framework.gson.FeelingGson;
import com.li.framework_init.InitModule;

/**
 * description: 初始化gson
 */
public class GsonInitModule implements InitModule {

  public static GsonInitModule getInstance() {
    return GsonInitModule.GsonInitModuleHolder.INSTANCE;
  }

  private static class GsonInitModuleHolder {
    static GsonInitModule INSTANCE = new GsonInitModule();
  }

  @Override
  public void init(@NonNull Context context) {
    // TODO: 2021/11/1 应该通知各个业务自己去注册，而不是统一在这里注册
    //  (耦合了业务，比如写一个需要adapter业务，竟然需要在这个initModule中注册一下adapter)，
    //  比如可以发送一个event事件，然后需要注册adapter的业务监听该事件然后主动注册
    // 注册一些适配器
    // 通知的adapter
    FeelingGson
        .registerAdapter(FeelingBaseNotification.class, new FeelingNotificationDeserializer());

    FeelingGson.init();
  }

}
