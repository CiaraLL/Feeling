package com.li.feeling.model.notification.sd;

import java.lang.reflect.Type;

import androidx.annotation.NonNull;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.li.feeling.model.notification.FeelingBaseNotification;
import com.li.feeling.model.notification.FeelingNotificationType;
import com.li.feeling.model.notification.business.FeelLikeNotification;
import com.li.framework.gson.FeelingGson;

/**
 * description: FeelingNotification反序列化
 */
public class FeelingNotificationDeserializer implements JsonDeserializer<FeelingBaseNotification> {

  @Override
  public FeelingBaseNotification deserialize(
      JsonElement json,
      Type typeOfT,
      JsonDeserializationContext context) throws JsonParseException {
    JsonObject jsonObject = json.getAsJsonObject();
    // 通知的类型
    final int notificationType = jsonObject.get(FeelingBaseNotification.TYPE_KEY).getAsInt();
    // 该类型对应的具体类
    Type clazz = getClassByType(notificationType);
    // 反序列化
    return FeelingGson.GSON.fromJson(json, clazz);
  }

  // 新增的
  @NonNull
  public Type getClassByType(int notificationType) {
    switch (notificationType) {
      case FeelingNotificationType.FEEL_LIKE:
        return FeelLikeNotification.class;
    }
    throw new IllegalArgumentException("未知类型：" + notificationType);
  }

}
