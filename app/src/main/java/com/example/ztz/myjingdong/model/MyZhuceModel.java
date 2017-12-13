package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.LoginBean;
import com.example.ztz.myjingdong.bean.ZhuceBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/11.
 */

public class MyZhuceModel {
    public void zhuce(String zk, String mima, final MyZhuceModelCallBack myZhuceModelCallBack) {

        MyApplication.api.postzhuce(zk,mima)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZhuceBean>() {
                    @Override
                    public void accept(ZhuceBean zhuceBean) throws Exception {
                        myZhuceModelCallBack.success(zhuceBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        myZhuceModelCallBack.failure(throwable.getMessage());
                    }
                });
    }
}
