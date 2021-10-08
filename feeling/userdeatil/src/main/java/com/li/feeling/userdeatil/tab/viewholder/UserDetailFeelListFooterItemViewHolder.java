package com.li.feeling.userdeatil.tab.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.li.feeling.userdeatil.R;
import com.li.feeling.userdeatil.tab.viewdata.UserDetailFeelListFooterItemViewData;
import com.li.library.recycler.LiRecycleViewHolder;

public class UserDetailFeelListFooterItemViewHolder extends
    LiRecycleViewHolder<UserDetailFeelListFooterItemViewData> {

  private TextView mTipView;
  public UserDetailFeelListFooterItemViewHolder(@NonNull View itemView) {
    super(itemView);
  }

  @Override
  protected void doBindView(@NonNull View itemView) {
    mTipView = itemView.findViewById(R.id.user_detail_footer_item_tip_view);
  }

  @Override
  protected void onBind(@NonNull UserDetailFeelListFooterItemViewData data, int position) {
    mTipView.setText(data.mTip);
  }

  @Override
  protected void onUnBind() {

  }
}
