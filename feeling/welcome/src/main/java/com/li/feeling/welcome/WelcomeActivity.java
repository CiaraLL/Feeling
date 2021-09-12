package com.li.feeling.welcome;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.li.fragment.base_page.activity.BaseActivity;
import com.lwh.welcome.R;

/**
 * description: 欢迎页面
 */
public class WelcomeActivity extends BaseActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome_layout);
  }

}
