package com.li.feeling.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.feeling.home.R;
import com.li.feeling.model.CurrentUser;
import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.ui.utility.DuplicatedClickFilter;

public class MineFragment extends BaseFragment {
  private TextView mUserName;
  private TextView mBriefIntroduction;
  private LinearLayout mMyView;

  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_mine_layout, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initView(view);
  }

  private void initView(View view) {
    mUserName = view.findViewById(R.id.mine_content_user_name);
    mBriefIntroduction = view.findViewById(R.id.mine_head_brief_introduction_view);
    mMyView = view.findViewById(R.id.my_home_pager);

    mUserName.setText(CurrentUser.get().getNickName());
    mBriefIntroduction.setText(CurrentUser.get().getSex());
    mMyView.setOnClickListener(new DuplicatedClickFilter(){

      @Override
      protected void handleClickEvent() {
        MyHomePagerActivity.start(getActivity());
      }
    });
  }
}
