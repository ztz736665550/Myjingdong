package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.LoginBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/11.
 */

public class MyLoginModel {
    public void getLogin(String zk, String mima, final MyLoginModelCallBack myLoginModelCallBack) {
        MyApplication.api.post(zk,mima)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        myLoginModelCallBack.success(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        myLoginModelCallBack.failed(throwable.getMessage());
                    }
                });
    }
}
