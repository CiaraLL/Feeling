package com.li.library.retrofit_utlity.multi;

import java.io.File;
import java.net.FileNameMap;
import java.net.URLConnection;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * author: lanweihua
 * created on: 2022/3/16 4:38 下午
 * description: okHttp文件传输的body工厂
 */
public class MultipartBodyPartFactory {

  public static MultipartBody.Part createPart(@NonNull File file) {
    MediaType mediaType = getMediaType(file);
    RequestBody requestBody = RequestBody.create(mediaType, file);
    return MultipartBody.Part.create(requestBody);
  }

  /**
   * 获得文件类型
   */
  private static MediaType getMediaType(@NonNull File file) {
    String mime = getMimeType(file.getName());
    if (TextUtils.isEmpty(mime)) {
      mime = "multipart/form-data";
    }
    return MediaType.parse(mime);
  }

  /**
   * 获得文件格式
   */
  @Nullable
  private static String getMimeType(String fileName) {
    FileNameMap fileNameMap = URLConnection.getFileNameMap();
    return fileNameMap.getContentTypeFor(fileName);
  }


}
