package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.ShouyeWebBean;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/9.
 */

public class ShouyeaddShopWebModel {
    public void getData(String id, final ShouyeaddcartWebModelCallBack shouyeaddcartWebModelCallBack) {
        MyApplication.api.getWebBean(id,"android")
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ShouyeWebBean>() {
                    @Override
                    public void accept(ShouyeWebBean shouyeWebBean) throws Exception {
                        shouyeaddcartWebModelCallBack.success(shouyeWebBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        shouyeaddcartWebModelCallBack.failure(throwable.getMessage());
                    }
                });
    }
}
