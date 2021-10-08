package com.li.feeling.userdeatil.tab.feellist.like;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.li.feeling.model.Feel;
import com.li.feeling.userdeatil.R;
import com.li.feeling.userdeatil.service.IUserDetailApiService;
import com.li.feeling.userdeatil.service.UserDetailFeelListResponse;
import com.li.feeling.userdeatil.tab.adapter.UserDetailFeelListLikeAdapter;
import com.li.feeling.userdeatil.tab.feellist.UserDetailFeelListBaseFragment;
import com.li.feeling.userdeatil.tab.viewdata.UserDetailFeelListFooterItemViewData;
import com.li.feeling.userdeatil.tab.viewdata.UserDetailLikeFeelListItemViewData;
import com.li.framework.common_util.RxUtil;
import com.li.framework.network.FeelingResponseTransformer;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.recycler.LiRecyclerItemViewData;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * description: 用户详情页面--feel点赞列表
 */
public class UserDetailLikeFeelListFragment extends UserDetailFeelListBaseFragment {

  private RecyclerView mRecyclerView;
  private UserDetailFeelListLikeAdapter mUserDetailFeelListLikeAdapter;

  @Nullable
  private Disposable mFeelListLikeDisposable;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_user_detail_like_feel_list_layout;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState,
      boolean isFirstCall) {
    super.onViewCreated(view, savedInstanceState);
    // 刷新列表数据
    if (isFirstCall) {
      initView(view);
      refreshLikeFeelList();
    }
  }

  private void initView(View view) {
    mRecyclerView = view.findViewById(R.id.user_detail_like_feel_list_recycler);

    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mUserDetailFeelListLikeAdapter = new UserDetailFeelListLikeAdapter(getContext());
    mRecyclerView.setAdapter(mUserDetailFeelListLikeAdapter);
  }
  /**
   * 请求网络
   */
  private void refreshLikeFeelList() {
    mFeelListLikeDisposable = IUserDetailApiService.get()
        .getUserLikeFeelListData()
        .observeOn(SchedulerManager.MAIN)
        .map(FeelingResponseTransformer.transform())
        .subscribe(new Consumer<UserDetailFeelListResponse>() {
          @Override
          public void accept(UserDetailFeelListResponse response) {
            onFeelingLikeDataChanged(response.mFeelList, response.mFooterTip);
          }
        }, throwable -> {

        });
  }

  private void onFeelingLikeDataChanged(@NonNull List<Feel> feelList, String footerTip) {
    List<LiRecyclerItemViewData> LikeItemViewDataList = new ArrayList<>();

    for (Feel feel : feelList) {
      UserDetailLikeFeelListItemViewData likeFeelListItemViewData =
          new UserDetailLikeFeelListItemViewData();
      likeFeelListItemViewData.mAvatarResId = R.drawable.mine_head_my_photo;
      likeFeelListItemViewData.mName = feel.mUser.mNickName;
      likeFeelListItemViewData.mTime = feel.mPublishTime + "";
      likeFeelListItemViewData.mContentText = feel.mContentText;
      likeFeelListItemViewData.mLikeNum = feel.mLikeNum;
      LikeItemViewDataList.add(likeFeelListItemViewData);
    }
    LikeItemViewDataList.add(new UserDetailFeelListFooterItemViewData(footerTip));
    mUserDetailFeelListLikeAdapter.setList(LikeItemViewDataList);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    RxUtil.dispose(mFeelListLikeDisposable);
  }
}
