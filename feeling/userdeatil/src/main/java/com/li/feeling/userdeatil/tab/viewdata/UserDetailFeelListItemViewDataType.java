package com.li.feeling.userdeatil.tab.viewdata;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

@Retention(RetentionPolicy.SOURCE)
@IntDef({UserDetailFeelListItemViewDataType.FEEL_TYPE,
    UserDetailFeelListItemViewDataType.FOOTER_TYPE})
public @interface UserDetailFeelListItemViewDataType {

  int FEEL_TYPE = 1;
  int FOOTER_TYPE = 2;
}
