package com.li.framework.scheduler_utility;

import java.util.concurrent.Executors;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * description: RxJava的Scheduler分类
 * ObserverOn时Accept函数使用的Scheduler
 */
public class SchedulerManager {

  // 主线程
  public static final Scheduler MAIN = AndroidSchedulers.mainThread();

  // 用于网络操作
  public static final Scheduler NETWORKING = Schedulers.from(Executors.newFixedThreadPool(4));

  // 用于异步操作，比如读写文件
  public static final Scheduler ASYNC = Schedulers.from(Executors.newFixedThreadPool(4));

}
