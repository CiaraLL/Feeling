package com.li.feeling.publish;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.feeling.model.Feel;
import com.li.feeling.publish.api.PublishService;
import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.network.FeelingResponseTransformer;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.framework.ui.utility.DuplicatedClickFilter;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class PublishFeelFragment extends BaseFragment {

  private TextView mCancelView;
  private Button mButton;

  private Disposable mDisposable;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_publish_feel_layout;
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
        doPublish();
      }
    });
  }

  private void doPublish() {
    mDisposable = PublishService.get().publish()
        .observeOn(SchedulerManager.MAIN)
        .map(FeelingResponseTransformer.transform())
        .subscribe(new Consumer<Feel>() {
          @Override
          public void accept(Feel feel) throws Exception {

          }
        },throwable -> {

        });
  }
}
