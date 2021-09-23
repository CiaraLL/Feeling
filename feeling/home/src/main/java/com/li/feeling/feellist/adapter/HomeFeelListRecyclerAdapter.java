package com.li.feeling.feellist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

import com.li.feeling.feellist.viewdata.HomeFeelListItemViewDataType;
import com.li.feeling.feellist.viewholder.HomeFeelListFeelItemViewHolder;
import com.li.feeling.feellist.viewholder.HomeFeelListFooterItemViewHolder;
import com.li.feeling.home.R;
import com.li.frameowrk.recycler.LiRecycleViewHolder;
import com.li.frameowrk.recycler.LiRecyclerAdapter;
import com.li.frameowrk.recycler.LiRecyclerItemViewData;

public class HomeFeelListRecyclerAdapter
    extends LiRecyclerAdapter<LiRecyclerItemViewData> {

  public HomeFeelListRecyclerAdapter(@NonNull Context context) {
    super(context);
  }

  @NonNull
  @Override
  public LiRecycleViewHolder onCreateViewHolder(
      @NonNull ViewGroup parent, int viewType) {
    switch (viewType) {
      case HomeFeelListItemViewDataType.FEEL_TYPE:
        View feelItemView = LayoutInflater.from(mContext)
            .inflate(R.layout.home_feel_list_feel_item_layout, parent, false);
        return new HomeFeelListFeelItemViewHolder(feelItemView);
      case HomeFeelListItemViewDataType.FOOTER_TYPE:
        View footerItemView = LayoutInflater.from(mContext)
            .inflate(R.layout.home_feel_list_footer_item_layout, parent, false);
        return new HomeFeelListFooterItemViewHolder(footerItemView);
    }
    return super.onCreateViewHolder(parent, viewType);
  }

}
