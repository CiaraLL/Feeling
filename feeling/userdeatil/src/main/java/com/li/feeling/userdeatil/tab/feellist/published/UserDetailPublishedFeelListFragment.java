package com.li.feeling.userdeatil.tab.feellist.published;

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
import com.li.feeling.userdeatil.tab.adapter.UserDetailFeelListPublishedAdapter;
import com.li.feeling.userdeatil.tab.feellist.UserDetailFeelListBaseFragment;
import com.li.feeling.userdeatil.tab.viewdata.UserDetailFeelListFooterItemViewData;
import com.li.feeling.userdeatil.tab.viewdata.UserDetailPublishedFeeListItemViewData;
import com.li.framework.common_util.RxUtil;
import com.li.framework.network.FeelingResponseTransformer;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.recycler.LiRecyclerItemViewData;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * description: 用户详情页面--用户自己发布的feel列表
 */
public class UserDetailPublishedFeelListFragment extends UserDetailFeelListBaseFragment {

  private RecyclerView mRecyclerView;
  private UserDetailFeelListPublishedAdapter mUserDetailFeelListPublishedAdapter;
  private Disposable mFeelListPublishedDisposable;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_user_detail_published_feel_list_layout;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState,
      boolean isFirstCall) {
    super.onViewCreated(view, savedInstanceState);
    if (isFirstCall) {
      initView(view);
      onFeelListChanged();
    }
  }

  private void onFeelListChanged() {
    mFeelListPublishedDisposable = IUserDetailApiService.get()
        .getUserPublishedFeelListData()
        .map(FeelingResponseTransformer.transform())
        .observeOn(SchedulerManager.MAIN)
        .subscribe(new Consumer<UserDetailFeelListResponse>() {
          @Override
          public void accept(UserDetailFeelListResponse response) {
            onFeelingPublishedDataChanged(response.mFeelList, response.mFooterTip);
          }
        }, throwable -> {

        });
  }

  private void onFeelingPublishedDataChanged(List<Feel> feelList, String footerTip) {
    List<LiRecyclerItemViewData> LikeItemViewDataList = new ArrayList<>();
    for (Feel feel : feelList) {
      UserDetailPublishedFeeListItemViewData publishedFeeListItemViewData =
          new UserDetailPublishedFeeListItemViewData();
      publishedFeeListItemViewData.mAvatarResId = R.drawable.mine_head_my_photo;
      publishedFeeListItemViewData.mContentText = feel.mContentText;
      publishedFeeListItemViewData.mName = feel.mUser.mNickName;
      publishedFeeListItemViewData.mTime = feel.mPublishTime + "";
      publishedFeeListItemViewData.mLikeNum = feel.mLikeNum;
      LikeItemViewDataList.add(publishedFeeListItemViewData);
    }
    LikeItemViewDataList.add(new UserDetailFeelListFooterItemViewData(footerTip));
    mUserDetailFeelListPublishedAdapter.setList(LikeItemViewDataList);
  }

  private void initView(View view) {
    mRecyclerView = view.findViewById(R.id.user_detail_published_feel_list_recycler);

    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mUserDetailFeelListPublishedAdapter = new UserDetailFeelListPublishedAdapter(getContext());
    mRecyclerView.setAdapter(mUserDetailFeelListPublishedAdapter);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    RxUtil.dispose(mFeelListPublishedDisposable);
  }
}
