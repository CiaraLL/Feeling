package com.li.framework.network;

import android.os.Handler;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * description: 用于将{@link FeelingResponse}中的Data提取出来向下传递，
 * 如果是error，那么向下传递@{@link FeelingException}
 */
public class FeelingResponseTransformer {

  // 提供此方法是为了减少模版代码的copy，要不然api的调用方在请求后都需要写这一套代码，因此把这段模版代码放在一个函数中
  // TODO: 9/26/21 最好是在retrofit拿到response的时候去做这个事情，放在retrofit中做转换，对接口调用方透明
  public static <Data> Function<FeelingResponse<Data>, Data> transform() {
    return new Function<FeelingResponse<Data>, Data>() {

      @Override
      public Data apply(@NonNull FeelingResponse<Data> response) throws Exception {
        if (response.mResult == 1) {
          return response.mData;
        }
        throw new FeelingException(response.mResult, response.mErrorMessage);
      }
    };
  }

}
