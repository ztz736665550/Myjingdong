package com.example.ztz.myjingdong.model;

import android.util.Log;

import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.FenleileftBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/8.
 */

public class FenleiModel {
    public void getData(final FenleiModelCallBack fenleiModelCallBack) {
        MyApplication.api.getfenlei()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FenleileftBean>() {
                    @Override
                    public void accept(FenleileftBean fenleileftBean) throws Exception {
                        Log.i("----", "accept: "+"请求成功");
                        fenleiModelCallBack.Success(fenleileftBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        fenleiModelCallBack.Failure(throwable.getMessage());
                    }
                });
    }
}
