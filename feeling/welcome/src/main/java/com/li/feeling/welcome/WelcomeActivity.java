package com.li.feeling.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.li.feeling.login.LoginActivity;


/**
 * description: 欢迎页面
 */
public class WelcomeActivity extends Activity {

    private TextView mTimerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_layout);
        mTimerView = findViewById(R.id.welcome_textview);
    }


    CountDownTimer timer = new CountDownTimer(3000,1000) {
        @Override
        public void onTick(long l) {
            mTimerView.setText("倒计时 "+ l/1000 +"秒");
        }

        @Override
        public void onFinish() {
            LoginActivity.start(WelcomeActivity.this);
        }
    }.start();
}
