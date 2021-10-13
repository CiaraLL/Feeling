package com.li.feeling.userdeatil.tab.feellist.like;

import java.util.ArrayList;
import java.util.List;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.li.feeling.model.CurrentUser;
import com.li.feeling.model.Feel;
import com.li.feeling.userdeatil.R;
import com.li.feeling.userdeatil.service.IUserDetailApiService;
import com.li.feeling.userdeatil.service.UserDetailFeelListResponse;
import com.li.feeling.userdeatil.tab.adapter.UserDetailFeelListBaseRecyclerAdapter;
import com.li.feeling.userdeatil.tab.adapter.UserDetailFeelListPublishedAdapter;
import com.li.feeling.userdeatil.tab.feellist.UserDetailFeelListBaseFragment;
import com.li.feeling.userdeatil.tab.viewdata.UserDetailFeelListFooterItemViewData;
import com.li.feeling.userdeatil.tab.viewdata.UserDetailFeelListLikeFeelItemViewData;
import com.li.framework.common_util.CollectionUtil;
import com.li.framework.common_util.RxUtil;
import com.li.framework.common_util.ToastUtil;
import com.li.framework.network.FeelingException;
import com.li.framework.network.FeelingResponseTransformer;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.recycler.LiRecyclerItemViewData;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * description: 用户详情页面--feel点赞列表
 */
public class UserDetailLikeFeelListFragment extends UserDetailFeelListBaseFragment {

  private Disposable mFeelListDisposable;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_user_detail_published_feel_list_layout;
  }

  @Override
  protected void refreshFeelList() {
    mFeelListDisposable = IUserDetailApiService.get()
        .getUserLikeFeelListData(CurrentUser.get().getId())
        .map(FeelingResponseTransformer.transform())
        .observeOn(SchedulerManager.MAIN)
        .doFinally(new Action() {
          @Override
          public void run() throws Exception {
            stopRefresh();
          }
        })
        .subscribe(new Consumer<UserDetailFeelListResponse>() {
          @Override
          public void accept(UserDetailFeelListResponse response) {
            onFeelListDataChanged(response.mFeelList, response.mFooterTip);
          }
        }, throwable -> {
          if (throwable instanceof FeelingException) {
            ToastUtil.showToast(((FeelingException) throwable).mErrorMessage);
          } else {
            ToastUtil.showToast("加载失败，请稍后重试");
          }
        });
  }

  // 数据更新
  private void onFeelListDataChanged(
      @Nullable List<Feel> feelList,
      @Nullable String footerTip) {
    // 数据为空
    if (CollectionUtil.isEmpty(feelList)) {
      mRecyclerAdapter.setList(new ArrayList<>());
      return;
    }
    List<LiRecyclerItemViewData> LikeItemViewDataList = new ArrayList<>();
    for (Feel feel : feelList) {
      UserDetailFeelListLikeFeelItemViewData itemViewData =
          new UserDetailFeelListLikeFeelItemViewData();
      itemViewData.mAvatarResId = R.drawable.mine_head_my_photo;
      itemViewData.mContentText = feel.mContentText;
      itemViewData.mName = feel.mUser.mNickName;
      itemViewData.mTime = feel.mPublishTime + "";
      itemViewData.mLikeNum = feel.mLikeNum;
      LikeItemViewDataList.add(itemViewData);
    }
    // footer
    if (!TextUtils.isEmpty(footerTip)) {
      LikeItemViewDataList.add(new UserDetailFeelListFooterItemViewData(footerTip));
    }
    mRecyclerAdapter.setList(LikeItemViewDataList);
  }

  @NonNull
  @Override
  protected UserDetailFeelListBaseRecyclerAdapter createRecyclerAdapter() {
    return new UserDetailFeelListPublishedAdapter(getContext());
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    RxUtil.dispose(mFeelListDisposable);
  }
}
