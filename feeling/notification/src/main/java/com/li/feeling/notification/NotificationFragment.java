package com.li.feeling.notification;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.li.feeling.model.notification.FeelingBaseNotification;
import com.li.feeling.model.notification.FeelingNotificationType;
import com.li.feeling.model.notification.business.FeelLikeNotification;
import com.li.feeling.notification.list.adapter.NotificationListRecyclerAdapter;
import com.li.feeling.notification.list.viewdata.NotificationListFeelLikeItemViewData;
import com.li.feeling.notification.list.viewdata.NotificationListFooterItemViewData;
import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.common_util.TimeUtil;
import com.li.library.recycler.LiRecyclerItemViewData;
import com.li.message.R;

/**
 * 通知fragment
 */
public class NotificationFragment extends BaseFragment {

  // 数据
  private List<FeelingBaseNotification> mNotificationList;

  private RecyclerView mRecyclerView;
  private NotificationListRecyclerAdapter mNotificationListAdapter;

  //轮询通知
  @NonNull
  FeelingNotificationPollManager mNotificationPollManager = new FeelingNotificationPollManager();

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_notification_layout;
  }

  @Override
  public void onViewCreated(
      @NonNull View view,
      @Nullable Bundle savedInstanceState,
      boolean isFirstCall) {
    // 刷新列表数据
    if (isFirstCall) {
      initView(view);
      startPollingNotification();
    }
  }

  private void initView(@NonNull View view) {
    mRecyclerView = view.findViewById(R.id.fragment_notification_recycler_view);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mNotificationListAdapter = new NotificationListRecyclerAdapter(getContext());
    mRecyclerView.setAdapter(mNotificationListAdapter);
  }

  // 轮训通知
  private void startPollingNotification() {
    mNotificationPollManager.startPoll(
        notificationListResponse -> onFeelListDataChanged(
            notificationListResponse.mNotificationList, notificationListResponse.mFooterTip));
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
        itemViewData.mTime = TimeUtil.getFormatTime(
            feelLikeNotification.getTime(), TimeUtil.TimeFormat.DATE_FORMAT_YY_MM_DD_HH_MM_SS);

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
    mNotificationPollManager.release();
  }

}
