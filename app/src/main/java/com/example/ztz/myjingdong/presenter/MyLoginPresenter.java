package com.example.ztz.myjingdong.presenter;

import com.example.ztz.myjingdong.activity.LoginActivity;
import com.example.ztz.myjingdong.bean.LoginBean;
import com.example.ztz.myjingdong.model.MyLoginModel;
import com.example.ztz.myjingdong.model.MyLoginModelCallBack;
import com.example.ztz.myjingdong.view.MyLoginViewCallBack;

/**
 * Created by ztz on 2017/12/11.
 */

public class MyLoginPresenter {

    private MyLoginViewCallBack myLoginViewCallBack;
    private final MyLoginModel myLoginModel;

    public MyLoginPresenter(MyLoginViewCallBack myLoginViewCallBack) {
        this.myLoginViewCallBack = myLoginViewCallBack;
        this.myLoginModel = new MyLoginModel();
    }

    public void getData(String zk, String mima) {
        myLoginModel.getLogin(zk,mima,new MyLoginModelCallBack() {
            @Override
            public void success(LoginBean loginBean) {
                myLoginViewCallBack.success(loginBean);
            }

            @Override
            public void failed(String e) {
                myLoginViewCallBack.failed(e);
            }
        });
    }
}
