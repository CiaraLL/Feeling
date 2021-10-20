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
    IFeelLikeApiService.sHomeFeelListLikeApiService.like(CurrentUser.get().getId(), feelId)
        .observeOn(SchedulerManager.MAIN)
        .map(FeelingResponseTransformer.transform())
        .subscribe(new Consumer<Boolean>() {
          @Override
          public void accept(Boolean aBoolean) throws Exception {
            callback.onSucceed(true);
          }
        }, throwable -> {
          callback.onFail(throwable, true);
        });
  }

  // 取消点赞
  public void cancelLike(long feelId, @NonNull IFeelLikeCallback callback) {
    IFeelLikeApiService.sHomeFeelListLikeApiService.cancelLike(CurrentUser.get().getId(), feelId)
        .observeOn(SchedulerManager.MAIN)
        .map(FeelingResponseTransformer.transform())
        .subscribe(new Consumer<Boolean>() {
          @Override
          public void accept(Boolean aBoolean) throws Exception {
            callback.onSucceed(false);
          }
        }, throwable -> {
          callback.onFail(throwable, false);
        });
  }

}
