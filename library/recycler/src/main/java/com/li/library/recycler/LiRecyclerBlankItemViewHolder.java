package com.li.library.recycler;

import android.view.View;
import androidx.annotation.NonNull;

/**
 * description: 空的vh
 * 当RecycleAdapter的onCreateViewHolder方法中无法处理viewType时，使用该空的vh
 */
public class LiRecyclerBlankItemViewHolder extends LiRecycleViewHolder{

  public LiRecyclerBlankItemViewHolder(@NonNull View itemView) {
    super(itemView);
  }

  @Override
  protected void doBindView(@NonNull View itemView) {

  }

  @Override
  protected void onBind(@NonNull LiRecyclerItemViewData data, int position) {

  }

  @Override
  protected void onUnBind() {

  }
}
