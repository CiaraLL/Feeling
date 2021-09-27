package com.li.feeling.login;

import androidx.annotation.NonNull;

import com.li.framework.sharedpreferences.SharedPreferencesHelper;

/**
 * description: 登陆相关的缓存信息
 */
public class LoginCacheHelper {

  // 保存上次登录的账号
  public static final String LAST_LOGIN_PHONE = "last_login_phone";
  // 保存上次登录的密码
  public static final String LAST_LOGIN_PWD = "last_login_pwd";
  // 保存上次登录是否成功
  public static final String LAST_LOGIN_SUCCESS = "last_login_success";
  // 是否记住密码
  public static final String LOGIN_IS_REMEMBER_PWD = "login_is_remember_pwd";

  // phone
  public static void saveLoginPhone(@NonNull String phone) {
    SharedPreferencesHelper.put(LAST_LOGIN_PHONE, phone);
  }

  @NonNull
  public static String getLastLoginPhone() {
    return SharedPreferencesHelper.getString(LAST_LOGIN_PHONE);
  }

  // 密码
  public static void saveLoginPassword(@NonNull String password) {
    SharedPreferencesHelper.put(LAST_LOGIN_PWD, password);
  }

  @NonNull
  public static String getLastLoginPassword() {
    return SharedPreferencesHelper.getString(LAST_LOGIN_PWD);
  }

  // 登陆结果
  public static void saveLoginResult(boolean isSucceed) {
    SharedPreferencesHelper.put(LAST_LOGIN_SUCCESS, isSucceed);
  }

  public static boolean getLastLoginResult() {
    return SharedPreferencesHelper.getBoolean(LAST_LOGIN_SUCCESS, false);
  }

  // 记住密码
  public static void saveIsRememberPassword(boolean isRememberPassword) {
    SharedPreferencesHelper.put(LOGIN_IS_REMEMBER_PWD, isRememberPassword);
  }

  public static boolean getIsRememberPassword() {
    return SharedPreferencesHelper.getBoolean(LOGIN_IS_REMEMBER_PWD, false);
  }

}
