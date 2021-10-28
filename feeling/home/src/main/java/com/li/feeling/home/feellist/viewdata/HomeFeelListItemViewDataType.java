package com.li.feeling.home.feellist.viewdata;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

/**
 * description: feel列表的item类型
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({HomeFeelListItemViewDataType.FEEL_TYPE, HomeFeelListItemViewDataType.FOOTER_TYPE})
public @interface HomeFeelListItemViewDataType {

  int FEEL_TYPE = 1; // feel类型
  int FOOTER_TYPE = 2; // footer类型

}
