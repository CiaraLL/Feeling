package com.li.message.like.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.li.library.recycler.LiRecycleViewHolder;
import com.li.message.R;
import com.li.message.like.viewdata.HomeMessageListMessageFooterViewData;

/**
 * 点赞列表底部item的ViewHolder
 */
public class HomeMessageListMessageFooterViewHolder
    extends LiRecycleViewHolder<HomeMessageListMessageFooterViewData> {

  //提示文案
  private TextView mTip;

  public HomeMessageListMessageFooterViewHolder(@NonNull View itemView) {
    super(itemView);
  }

  @Override
  protected void doBindView(@NonNull View itemView) {
    mTip = itemView.findViewById(R.id.message_list_message_footer_item);
  }

  @Override
  protected void onBind(@NonNull HomeMessageListMessageFooterViewData data, int position) {
    mTip.setText(data.mTip);
  }

  @Override
  protected void onUnBind() {

  }
}
