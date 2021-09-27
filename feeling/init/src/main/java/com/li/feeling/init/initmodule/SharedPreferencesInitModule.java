package com.li.feeling.init.initmodule;

import java.lang.reflect.Type;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.framework.app.GlobalConstant;
import com.li.framework.gson.FeelingGson;
import com.li.framework.sharedpreferences.JsonDeserializer;
import com.li.framework.sharedpreferences.JsonSerializer;
import com.li.framework.sharedpreferences.SharedPreferencesHelper;
import com.li.framework_init.InitModule;

/**
 * description: 用于初始化sp
 */
public class SharedPreferencesInitModule implements InitModule {

  public static SharedPreferencesInitModule getInstance() {
    return SharedPreferencesInitModule.SharedPreferencesInitModuleHolder.INSTANCE;
  }

  private static class SharedPreferencesInitModuleHolder {
    static SharedPreferencesInitModule INSTANCE = new SharedPreferencesInitModule();
  }

  @Override
  public void init(@NonNull Context context) {
    SharedPreferencesHelper.init(
        context,
        GlobalConstant.APP_NAME,
        getSerializer(),
        getDeserializer());
  }

  private JsonSerializer getSerializer() {
    return new JsonSerializer() {
      @NonNull
      @Override
      public String serialize(@NonNull Object object) {
        return FeelingGson.GSON.toJson(object);
      }
    };
  }

  private JsonDeserializer getDeserializer() {
    return new JsonDeserializer() {
      @Nullable
      @Override
      public <T> T deserialize(@Nullable String json, @NonNull Type type) {
        return FeelingGson.GSON.fromJson(json, type);
      }
    };
  }

}
