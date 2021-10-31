package com.li.framework.network;

/**
 * description: 各个业务方在此处声明自己的url
 */
public enum FeelingUrl {

  LOGIN("http", "192.168.1.9", 8080), // 登陆业务
  REGISTER("http", "192.168.1.9", 8080), // 注册业务
  HOME_FEEL_LIST("http", "192.168.1.9", 8080), // home页面feel列表
  PUBLISH("http", "192.168.1.9", 8080), // 发布feel;
  USER_DETAIL("http", "192.168.1.9", 8080),
  LIKE("http", "192.168.1.9", 8080),
  NOTIFICATION("http", "192.168.1.9", 8080);// 用户详情

  String mScheme;
  String mHost; // 域名或者ip地址
  int mPort; // 端口号

  FeelingUrl(String scheme, String host, int port) {
    mScheme = scheme;
    mHost = host;
    mPort = port;
  }

}