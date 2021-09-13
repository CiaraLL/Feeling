package com.li.feeling.register;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.feeling.R;
import com.li.fragment.base_page.fragment.BaseFragment;


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
    }
}
