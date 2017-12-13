package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.SouSuoBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/12.
 */

public class SousuoModel {
    public void getData(String string, final SousuoModelCallBack sousuoModelCallBack) {
        MyApplication.api.sousuo(string,"1","android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SouSuoBean>() {
                    @Override
                    public void accept(SouSuoBean souSuoBean) throws Exception {
                        sousuoModelCallBack.success(souSuoBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        sousuoModelCallBack.Failed(throwable.getMessage());
                    }
                });
    }
}
