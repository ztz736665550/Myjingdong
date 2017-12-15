package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.LunBoTuBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/7.
 */

public class LunbotuModel {
    public void getData(final LunbotuModelCallBack lunbotuModelCallBack) {
        MyApplication.api.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LunBoTuBean>() {
                    @Override
                    public void accept(LunBoTuBean lunBoTuBean) throws Exception {
                        lunbotuModelCallBack.Success(lunBoTuBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        lunbotuModelCallBack.Failure(throwable.getMessage());
                    }
                });
    }
}
