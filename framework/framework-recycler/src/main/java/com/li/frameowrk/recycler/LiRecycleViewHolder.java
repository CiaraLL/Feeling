package com.li.frameowrk.recycler;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * description: viewHolder基类
 */
public abstract class
LiRecycleViewHolder<Data extends LiRecyclerItemViewData>
    extends RecyclerView.ViewHolder {

  private Data mData;
  private int mPosition;

  public LiRecycleViewHolder(@NonNull View itemView) {
    super(itemView);
    doBindView(itemView);
  }

  public void bind(@NonNull Data data, int position) {
    mData = data;
    mPosition = position;
    onBind(mData, mPosition);
  }

  public void unBind() {
    mData = null;
    onUnBind();
  }

  // 提供获得view的时机
  protected abstract void doBindView(@NonNull View itemView);

  protected abstract void onBind(@NonNull Data data, int position);

  protected abstract void onUnBind();

}
