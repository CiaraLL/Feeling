package com.li.feeling.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.li.feeling.login.LoginActivity;
import com.li.fragment.base_page.activity.BaseActivity;


/**
 * description:注册页面Activity
 */
public class RegisterActivity extends BaseActivity {

    public static void start(@Nullable Activity activity) {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        replaceRegisterFragment();
    }

    private void replaceRegisterFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content,getRegisterFragment())
                .commitAllowingStateLoss();
    }

    private Fragment getRegisterFragment() {
        return new RegisterFragment();
    }
}
