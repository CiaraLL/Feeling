package com.li.feeling.notification.list.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.li.feeling.notification.list.viewdata.NotificationListFeelLikeItemViewData;
import com.li.library.recycler.LiRecycleViewHolder;
import com.li.message.R;

/**
 * feel点赞的ViewHolder
 */
public class NotificationListFeelLikeItemViewHolder
    extends LiRecycleViewHolder<NotificationListFeelLikeItemViewData> {

  // 头像
  private ImageView mAvatarView;
  // 点赞时间
  private TextView mTimeView;
  // 点赞的用户名
  private TextView mNameView;
  // 通知文案
  private TextView mContentView;

  public NotificationListFeelLikeItemViewHolder(@NonNull View itemView) {
    super(itemView);
  }

  @Override
  protected void doBindView(@NonNull View itemView) {
    mAvatarView = itemView.findViewById(R.id.notification_list_noti_item_avatar_view);
    mNameView = itemView.findViewById(R.id.notification_list_noti_item_name_view);
    mContentView = itemView.findViewById(R.id.notification_list_noti_item_content_view);
    mTimeView = itemView.findViewById(R.id.notification_list_noti_item_time_view);
  }

  @Override
  protected void onBind(@NonNull NotificationListFeelLikeItemViewData data, int position) {
    mAvatarView.setImageResource(data.mAvatarResId);
    mNameView.setText(data.mName);
    mContentView.setText(data.mContent);
    mTimeView.setText(data.mTime);
  }

  @Override
  protected void onUnBind() {

  }
}
