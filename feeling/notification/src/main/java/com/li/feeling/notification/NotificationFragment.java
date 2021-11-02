package com.li.feeling.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.li.feeling.model.CurrentUser;
import com.li.feeling.model.notification.FeelingBaseNotification;
import com.li.feeling.model.notification.FeelingNotificationType;
import com.li.feeling.model.notification.business.FeelLikeNotification;
import com.li.feeling.notification.list.adapter.NotificationListRecyclerAdapter;
import com.li.feeling.notification.list.api.INotificationApiService;
import com.li.feeling.notification.list.api.NotificationListResponse;
import com.li.feeling.notification.list.viewdata.NotificationListFeelLikeItemViewData;
import com.li.feeling.notification.list.viewdata.NotificationListFooterItemViewData;
import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.common_util.RxUtil;
import com.li.framework.common_util.ToastUtil;
import com.li.framework.network.FeelingException;
import com.li.framework.network.FeelingResponseTransformer;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.recycler.LiRecyclerItemViewData;
import com.li.message.R;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * 通知fragment
 */
public class NotificationFragment extends BaseFragment {

  // 数据
  private List<FeelingBaseNotification> mNotificationList;

  private SwipeRefreshLayout mRefreshLayout;
  private RecyclerView mRecyclerView;
  private NotificationListRecyclerAdapter mNotificationListAdapter;

  // 列表刷新的网络请求
  @Nullable
  private Disposable mNotificationListDisposable;

  //轮询的
  @NonNull
  private Disposable mPollingDisposable;
  // 下拉刷新

  @NonNull
  private final SwipeRefreshLayout.OnRefreshListener mRefreshListener =
      this::refreshNotificationList;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_notification_layout;
  }

  @Override
  public void onResume() {
    super.onResume();
    startPolling();
  }

  private void  startPolling(){
    mPollingDisposable = Observable.interval(5,TimeUnit.MILLISECONDS)
        .observeOn(SchedulerManager.MAIN)
        .subscribe(new Consumer<Long>() {
          @Override
          public void accept(Long aLong) throws Exception {
            refreshNotificationList();
          }
        });
  }

  @Override
  public void onViewCreated(
      @NonNull View view,
      @Nullable Bundle savedInstanceState,
      boolean isFirstCall) {
    // 刷新列表数据
    if (isFirstCall) {
      initView(view);
      refreshNotificationList();
    }
  }

  private void initView(@NonNull View view) {
    mRefreshLayout = view.findViewById(R.id.fragment_notification_refresh_layout);
    mRefreshLayout.setOnRefreshListener(mRefreshListener);

    mRecyclerView = view.findViewById(R.id.fragment_notification_recycler_view);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mNotificationListAdapter = new NotificationListRecyclerAdapter(getContext());
    mRecyclerView.setAdapter(mNotificationListAdapter);
  }

  // 刷新通知列表:网络请求
  @NonNull
  private void refreshNotificationList() {
    mNotificationListDisposable = INotificationApiService.get()
        .getNotificationListData(CurrentUser.get().getId())
        .observeOn(SchedulerManager.MAIN)
        .map(FeelingResponseTransformer.transform())
        .doFinally(new Action() {
          @Override
          public void run() throws Exception {
            // 请求结束的时候，恢复
            mRefreshLayout.setRefreshing(false);
          }
        })
        .subscribe(
            new Consumer<NotificationListResponse>() {
              @Override
              public void accept(NotificationListResponse response) {
                onFeelListDataChanged(response.mNotificationList, response.mFooterTip);
              }
            },
            throwable -> {
              if (throwable instanceof FeelingException) {
                ToastUtil.showToast(((FeelingException) throwable).mErrorMessage);
              }
            });
  }

  /**
   * 列表数据变化时
   *
   * @param notificationList 列表数据
   * @param footerTip        滑动到底部的提示
   */
  private void onFeelListDataChanged(@NonNull List<FeelingBaseNotification> notificationList,
      String footerTip) {
    // 保存下
    mNotificationList = notificationList;

    //列表UI数据
    List<LiRecyclerItemViewData> itemViewDataList = new ArrayList<>();

    // 把原始的业务数据转化为列表需要的UI数据
    for (FeelingBaseNotification notification : notificationList) {

      // 点赞通知
      if (notification.getType() == FeelingNotificationType.FEEL_LIKE) {
        FeelLikeNotification feelLikeNotification = (FeelLikeNotification) notification;
        NotificationListFeelLikeItemViewData itemViewData =
            new NotificationListFeelLikeItemViewData();
        itemViewData.mAvatarResId = R.drawable.mine_head_my_photo;
        itemViewData.mName = feelLikeNotification.getUser().mNickName;
        itemViewData.mContent = feelLikeNotification.getTip();
        // TODO: 2021/10/29 时间戳格式化
        itemViewData.mTime = feelLikeNotification.getTime() + "";

        itemViewDataList.add(itemViewData);
      }
    }

    // footerItem需要的数据
    itemViewDataList.add(new NotificationListFooterItemViewData(footerTip));

    mNotificationListAdapter.setList(itemViewDataList);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    RxUtil.dispose(mNotificationListDisposable);
    RxUtil.dispose(mPollingDisposable);
  }

}
