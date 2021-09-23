package com.li.frameowrk.recycler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * description: 封装的recycleAdapter
 */
public abstract class LiRecyclerAdapter<Data extends LiRecyclerItemViewData>
    extends RecyclerView.Adapter<LiRecycleViewHolder<Data>> {

  @NonNull
  private List<Data> mDataList = new ArrayList<>();

  @NonNull
  private Set<LiRecycleViewHolder<Data>> mViewHolders = new HashSet<>();

  @Override
  public int getItemViewType(int position) {
    Data data = getItem(position);
    if (data != null) {
      return data.getItemDataType();
    }
    return super.getItemViewType(position);
  }

  @Override
  public void onBindViewHolder(@NonNull LiRecycleViewHolder<Data> holder, int position) {
    mViewHolders.add(holder);
    Data data = mDataList.get(position);
    if (data != null) {
      holder.bind(data, position);
    }
  }

  @Override
  public void onViewRecycled(@NonNull LiRecycleViewHolder<Data> holder) {
    super.onViewRecycled(holder);
    holder.unBind();
    mViewHolders.remove(holder);
  }

  @Override
  public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
    super.onDetachedFromRecyclerView(recyclerView);
    for (LiRecycleViewHolder<Data> viewHolder : mViewHolders) {
      viewHolder.unBind();
    }
    mViewHolders.clear();
  }

  public void setList(@NonNull List<Data> dataList) {
    mDataList = dataList;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return mDataList.size();
  }

  @Nullable
  private Data getItem(int position) {
    return mDataList.get(position);
  }


}
