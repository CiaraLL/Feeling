package com.li.feeling.welcome;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.annotation.Nullable;

import com.li.feeling.login.LoginActivity;


/**
 * description: 欢迎页面
 */
public class WelcomeActivity extends Activity {

  // 倒计时时长--3秒
  private static final long COUNT_DOWN_DURATION_MS = 3000;
  // 一秒倒计时一次
  private static final long COUNT_DOWN_TIME_INTERVAL = 1000;

  // 倒计时文案的前缀
  private static final String COUNT_DOWN_TEXT_PREFIX = "倒计时";
  private static final String COUNT_DOWN_TEXT_SUFFIX = "s";

  private TextView mCountDownView;
  private CountDownTimer mCountDownTimer;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome_layout);
    mCountDownView = findViewById(R.id.welcome_activity_count_down_view);
    startCountDown();
  }

  // 开始倒计时
  private void startCountDown() {
    mCountDownTimer = new CountDownTimer(COUNT_DOWN_DURATION_MS, COUNT_DOWN_TIME_INTERVAL) {
      @Override
      public void onTick(long timeMs) {
        mCountDownView
            .setText(COUNT_DOWN_TEXT_PREFIX + " " + timeMs / 1000 + " " + COUNT_DOWN_TEXT_SUFFIX);
      }

      @Override
      public void onFinish() {
        LoginActivity.start(WelcomeActivity.this);
        WelcomeActivity.this.finish();
      }
    }.start();
  }

}
