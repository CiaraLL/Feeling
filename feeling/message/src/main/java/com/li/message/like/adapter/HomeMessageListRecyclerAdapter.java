package com.li.message.like.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

import com.li.library.recycler.LiRecycleViewHolder;
import com.li.library.recycler.LiRecyclerAdapter;
import com.li.library.recycler.LiRecyclerItemViewData;
import com.li.message.R;
import com.li.message.like.viewdata.HomeMessageListItemViewDataType;
import com.li.message.like.viewholder.HomeMessageListMessageFooterViewHolder;
import com.li.message.like.viewholder.HomeMessageListMessageItemViewHolder;

/**
 * 点赞消息列表的adapter
 */
public class HomeMessageListRecyclerAdapter extends LiRecyclerAdapter<LiRecyclerItemViewData> {

  public HomeMessageListRecyclerAdapter(
      @NonNull Context context) {
    super(context);
  }

  @NonNull
  @Override
  public LiRecycleViewHolder onCreateViewHolder(
      @NonNull ViewGroup parent,
      int viewType) {

    switch (viewType){
      case HomeMessageListItemViewDataType.MESSAGE_ITEM:
        View itemView = LayoutInflater.from(mContext)
            .inflate(R.layout.message_list_message_item_layout,parent,false);
        return new HomeMessageListMessageItemViewHolder(itemView);
      case HomeMessageListItemViewDataType.MESSAGE_FOOTER:
        View footerView = LayoutInflater.from(mContext)
            .inflate(R.layout.message_list_footer_item_layout,parent,false);
        return new HomeMessageListMessageFooterViewHolder(footerView);
    }
    return super.onCreateViewHolder(parent, viewType);
  }
}
