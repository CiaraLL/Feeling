package com.li.feeling.notification.list.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.li.library.recycler.LiRecycleViewHolder;
import com.li.message.R;
import com.li.feeling.notification.list.viewdata.NotificationListFooterItemViewData;

/**
 * 列表底部item的ViewHolder
 */
public class NotificationListFooterItemViewHolder
    extends LiRecycleViewHolder<NotificationListFooterItemViewData> {

  //提示文案
  private TextView mTipView;

  public NotificationListFooterItemViewHolder(@NonNull View itemView) {
    super(itemView);
  }

  @Override
  protected void doBindView(@NonNull View itemView) {
    mTipView = itemView.findViewById(R.id.notification_list_footer_item_tip_view);
  }

  @Override
  protected void onBind(@NonNull NotificationListFooterItemViewData data, int position) {
    mTipView.setText(data.mTip);
  }

  @Override
  protected void onUnBind() {

  }
}
