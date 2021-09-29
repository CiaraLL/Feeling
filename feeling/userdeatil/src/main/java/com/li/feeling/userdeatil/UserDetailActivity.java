package com.li.feeling.userdeatil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.li.feeling.model.User;
import com.li.fragment.base_page.activity.BaseActivity;


/**
 * 用户详情页面
 */
// TODO: 2021/9/28 内容写到fragment中
public class UserDetailActivity extends BaseActivity {


  public static void start(@NonNull Activity activity, @NonNull User user) {
    Intent intent = new Intent(activity, UserDetailActivity.class);
    intent.putExtra("user", user);
    activity.startActivity(intent);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_detail_layout);
    replaceUserDetailFragment();
  }

  private void replaceUserDetailFragment() {
    getSupportFragmentManager()
        .beginTransaction()
        .replace(android.R.id.content,getUserDetailFragment())
        .commitAllowingStateLoss();
  }

  private Fragment getUserDetailFragment() {
    return new UserDetailFragment();
  }
}
