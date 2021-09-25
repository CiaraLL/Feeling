package com.li.framework.network;

/**
 * description: 异常
 */
public class FeelingException extends Exception {

  public int mErrorCode;

  public String mErrorMessage;

  public FeelingException(int errorCode, String errorMessage) {
    mErrorCode = errorCode;
    mErrorMessage = errorMessage;
  }

}
