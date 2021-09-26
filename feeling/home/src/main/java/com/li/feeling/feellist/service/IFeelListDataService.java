package com.li.feeling.feellist.service;

import java.util.List;

import androidx.annotation.NonNull;

import com.li.feeling.model.Feel;
import com.li.feeling.model.User;
import com.li.framework.network.FeelingResponse;
import com.li.framework.network.FeelingRetrofitConfig;
import com.li.framework.network.FeelingUrl;
import com.li.framework.scheduler_utility.SchedulerManager;
import com.li.library.retrofit_utlity.RetrofitManager;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * description: feel列表数据服务
 */
public interface IFeelListDataService {

    // 单例
    IFeelListDataService mFeelListDAtaService = RetrofitManager.getInstance()
            .create(new FeelingRetrofitConfig(FeelingUrl.REQUSETFEEL, SchedulerManager.NETWORKING),
                    IFeelListDataService.class);

    static IFeelListDataService get() {
        return mFeelListDAtaService;
    }

    // 获取列表数据
    @FormUrlEncoded
    @POST("/feeling/feellist")
    Observable<FeelingResponse<Feel>> getFeelListData();

}
