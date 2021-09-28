package com.li.framework.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.li.framework.gson.FeelingGson;
import com.li.library.retrofit_utlity.BaseRetrofitConfig;

import io.reactivex.Scheduler;

/**
 * description: retrofit的配置
 */
public class FeelingRetrofitConfig extends BaseRetrofitConfig {

  @NonNull
  private FeelingUrl mFeelingUrl;
  @Nullable
  private Scheduler mScheduler;

  public FeelingRetrofitConfig(@NonNull FeelingUrl feelingUrl) {
    mFeelingUrl = feelingUrl;
  }

  public FeelingRetrofitConfig(@NonNull FeelingUrl feelingUrl, @Nullable Scheduler scheduler) {
    mFeelingUrl = feelingUrl;
    mScheduler = scheduler;
  }

  @NonNull
  @Override
  public Gson getGson() {
    return FeelingGson.GSON;
  }

  @NonNull
  @Override
  public String getBaseUrl() {
    return FeelUrlUtil.getUrl(mFeelingUrl);
  }

  @Override
  public Scheduler getSubscribeScheduler() {
      return mScheduler;
  }

}
