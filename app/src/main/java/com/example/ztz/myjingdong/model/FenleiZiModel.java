package com.example.ztz.myjingdong.model;


import android.util.Log;

import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.FenleiziBean;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ztz on 2017/12/8.
 */

public class FenleiZiModel {

    public void getZiData(String cid, final FenleiziModelCallBack fenleiziModelCallBack) {
        MyApplication.api.getzifenlei(cid)
                .enqueue(new Callback<FenleiziBean>() {
                    @Override
                    public void onResponse(Call<FenleiziBean> call, Response<FenleiziBean> response) {
                        FenleiziBean body = response.body();
                        fenleiziModelCallBack.Successzi(body);
                    }

                    @Override
                    public void onFailure(Call<FenleiziBean> call, Throwable t) {
                        System.out.println("throwable = " + t.getMessage());
                    }
                });
                /*.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Consumer<FenleiziBean>() {
                    @Override
                    public void accept(FenleiziBean fenleiziBean) throws Exception {

                        fenleiziModelCallBack.Successzi(fenleiziBean);
                        Log.i("-----", "accept: "+"cid--打印");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("throwable = " + throwable);
                        fenleiziModelCallBack.Failurezi(throwable.getMessage());
                    }
                });*/

    }
}
