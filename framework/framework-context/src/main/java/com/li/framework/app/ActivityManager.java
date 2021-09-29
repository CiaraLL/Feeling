package com.li.framework.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * description: 管理所有的activity
 */
public class ActivityManager implements Application.ActivityLifecycleCallbacks {

  // 当前所有的activity
  private static final List<WeakReference<Activity>> mActivityStack = new ArrayList<>();

  // 获取所有的activity
  public List<WeakReference<Activity>> getActivityStack() {
    return mActivityStack;
  }


  @Override
  public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

  }

  @Override
  public void onActivityStarted(@NonNull Activity activity) {

  }

  @Override
  public void onActivityResumed(@NonNull Activity activity) {

  }

  @Override
  public void onActivityPaused(@NonNull Activity activity) {

  }

  @Override
  public void onActivityStopped(@NonNull Activity activity) {

  }

  @Override
  public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

  }

  @Override
  public void onActivityDestroyed(@NonNull Activity activity) {

  }

  private void addActivity(@NonNull Activity activity) {
    for (WeakReference<Activity> activityWeakReference : mActivityStack) {
      if (activityWeakReference.get() == activity) {
        return;
      }
      mActivityStack.add(new WeakReference<>(activity));
    }
  }

  private void removeActivity(@NonNull Activity activity) {
    Iterator<WeakReference<Activity>> iterator = mActivityStack.listIterator();
    while (iterator.hasNext()) {
      WeakReference<Activity> activityWeakReference = iterator.next();
      if (activityWeakReference.get() == activity || activityWeakReference == null) {
        iterator.remove();
      }
    }
  }
}
