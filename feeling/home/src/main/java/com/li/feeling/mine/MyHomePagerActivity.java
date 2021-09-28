package com.li.feeling.mine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.li.feeling.home.R;
import com.li.feeling.model.CurrentUser;

public class MyHomePagerActivity extends AppCompatActivity {

    private TextView mUserName;
    private TextView mPhone;
    private TextView mSex;

    public static void start(@NonNull Activity activity){
        Intent intent = new Intent(activity,MyHomePagerActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_home_pager_layout);
        initView();
    }

    private void initView() {
        mUserName = findViewById(R.id.my_home_pager_name_editText);
        mPhone = findViewById(R.id.my_home_pager_phone_editText);
        mSex = findViewById(R.id.my_home_pager_sex_editText);

        mUserName.setText(CurrentUser.get().getNickName());
        mPhone.setText(CurrentUser.get().getPhone());
        mSex.setText(CurrentUser.get().getSex());

    }
}
