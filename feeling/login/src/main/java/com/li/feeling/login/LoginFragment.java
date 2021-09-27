package com.li.feeling.login;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.feeling.R;
import com.li.feeling.home.HomeActivity;
import com.li.feeling.login.api.LoginApiService;
import com.li.feeling.model.CurrentUser;
import com.li.feeling.model.User;
import com.li.feeling.register.RegisterActivity;
import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.common_util.RxUtil;
import com.li.framework.common_util.ToastUtil;
import com.li.framework.network.FeelingException;
import com.li.framework.network.FeelingResponseTransformer;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.framework.ui.utility.DuplicatedClickFilter;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


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
  private Disposable mLoginDisposable;

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_login_layout, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initView(view);
  }

  private void initView(@NonNull View rootView) {
    mPhoneView = rootView.findViewById(R.id.fragment_login_page_phone_editText);
    mPasswordView = rootView.findViewById(R.id.fragment_login_page_password_editView);
    mLoginButton = rootView.findViewById(R.id.fragment_login_pager_login_button);
    mRegisterView = rootView.findViewById(R.id.fragment_login_register_view);

    mLoginButton.setOnClickListener(new DuplicatedClickFilter() {

      @Override
      protected void handleClickEvent() {
        doLogin();
      }
    });
    mRegisterView.setOnClickListener(new DuplicatedClickFilter() {
      @Override
      protected void handleClickEvent() {
        jumpToRegisterPager();
      }
    });
  }

  private void doLogin() {
    String mPhoneStr = mPhoneView.getText().toString();
    String mPassword = mPasswordView.getText().toString();

    if (TextUtils.isEmpty(mPhoneStr)) {
      ToastUtil.showToast("请输入账号");
      mPhoneView.requestFocus();
      return;
    }
    if (TextUtils.isEmpty(mPassword)) {
      ToastUtil.showToast("请输入密码");
      mPasswordView.requestFocus();
      return;
    }

    mLoginDisposable = LoginApiService.get()
        .login(mPhoneStr, mPassword)
        .observeOn(SchedulerManager.MAIN)
        .map(FeelingResponseTransformer.transform())
        .subscribe(new Consumer<User>() {
          @Override
          public void accept(User user) throws Exception {
            onLoginSuccess(user);
          }
        }, throwable -> {
          if (throwable instanceof FeelingException) {
            ToastUtil.showToast(((FeelingException) throwable).mErrorMessage);
          }
        });
  }

  // 登陆成功
  private void onLoginSuccess(@NonNull User user) {
    // 更新当前用户
    CurrentUser.get().update(user);

    Activity activity = getActivity();
    if (activity != null && !activity.isFinishing()) {
      // 进入home页面
      HomeActivity.start(activity);
    }
  }

  private void jumpToRegisterPager() {
    Activity activity = getActivity();
    if (activity == null) {
      return;
    }
    RegisterActivity.start(activity);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    // 避免网络请求的内存泄漏
    RxUtil.dispose(mLoginDisposable);
  }
}
