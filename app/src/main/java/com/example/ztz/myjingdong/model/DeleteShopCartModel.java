package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.DeleteShopCart;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/14.
 */

public class DeleteShopCartModel {
    public void getData(String pid, final DeleteShopCartModelCallBack deleteShopCartModelCallBack) {
        MyApplication.api.deletecart("91",pid,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DeleteShopCart>() {
                    @Override
                    public void accept(DeleteShopCart deleteShopCart) throws Exception {
                        deleteShopCartModelCallBack.success(deleteShopCart);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        deleteShopCartModelCallBack.failed(throwable.getMessage());
                    }
                });
    }
}
