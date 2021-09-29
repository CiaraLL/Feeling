package com.li.feeling.userdeatil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.feeling.model.User;
import com.li.fragment.base_page.fragment.BaseFragment;

public class UserDetailFragment extends BaseFragment {

  private static final String USER_KEY = "user";

  // 用户信息
  @NonNull
  private User mUser;

  private TextView mUserNameView;
  private TextView mUserIdView;
  private TextView mUserSexView;

  @Override
  protected int getLayoutResId() {
    return R.layout.activity_user_detail_layout;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initUserInfo(view);
    initView(view);
  }

  // 初始化用户信息
  private void initUserInfo(View view) {
    Intent intent = getActivity().getIntent();
    mUser = (User) intent.getSerializableExtra(USER_KEY);
  }

  private void initView(View view) {

    mUserNameView = view.findViewById(R.id.user_detail_page_user_name_view);
    mUserIdView = view.findViewById(R.id.user_detail_page_user_id_view);

    mUserNameView.setText(mUser.mNickName);
    mUserIdView.setText(mUser.mPhone);
  }

}
