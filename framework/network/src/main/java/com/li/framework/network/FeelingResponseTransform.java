package com.li.framework.network;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * description:
 */
public class FeelingResponseTransform {

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
