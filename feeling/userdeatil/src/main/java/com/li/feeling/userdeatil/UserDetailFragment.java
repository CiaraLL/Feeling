package com.li.feeling.userdeatil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.li.feeling.model.User;
import com.li.feeling.userdeatil.tab.UserDetailFeelListTabFragment;
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
    return R.layout.fragment_user_detail_layout;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initUserInfo();
    initView(view);
  }

  // 初始化用户信息
  private void initUserInfo() {
    Intent intent = getActivity().getIntent();
    mUser = (User) intent.getSerializableExtra(USER_KEY);
  }

  private void initView(@NonNull View rootView) {
    mUserNameView = rootView.findViewById(R.id.user_detail_page_user_name_view);
    mUserIdView = rootView.findViewById(R.id.user_detail_page_user_id_view);

    mUserNameView.setText(mUser.mNickName);
    mUserIdView.setText(mUser.mPhone);
    replaceUserDetailFeelListTabFragment();
  }

  private void replaceUserDetailFeelListTabFragment() {
    // getParentFragmentManager和getFragmentManager的区别是：
    // getParentFragmentManager中对返回的fragmentManager判空了，如果是null，那么抛出异常
    getParentFragmentManager()
        .beginTransaction()
        .replace(R.id.user_detail_feel_list_container, getUserDetailFeelListTabFragment())
        .commitAllowingStateLoss();
  }

  // feel列表的tabFragment
  private Fragment getUserDetailFeelListTabFragment() {
    return new UserDetailFeelListTabFragment();
  }

}
