package com.li.framework.gson;

import com.google.gson.Gson;

/**
 * description: Gson的工具类
 * 整个feelingApp内业务使用Gson不能自己随便new Gson()，统一使用该类获取gson
 * 1. 我们希望用单例，不提倡随便new耗费资源
 * 2. 最主要原因：gson可以添加各种adapter，比如我们请求接口，server返回的数据类型是A，
 * 但是接口请求方希望接口返回的数据是B，那我们就可以注册一个解析A类型数据的adapter(加工成B返回)给gson，
 * 这样比如好几个业务都在用该接口，就不用自己收到A数据后在手动解析为B了(统一在gsonAdapter中做，对业务是透明的)
 */
// TODO: 9/24/21 可以提供一些让外界注册adapter的一些操作
public class FeelingGson {

  public static final Gson GSON = new Gson();

}
