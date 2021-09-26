package com.li.library.recycler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * description: 封装的recycleAdapter
 */
public abstract class LiRecyclerAdapter<Data extends LiRecyclerItemViewData>
    extends RecyclerView.Adapter<LiRecycleViewHolder<Data>> {

  @NonNull
  protected Context mContext;

  @NonNull
  private List<Data> mDataList = new ArrayList<>();

  @NonNull
  private Set<LiRecycleViewHolder<Data>> mViewHolders = new HashSet<>();

  public LiRecyclerAdapter(@NonNull Context context) {
    mContext = context;
  }

  @Override
  public int getItemViewType(int position) {
    Data data = getItem(position);
    if (data != null) {
      return data.getItemViewDataType();
    }
    return super.getItemViewType(position);
  }

  @NonNull
  @CallSuper
  @Override
  public LiRecycleViewHolder<Data> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    // 空的vh：当子类无法对viewType处理时
    View blankView = LayoutInflater.from(mContext)
        .inflate(R.layout.li_recycler_blank_item_layout, parent, false);
    return new LiRecyclerBlankItemViewHolder(blankView);
  }

  /**
   * 绑定holder
   * @param holder
   * @param position
   */
  @Override
  public void onBindViewHolder(@NonNull LiRecycleViewHolder<Data> holder, int position) {
    mViewHolders.add(holder);
    Data data = mDataList.get(position);
    if (data != null) {
      holder.bind(data, position);
    }
  }

  /**
   * 回收holder
   * @param holder
   */
  @Override
  public void onViewRecycled(@NonNull LiRecycleViewHolder<Data> holder) {
    super.onViewRecycled(holder);
    holder.unBind();
    mViewHolders.remove(holder);
  }

  /**
   * 滚动至不可见时调用该方法，页面退出时不调用
   * 解注册释放资源
   * @param recyclerView
   */
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
  public Data getItem(int position) {
    return mDataList.get(position);
  }

}
