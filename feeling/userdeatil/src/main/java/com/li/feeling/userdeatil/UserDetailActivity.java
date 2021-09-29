package com.li.feeling.userdeatil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.li.feeling.model.User;
import com.li.fragment.base_page.activity.BaseActivity;


/**
 * 用户详情页面
 */
// TODO: 2021/9/28 内容写到fragment中
public class UserDetailActivity extends BaseActivity {

  private static final String USER_KEY = "user";

  // 用户信息
  @NonNull
  private User mUser;

  private TextView mUserNameView;
  private TextView mUserIdView;
  private TextView mUserSexView;

  public static void start(@NonNull Activity activity, @NonNull User user) {
    Intent intent = new Intent(activity, UserDetailActivity.class);
    intent.putExtra("user", user);
    activity.startActivity(intent);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_detail_layout);
    initUserInfo();
    initView();
  }

  // 初始化用户信息
  private void initUserInfo() {
    Intent intent = getIntent();
    mUser = (User) intent.getSerializableExtra(USER_KEY);
  }

  private void initView() {
    mUserNameView = findViewById(R.id.user_detail_page_user_name_editText);
    mUserIdView = findViewById(R.id.user_detail_page_user_id_editText);
    mUserSexView = findViewById(R.id.user_detail_page_user_sex_editText);

    mUserNameView.setText(mUser.mNickName);
    mUserIdView.setText(mUser.mPhone);
    mUserSexView.setText(mUser.mSex);
  }
}
