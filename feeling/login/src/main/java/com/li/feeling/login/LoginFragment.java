package com.li.feeling.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.ui.utility.DuplicatedClickFilter;
import com.lwh.login.R;

/**
 * description: 登陆页面
 */
public class LoginFragment extends BaseFragment {

  private EditText mPhoneView;
  private EditText mPasswordView;

  // 登陆按钮
  private Button mLoginButton;

  // 注册
  private View mRegisterView;

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_login_layout, container);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initView(view);
  }

  private void initView(@NonNull View rootView) {
    mPhoneView = rootView.findViewById(R.id.login_page_phone_view);
    mPasswordView = rootView.findViewById(R.id.login_page_password_view);
    mLoginButton = rootView.findViewById(R.id.login_page_login_button);
    mRegisterView = rootView.findViewById(R.id.login_page_register_view);

    mLoginButton.setOnClickListener(new DuplicatedClickFilter() {

      @Override
      protected void handleClickEvent() {

      }
    });
    mRegisterView.setOnClickListener(view -> {});
  }


}
