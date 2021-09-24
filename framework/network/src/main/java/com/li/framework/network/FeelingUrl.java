package com.li.framework.network;

/**
 * description: 各个业务方在此处声明自己的url
 */
public enum FeelingUrl {

  LOGIN("http", "192.168.1.8", 8080), // 登陆业务
  REGISTER("http", "192.168.1.8", 8080); // 注册业务

  String mShceme;
  String mHost; // 域名或者ip地址
  int mPort; // 端口号

  FeelingUrl(String shceme, String host, int port) {
    mShceme = shceme;
    mHost = host;
    mPort = port;
  }

  }