package com.li.library.recycler;

/**
 * description: recycler的item的view数据，
 * 这个数据不能有业务数据，UI需要什么data就是什么，不要有额外的业务数据掺杂进来
 */
public interface LiRecyclerItemViewData {

  // view数据的类型
  int getItemViewDataType();

}
