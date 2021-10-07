package com.li.feeling.register;


import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.feeling.R;
import com.li.feeling.login.LoginActivity;
import com.li.feeling.model.User;
import com.li.feeling.register.api.IRegisterApiService;
import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.common_util.ToastUtil;
import com.li.framework.network.FeelingException;
import com.li.framework.network.FeelingResponseTransformer;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.framework.ui.utility.DuplicatedClickFilter;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


/**
 * 注册页面Fragment
 */
public class RegisterFragment extends BaseFragment {

  private EditText mPhoneView;
  private EditText mPasswordView;
  private Button mRegisterButton;

  @Nullable
  private Disposable mRegisterDisposable;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_register_layout;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mPhoneView = view.findViewById(R.id.fragment_register_pager_phone_edittext);
    mPasswordView = view.findViewById(R.id.fragment_register_pager_password_edittext);
    mRegisterButton = view.findViewById(R.id.fragment_register_page_register_button);
    mRegisterButton.setOnClickListener(new DuplicatedClickFilter() {
      @Override
      protected void handleClickEvent() {
        doRegister();
      }
    });
  }

  private void doRegister() {
    String phone = mPhoneView.getText().toString();
    String password = mPasswordView.getText().toString();

    if (TextUtils.isEmpty(phone)) {
      ToastUtil.showToast("请输入要注册的手机号");
      mPhoneView.requestFocus();
      return;
    }
    if (TextUtils.isEmpty(password)) {
      ToastUtil.showToast("请输入密码");
      mPasswordView.requestFocus();
      return;
    }

    mRegisterDisposable = IRegisterApiService.get()
        .register(phone, password)
        .observeOn(SchedulerManager.MAIN)
        .map(FeelingResponseTransformer.transform())
        .subscribe(new Consumer<User>() {
          @Override
          public void accept(User user) {
            onRegisterSuccess();
          }
        }, throwable -> {
          if (throwable instanceof FeelingException) {
            ToastUtil.showToast((((FeelingException) throwable).mErrorMessage));
          } else {
            ToastUtil.showToast("请稍后再试");
          }
        });
  }

  // 注册成功
  private void onRegisterSuccess() {
    Activity activity = getActivity();
    if (activity != null) {
      LoginActivity.start(activity);
      activity.finish();
    }
  }
}
