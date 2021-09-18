package com.li.feeling.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.li.feeling.mine.MineFragment;
import com.li.fragment.base_page.activity.BaseActivity;

/**
 * description: 登陆的activity
 */
public class LoginActivity extends BaseActivity {

  public static void start(@NonNull Activity activity){
    Intent intent = new Intent(activity, LoginActivity.class);
    activity.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    replaceLoginFragment();
  }

  private void replaceLoginFragment() {
    getSupportFragmentManager()
        .beginTransaction()
        .replace(android.R.id.content, getLoginFragment())
        .commitAllowingStateLoss();
  }

  @NonNull
  private Fragment getLoginFragment() {
    return new MineFragment();
  }
}