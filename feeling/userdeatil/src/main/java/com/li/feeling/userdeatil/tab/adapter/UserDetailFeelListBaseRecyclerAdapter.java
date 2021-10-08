package com.li.feeling.userdeatil.tab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

import com.li.feeling.userdeatil.R;
import com.li.feeling.userdeatil.tab.viewdata.UserDetailFeelListItemViewDataType;
import com.li.feeling.userdeatil.tab.viewholder.UserDetailFeelListFeelItemViewHolder;
import com.li.feeling.userdeatil.tab.viewholder.UserDetailFeelListFooterItemViewHolder;
import com.li.library.recycler.LiRecycleViewHolder;
import com.li.library.recycler.LiRecyclerAdapter;
import com.li.library.recycler.LiRecyclerItemViewData;

public class UserDetailFeelListBaseRecyclerAdapter
    extends LiRecyclerAdapter<LiRecyclerItemViewData> {

  public UserDetailFeelListBaseRecyclerAdapter(
      @NonNull Context context) {
    super(context);
  }

  @NonNull
  @Override
  public LiRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
      int viewType) {

    switch (viewType){
      case UserDetailFeelListItemViewDataType.FEEL_TYPE:
        View feelItemView = LayoutInflater.from(mContext)
            .inflate(R.layout.user_detail_feel_list_feel_item_layout,parent,false);
        return new UserDetailFeelListFeelItemViewHolder(feelItemView);
      case UserDetailFeelListItemViewDataType.FOOTER_TYPE:
        View footerItemView = LayoutInflater.from(mContext)
            .inflate(R.layout.user_detail_feel_list_footer_item_layout,parent,false);
        return new UserDetailFeelListFooterItemViewHolder(footerItemView);
    };
    return super.onCreateViewHolder(parent,viewType);
  }
}
