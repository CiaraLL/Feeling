package com.li.message.like.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.li.library.recycler.LiRecycleViewHolder;
import com.li.message.R;
import com.li.message.like.viewdata.HomeMessageListMessageItemViewData;

/**
 * 点赞列表内容item的ViewHolder
 */
public class HomeMessageListMessageItemViewHolder
    extends LiRecycleViewHolder<HomeMessageListMessageItemViewData> {

  //头像
  private ImageView mAvatarResId;
  //点赞时间
  private TextView mTime;
  //点赞的用户名
  private TextView mName;

  public HomeMessageListMessageItemViewHolder(@NonNull View itemView) {
    super(itemView);
  }

  @Override
  protected void doBindView(@NonNull View itemView) {
    mAvatarResId = itemView.findViewById(R.id.message_list_message_head_photo);
    mName = itemView.findViewById(R.id.message_list_message_user_name_view);
    mTime = itemView.findViewById(R.id.message_list_message_send_time);
  }

  @Override
  protected void onBind(@NonNull HomeMessageListMessageItemViewData data, int position) {
    mAvatarResId .setImageResource(data.mAvatarResId);
    mName.setText(data.mName);
    mTime.setText(data.mTime);
  }

  @Override
  protected void onUnBind() {

  }
}
