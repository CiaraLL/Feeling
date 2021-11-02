package com.li.framework.gson;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * description: Gson的工具类
 * 整个feelingApp内业务使用Gson不能自己随便new Gson()，统一使用该类获取gson
 * 1. 我们希望用单例，不提倡随便new耗费资源
 * 2. 最主要原因：gson可以添加各种adapter，比如我们请求接口，server返回的数据类型是A，
 * 但是接口请求方希望接口返回的数据是B，那我们就可以注册一个解析A类型数据的adapter(加工成B返回)给gson，
 * 这样比如好几个业务都在用该接口，就不用自己收到A数据后在手动解析为B了(统一在gsonAdapter中做，对业务是透明的)
 */
public class FeelingGson {

  public static Gson GSON = new Gson();
  public static final GsonBuilder GSON_BUILDER = new GsonBuilder();

  public static void init(){
    GSON = GSON_BUILDER.create();
  }

  // 注册gson的适配器,注意要在init函数之前调用，否则不生效
  public static void registerAdapter(Type type, Object adapter){
    GSON_BUILDER.registerTypeAdapter(type, adapter);
  }

}
