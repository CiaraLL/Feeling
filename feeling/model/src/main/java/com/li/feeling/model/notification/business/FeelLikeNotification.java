package com.li.feeling.model.notification.business;

import com.li.feeling.model.Feel;
import com.li.feeling.model.User;
import com.li.feeling.model.notification.FeelingBaseNotification;
import com.li.feeling.model.notification.FeelingNotificationType;

/**
 * description: feel点赞的通知
 */
public class FeelLikeNotification extends FeelingBaseNotification {

  // feel
  private Feel mFeel;
  // 点赞的人
  private User mUser;

  public FeelLikeNotification(long time) {
    super(time);
  }

  @Override
  public int getType() {
    return FeelingNotificationType.FEEL_LIKE;
  }

  public Feel getFeel() {
    return mFeel;
  }

  public void setFeel(Feel feel) {
    mFeel = feel;
  }

  public User getUser() {
    return mUser;
  }

  public void setUser(User user) {
    mUser = user;
  }
}
