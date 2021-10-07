package com.li.feeling.model;

import androidx.annotation.NonNull;

/**
 * description: 当前的用户
 */
public class CurrentUser {

  // single instance
  private CurrentUser() {}

  @NonNull
  public static CurrentUser get() {
    return CurrentUserHolder.INSTANCE;
  }

  private static class CurrentUserHolder {
    static CurrentUser INSTANCE = new CurrentUser();
  }

  @NonNull
  private User mUser = User.EMPTY;

  @NonNull
  public User getUser() {
    return mUser;
  }

  // 更新数据
  public void update(@NonNull User user) {
    mUser = user;
  }

  public long getId() {
    return mUser.mId;
  }

  public String getPhone() {
    return mUser.mPhone;
  }

  public String getNickName() {
    return mUser.mNickName;
  }

  public String getSex() {
    return mUser.mSex;
  }

}
