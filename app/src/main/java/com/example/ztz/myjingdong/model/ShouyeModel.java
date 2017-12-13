package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.ShouyeGridBean;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/8.
 */

public class ShouyeModel {
    public void getData(final ShouyeModelCallBack shouyeModelCallBack) {
        MyApplication.api.getBean()
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ShouyeGridBean>() {
                    @Override
                    public void accept(ShouyeGridBean shouyeGridBean) throws Exception {
                        shouyeModelCallBack.Success(shouyeGridBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        shouyeModelCallBack.failure(throwable.getMessage());
                    }
                });
    }
}
