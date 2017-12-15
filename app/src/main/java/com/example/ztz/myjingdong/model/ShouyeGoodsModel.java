package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.ShouyeGoodsBean;
import com.example.ztz.myjingdong.okhttp.AbstractUiCallBack;
import com.example.ztz.myjingdong.okhttp.OkhttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ztz on 2017/12/9.
 */

public class ShouyeGoodsModel {
    public void getData(final ShouyeGoodsModelCallBack shouyeGoodsModelCallBack) {
        MyApplication.apIgoods.getGoods("homepage")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShouyeGoodsBean>() {
                    @Override
                    public void accept(ShouyeGoodsBean shouyeGoodsBean) throws Exception {
                        shouyeGoodsModelCallBack.successful(shouyeGoodsBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        shouyeGoodsModelCallBack.failed(throwable.getMessage()+"");
                    }
                });
    }
}
