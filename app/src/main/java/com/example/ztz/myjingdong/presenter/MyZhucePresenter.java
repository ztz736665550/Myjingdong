package com.example.ztz.myjingdong.presenter;

import com.example.ztz.myjingdong.activity.ZhuceActivity;
import com.example.ztz.myjingdong.bean.ZhuceBean;
import com.example.ztz.myjingdong.model.MyZhuceModel;
import com.example.ztz.myjingdong.model.MyZhuceModelCallBack;
import com.example.ztz.myjingdong.view.MyZhuceViewCallBack;

/**
 * Created by ztz on 2017/12/11.
 */

public class MyZhucePresenter {

    private MyZhuceViewCallBack myZhuceViewCallBack;
    private final MyZhuceModel myZhuceModel;

    public MyZhucePresenter(MyZhuceViewCallBack myZhuceViewCallBack) {
        this.myZhuceViewCallBack = myZhuceViewCallBack;
        this.myZhuceModel = new MyZhuceModel();
    }

    public void getData(String zk, String mima) {
        myZhuceModel.zhuce(zk,mima,new MyZhuceModelCallBack() {
            @Override
            public void success(ZhuceBean zhuceBean) {
                myZhuceViewCallBack.success(zhuceBean);
            }

            @Override
            public void failure(String e) {
                myZhuceViewCallBack.failure(e);
            }
        });
    }
}
