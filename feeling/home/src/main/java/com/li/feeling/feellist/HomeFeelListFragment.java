package com.li.feeling.feellist;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.li.feeling.feellist.adapter.HomeFeelListRecyclerAdapter;
import com.li.feeling.feellist.service.IFeelListDataService;
import com.li.feeling.feellist.service.IFeelListDataServiceImpl;
import com.li.feeling.feellist.viewdata.HomeFeelingListFeelItemViewData;
import com.li.feeling.feellist.viewdata.HomeFeelingListFooterItemViewData;
import com.li.feeling.home.R;
import com.li.feeling.model.Feel;
import com.li.fragment.base_page.fragment.BaseFragment;
import com.li.framework.common_util.ToastUtil;
import com.li.framework.network.FeelingException;
import com.li.framework.network.FeelingResponse;
import com.li.framework.network.FeelingResponseTransformer;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.recycler.LiRecyclerItemViewData;
import com.li.library.retrofit_utlity.BaseRetrofitConfig;
import com.li.library.retrofit_utlity.RetrofitManager;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * home页面的feel列表Fragment
 */
public class HomeFeelListFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private HomeFeelListRecyclerAdapter mFeelListAdapter;

    @Nullable
    private Disposable mFeelListDisposable;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_feel_list_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        // 展示列表数据
        updateFeelList();
    }

    private void initView(@NonNull View view) {
        mRecyclerView = view.findViewById(R.id.home_feel_list_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mFeelListAdapter = new HomeFeelListRecyclerAdapter(getContext());
        mRecyclerView.setAdapter(mFeelListAdapter);
    }

    // 更新列表
    private void updateFeelList() {
        mFeelListAdapter.setList(getFeelListViewDataList());
    }

    // 列表需要的UI数据
    @NonNull
    private List<LiRecyclerItemViewData> getFeelListViewDataList() {
//    // 原始数据
//    List<Feel> feelListData = RetrofitManager.getInstance().create(new BaseRetrofitConfig() {
//      @NonNull
//      @Override
//      public String getBaseUrl() {
//        return "";
//      }
//
//      @Override
//      public Scheduler getSubscribeScheduler() {
//        return null;
//      }
//    }, IFeelListDataService.class).getFeelListData();
//
//        // 原始数据
//        IFeelListDataService feelListDataService = null;
//        List<Feel> feelListData = (List<Feel>) feelListDataService.getFeelListData();


//        //列表UI数据
//        List<LiRecyclerItemViewData> itemViewDataList = new ArrayList<>();

//
//        // 把原始的业务数据转化为列表需要的UI数据
//        for (Feel feel : feelListData) {
//            HomeFeelingListFeelItemViewData feelItemViewData = new HomeFeelingListFeelItemViewData();
//            feelItemViewData.mAvatarResId = R.drawable.mine_head_my_photo;
//            feelItemViewData.mName = feel.mUser.mNickName;
//            feelItemViewData.mTime = feel.mPublishTime + "";
//            feelItemViewData.mContentText = feel.mContentText;
//            feelItemViewData.mLikeNum = feel.mLikeNum;
//
//            itemViewDataList.add(feelItemViewData);
//        }
//
//        // footerItem需要的数据
//        itemViewDataList.add(new HomeFeelingListFooterItemViewData("到底啦"));
//        return itemViewDataList;


        IFeelListDataServiceImpl feelListDataService;
        mFeelListDisposable = IFeelListDataService
                .get()
                .getFeelListData()
                .observeOn(SchedulerManager.MAIN)
                .map(FeelingResponseTransformer.transform())
                .subscribe(new Consumer<Feel>() {
                    @Override
                    public void accept(Feel feel) throws Exception {
                        feel = feelListDataService.getFeelListData();
                        return FeelingResponse.success(feel);
                    }
                }, throwable -> {
                    if (throwable instanceof FeelingException) {
                        ToastUtil.showToast(((FeelingException) throwable).mErrorMessage);
                    }
                });
    }

}