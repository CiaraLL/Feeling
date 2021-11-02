package com.li.feeling.notification.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

import com.li.library.recycler.LiRecycleViewHolder;
import com.li.library.recycler.LiRecyclerAdapter;
import com.li.library.recycler.LiRecyclerItemViewData;
import com.li.message.R;
import com.li.feeling.notification.list.viewdata.type.NotificationListItemViewDataType;
import com.li.feeling.notification.list.viewholder.NotificationListFooterItemViewHolder;
import com.li.feeling.notification.list.viewholder.NotificationListFeelLikeItemViewHolder;

/**
 * 通知列表的adapter
 */
public class NotificationListRecyclerAdapter extends LiRecyclerAdapter<LiRecyclerItemViewData> {

  public NotificationListRecyclerAdapter(
      @NonNull Context context) {
    super(context);
  }

  @NonNull
  @Override
  public LiRecycleViewHolder onCreateViewHolder(
      @NonNull ViewGroup parent,
      int viewType) {

    switch (viewType){
      case NotificationListItemViewDataType.FEEL_LIKE:
        View itemView = LayoutInflater.from(mContext)
            .inflate(R.layout.notification_list_noti_item_layout,parent,false);
        return new NotificationListFeelLikeItemViewHolder(itemView);
      case NotificationListItemViewDataType.FOOTER:
        View footerView = LayoutInflater.from(mContext)
            .inflate(R.layout.notification_list_footer_item_layout,parent,false);
        return new NotificationListFooterItemViewHolder(footerView);
    }
    return super.onCreateViewHolder(parent, viewType);
  }
}
