package com.li.feeling.register;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.feeling.R;
import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.ui.utility.DuplicatedClickFilter;


public class RegisterFragment extends BaseFragment {
    private EditText mPhoneView;
    private EditText mPasswordView;
    private Button mRegisterButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_layout,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPhoneView = view.findViewById(R.id.fragment_register_pager_phone_edittext);
        mPasswordView = view.findViewById(R.id.fragment_register_pager_password_edittext);
        mRegisterButton = view.findViewById(R.id.fragment_register_page_register_button);
        mPhoneView.setOnClickListener(new DuplicatedClickFilter() {
            @Override
            protected void handleClickEvent() {
                Toast.makeText(getActivity(), "请输入手机号注册", Toast.LENGTH_SHORT).show();
            }
        });

        mPasswordView.setOnClickListener(new DuplicatedClickFilter() {
            @Override
            protected void handleClickEvent() {
                Toast.makeText(getActivity(), "请输入注册密码", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
