package com.li.feeling.common.like.likeservice;


import androidx.annotation.NonNull;

import com.li.feeling.model.CurrentUser;
import com.li.framework.network.FeelingResponseTransformer;
import com.li.framework.scheduler_utility.SchedulerManager;

import io.reactivex.functions.Consumer;

/**
 * description:
 */
public class FeelLikeManager {

  @NonNull
  public static FeelLikeManager getInstance() {
    return Holder.instance;
  }

  // single instance
  private static class Holder {
    static FeelLikeManager instance = new FeelLikeManager();
  }

  // 点赞
  public void like(long feelId, @NonNull IFeelLikeCallback callback) {
    IFeelLikeApiService.sHomeFeelListLikeApiService.like(feelId, CurrentUser.get().getId())
        .observeOn(SchedulerManager.MAIN)
        .map(FeelingResponseTransformer.transform())
        .subscribe(new Consumer<FeelLikeResponse>() {
          @Override
          public void accept(FeelLikeResponse response) throws Exception {
            callback.onSucceed(response.mFeelId, response.mLikeNum, true);
          }
        }, throwable -> {
          callback.onFail(throwable, true);
        });
  }

  // 取消点赞
  public void cancelLike(long feelId, @NonNull IFeelLikeCallback callback) {
    IFeelLikeApiService.sHomeFeelListLikeApiService.cancelLike(feelId, CurrentUser.get().getId())
        .observeOn(SchedulerManager.MAIN)
        .map(FeelingResponseTransformer.transform())
        .subscribe(new Consumer<FeelLikeResponse>() {
          @Override
          public void accept(FeelLikeResponse response) throws Exception {
            callback.onSucceed(response.mFeelId, response.mLikeNum, false);
          }
        }, throwable -> {
          callback.onFail(throwable, false);
        });
  }

}
