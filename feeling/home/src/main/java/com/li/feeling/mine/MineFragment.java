package com.li.feeling.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.li.feeling.home.R;
import com.li.feeling.model.CurrentUser;
import com.li.feeling.userdeatil.UserDetailActivity;
import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.ui.utility.DuplicatedClickFilter;

public class MineFragment extends BaseFragment {

  private View mHeaderViewContainer; // 顶部的整个view
  private TextView mUserName;
  private TextView mBriefIntroduction;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_mine_layout;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initView(view);
  }

  private void initView(@NonNull View view) {
    mHeaderViewContainer = view.findViewById(R.id.mine_fragment_page_head_viewContainer);
    mUserName = view.findViewById(R.id.mine_content_user_name);
    mBriefIntroduction = view.findViewById(R.id.mine_head_brief_introduction_view);

    mUserName.setText(CurrentUser.get().getNickName());
    mBriefIntroduction.setText(CurrentUser.get().getSex());
    mHeaderViewContainer.setOnClickListener(new DuplicatedClickFilter() {
      @Override
      protected void handleClickEvent() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
          UserDetailActivity.start(activity, CurrentUser.get().getUser());
        }
      }
    });
  }
}
