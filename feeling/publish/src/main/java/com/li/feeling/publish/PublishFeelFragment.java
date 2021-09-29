package com.li.feeling.publish;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.ui.utility.DuplicatedClickFilter;

public class PublishFeelFragment extends BaseFragment {

  private TextView mCancelView;
  private Button mButton;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_publish_feel_layout, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initView(view);
  }

  private void initView(View view) {
    mCancelView = view.findViewById(R.id.publish_feel_page_cancel_view);
    mButton = view.findViewById(R.id.publish_feel_page_publish_view);

    mCancelView.setOnClickListener(new DuplicatedClickFilter() {
      @Override
      protected void handleClickEvent() {

      }
    });

    mButton.setOnClickListener(new DuplicatedClickFilter() {

      @Override
      protected void handleClickEvent() {

      }
    });
  }
}
