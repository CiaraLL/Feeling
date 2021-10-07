package com.li.feeling.publish;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.li.feeling.model.CurrentUser;
import com.li.feeling.publish.api.IPublishFeelApiService;
import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.common_util.ToastUtil;
import com.li.framework.network.FeelingResponseTransformer;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.framework.ui.utility.DuplicatedClickFilter;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class PublishFeelFragment extends BaseFragment {

  private TextView mCancelView;
  private Button mPublishButton;

  private EditText mContentTextView;

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

  private void initView(@NonNull View rootView) {
    mCancelView = rootView.findViewById(R.id.publish_feel_page_cancel_view);
    mPublishButton = rootView.findViewById(R.id.publish_feel_page_publish_view);
    mContentTextView = rootView.findViewById(R.id.publish_feel_page_content_text_view);

    mCancelView.setOnClickListener(new DuplicatedClickFilter() {
      @Override
      protected void handleClickEvent() {

      }
    });

    mPublishButton.setOnClickListener(new DuplicatedClickFilter() {

      @Override
      protected void handleClickEvent() {
        String contentText = mContentTextView.getText().toString();
        if (TextUtils.isEmpty(contentText)) {
          ToastUtil.showToast("请输入文案");
          return;
        }
        publishFeel(contentText);
      }
    });
  }

  private void publishFeel(@NonNull String contentText) {
    mDisposable = IPublishFeelApiService.get()
        .publish(CurrentUser.get().getId(), contentText)
        .observeOn(SchedulerManager.MAIN)
        .map(FeelingResponseTransformer.transform())
        .subscribe(new Consumer<Boolean>() {
          @Override
          public void accept(Boolean succeed) throws Exception {
            if (succeed) {
              onPublishFeelSucceed();
            } else {
              ToastUtil.showToast("error，请稍后重试");
            }
          }
        }, throwable -> {
          ToastUtil.showToast("error，请稍后重试");
        });
  }

  // 发布成功
  private void onPublishFeelSucceed() {
    FragmentActivity activity = getActivity();
    if (activity != null) {
      activity.finish();
    }
  }

}
