package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.AddShopCartBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/13.
 */

public class AddShopCartModel {
    public void addCart(String pid, final AddShopCartModelCallBack addShopCartModelCallBack) {
        MyApplication.api.addCart("111",pid,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddShopCartBean>() {
                    @Override
                    public void accept(AddShopCartBean addShopCartBean) throws Exception {
                        addShopCartModelCallBack.success(addShopCartBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        addShopCartModelCallBack.failed(throwable.getMessage());
                    }
                });
    }
}
