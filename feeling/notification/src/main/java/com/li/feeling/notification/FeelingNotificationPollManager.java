package com.li.feeling.notification;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.feeling.model.CurrentUser;
import com.li.feeling.notification.list.api.INotificationApiService;
import com.li.feeling.notification.list.api.NotificationListResponse;
import com.li.framework.common_util.RxUtil;
import com.li.framework.network.FeelingResponseTransformer;
import com.li.framework.scheduler_utility.SchedulerManager;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * description: 用于轮训通知
 */
public class FeelingNotificationPollManager {

  @Nullable
  private Disposable mDisposable;

  // 开始轮训
  public void startPoll(@NonNull Consumer<NotificationListResponse> onNext) {
    // 先释放掉上次的轮训
    release();
    mDisposable = INotificationApiService.get()
        .getNotificationListData(CurrentUser.get().getId())
        .observeOn(SchedulerManager.MAIN)
        .map(FeelingResponseTransformer.transform())
        .repeat()
        .retryWhen(throwableObservable -> throwableObservable.delay(2, TimeUnit.SECONDS))
        .subscribe(onNext);

  }

  public void release() {
    RxUtil.dispose(mDisposable);
  }

}
