package com.li.feeling.feellist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.li.feeling.feellist.adapter.HomeFeelListRecyclerAdapter;
import com.li.feeling.feellist.service.FeelListResponse;
import com.li.feeling.feellist.service.IFeelListApiService;
import com.li.feeling.feellist.viewdata.HomeFeelingListFeelItemViewData;
import com.li.feeling.feellist.viewdata.HomeFeelingListFooterItemViewData;
import com.li.feeling.home.R;
import com.li.feeling.model.Feel;
import com.li.feeling.publish.PublishFeelActivity;
import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.common_util.RxUtil;
import com.li.framework.common_util.ToastUtil;
import com.li.framework.network.FeelingException;
import com.li.framework.network.FeelingResponseTransformer;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.framework.ui.utility.DuplicatedClickFilter;
import com.li.library.recycler.LiRecyclerItemViewData;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * home页面的feel列表Fragment
 */
public class HomeFeelListFragment extends BaseFragment {

  private RecyclerView mRecyclerView;
  private HomeFeelListRecyclerAdapter mFeelListAdapter;
  private Button mAddFeelView;

  @Nullable
  private Disposable mFeelListDisposable;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_home_feel_list_layout;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initView(view);
    // 刷新列表数据
    refreshFeelList();
  }

  private void initView(@NonNull View view) {
    mRecyclerView = view.findViewById(R.id.home_feel_list_recycler_view);
    mAddFeelView = view.findViewById(R.id.home_feel_list_add_feel_view);

    mAddFeelView.setOnClickListener(new DuplicatedClickFilter() {
      @Override
      protected void handleClickEvent() {
        Activity activity = getActivity();
        if(activity != null){
          PublishFeelActivity.start(activity);
        }
      }
    });

    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mFeelListAdapter = new HomeFeelListRecyclerAdapter(getContext());
    mRecyclerView.setAdapter(mFeelListAdapter);
  }

  // 刷新feel列表:网络请求
  @NonNull
  private void refreshFeelList() {
    mFeelListDisposable = IFeelListApiService.get()
        .getFeelListData()
        .observeOn(SchedulerManager.MAIN)
        .map(FeelingResponseTransformer.transform())
        .subscribe(
            new Consumer<FeelListResponse>() {
              @Override
              public void accept(FeelListResponse response) {
                onFeelListDataChanged(response.mFeelList, response.mFooterTip);
              }
            },
            throwable -> {
              if (throwable instanceof FeelingException) {
                ToastUtil.showToast(((FeelingException) throwable).mErrorMessage);
              }
            });
  }

  /**
   * 列表数据变化时
   *
   * @param feelList  列表数据
   * @param footerTip 滑动到底部的提示
   */
  private void onFeelListDataChanged(@NonNull List<Feel> feelList, String footerTip) {
    //列表UI数据
    List<LiRecyclerItemViewData> itemViewDataList = new ArrayList<>();

    // 把原始的业务数据转化为列表需要的UI数据
    for (Feel feel : feelList) {
      HomeFeelingListFeelItemViewData feelItemViewData = new HomeFeelingListFeelItemViewData();
      feelItemViewData.mAvatarResId = R.drawable.mine_head_my_photo;
      feelItemViewData.mName = feel.mUser.mNickName;
      feelItemViewData.mTime = feel.mPublishTime + "";
      feelItemViewData.mContentText = feel.mContentText;
      feelItemViewData.mLikeNum = feel.mLikeNum;

      itemViewDataList.add(feelItemViewData);
    }

    // footerItem需要的数据
    itemViewDataList.add(new HomeFeelingListFooterItemViewData(footerTip));

    mFeelListAdapter.setList(itemViewDataList);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    RxUtil.dispose(mFeelListDisposable);
  }
}