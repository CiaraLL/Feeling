package com.li.feeling.desktop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.fragment.base_page.activity.BaseActivity;

/**
 * 桌面
 */
public class DesktopActivity extends BaseActivity {

  public static void start(@NonNull Activity activity) {
    Intent intent = new Intent(activity, DesktopActivity.class);
    activity.startActivity(intent);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getSupportFragmentManager()
        .beginTransaction()
        .replace(android.R.id.content, new DesktopTabFragment())
        .commitAllowingStateLoss();
  }
}
