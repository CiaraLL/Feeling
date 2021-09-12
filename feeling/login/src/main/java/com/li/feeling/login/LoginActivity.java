package com.li.feeling.login;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.li.fragment.base_page.activity.BaseActivity;

/**
 * description: 登陆的activity
 */
public class LoginActivity extends BaseActivity {

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
    return new LoginFragment();
  }

}