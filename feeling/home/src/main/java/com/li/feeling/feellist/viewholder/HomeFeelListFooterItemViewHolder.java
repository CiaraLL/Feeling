package com.li.feeling.feellist.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.li.feeling.feellist.viewdata.HomeFeelingListFooterItemViewData;
import com.li.feeling.home.R;
import com.li.library.recycler.LiRecycleViewHolder;

/**
 * description: footer的vh
 */
public class HomeFeelListFooterItemViewHolder
    extends LiRecycleViewHolder<HomeFeelingListFooterItemViewData> {

  private TextView mTipView;

  public HomeFeelListFooterItemViewHolder(@NonNull View itemView) {
    super(itemView);
  }

  @Override
  protected void doBindView(@NonNull View itemView) {
    mTipView = itemView.findViewById(R.id.feel_list_footer_item_tip_view);
  }

  @Override
  protected void onBind(@NonNull HomeFeelingListFooterItemViewData data, int position) {
    mTipView.setText(data.mTip);
  }

  @Override
  protected void onUnBind() {

  }

}
