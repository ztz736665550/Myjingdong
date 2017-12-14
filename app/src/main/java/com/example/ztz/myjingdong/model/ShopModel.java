package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.ShopBean;
import com.example.ztz.myjingdong.okhttp.AbstractUiCallBack;
import com.example.ztz.myjingdong.okhttp.OkhttpUtils;
import com.example.ztz.myjingdong.view.ShopViewCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/11.
 */

public class ShopModel {
    public void getData(final ShopModelCallBack shopModelCallBack){
        /*MyApplication.api.getcart("100","android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShopBean>() {
                    @Override
                    public void accept(ShopBean shopBean) throws Exception {
                        shopModelCallBack.success(shopBean);
                    }
                },new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        shopModelCallBack.failure(throwable.getMessage());
                    }
                });*/
        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCarts?uid=91", new AbstractUiCallBack<ShopBean>() {
            @Override
            public void success(ShopBean bean) {
                shopModelCallBack.success(bean);
            }

            @Override
            public void failure(Exception e) {

                shopModelCallBack.failure(e);
            }
        });
    }
}
