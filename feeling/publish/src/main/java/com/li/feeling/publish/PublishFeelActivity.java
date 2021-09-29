package com.li.feeling.publish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.fragment.base_page.activity.BaseActivity;

/**
 * 发布feel的activity
 */
// TODO: 2021/9/28 加一个fragment
public class PublishFeelActivity extends BaseActivity {

    public static void start(@NonNull Activity activity){
        Intent intent = new Intent(activity,PublishFeelActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_feel_layout);
    }

}
