package com.li.feeling.common.like.likeservice;

import androidx.annotation.NonNull;

/**
 * description: 点赞/取消点赞的回调
 */
public interface IFeelLikeCallback {

  /**
   * 成功的回调
   *
   * @param feelId  点赞的feel
   * @param feelLikeNum 点赞数
   * @param isLike  区分点赞还是取消点赞
   */
  void onSucceed(long feelId, int feelLikeNum, boolean isLike);

  void onFail(@NonNull Throwable throwable, boolean isLike);

}
