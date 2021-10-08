package com.li.feeling.userdeatil.tab.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

import com.li.library.recycler.LiRecycleViewHolder;

public class UserDetailFeelListLikeAdapter extends UserDetailFeelListBaseRecyclerAdapter{
  public UserDetailFeelListLikeAdapter(
      @NonNull Context context) {
    super(context);
  }

  @NonNull
  @Override
  public LiRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return super.onCreateViewHolder(parent, viewType);
  }
}
