package com.li.framework.network;

import java.io.Serializable;

import androidx.annotation.NonNull;

/**
 * description: 接口请求的返回内容
 */
public class FeelingResponse<Data> implements Serializable {

  // 返回结果，1代表success，其他都是error
  public int mResult = 1;
  // error时返回的消息
  public String mErrorMessage = "";
  // 接口成功(mResult为1)时，返回的数据
  public Data mData = null;

  // 成功的response
  @NonNull
  public static <Data> FeelingResponse success(@NonNull Data data) {
    FeelingResponse<Data> response = new FeelingResponse<>();
    response.mData = data;
    return response;
  }

  // 失败
  public static FeelingResponse fail(int errorCode, String errorMessage) {
    FeelingResponse response = new FeelingResponse<>();
    response.mResult = errorCode;
    response.mErrorMessage = errorMessage;
    return response;
  }

}
