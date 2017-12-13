package com.example.ztz.myjingdong.presenter;

import android.content.Context;

import com.example.ztz.myjingdong.bean.LunBoTuBean;
import com.example.ztz.myjingdong.model.LunbotuModel;
import com.example.ztz.myjingdong.model.LunbotuModelCallBack;
import com.example.ztz.myjingdong.view.LunbotuViewCallBack;

/**
 * Created by ztz on 2017/12/7.
 */

public class LunbotuPresenter {

    private LunbotuViewCallBack lunbotuViewCallBack;
    private final LunbotuModel lunbotuModel;

    public LunbotuPresenter(LunbotuViewCallBack lunbotuViewCallBack) {
        this.lunbotuViewCallBack = lunbotuViewCallBack;
        this.lunbotuModel = new LunbotuModel();
    }

    public void getData() {
        lunbotuModel.getData(new LunbotuModelCallBack() {
            @Override
            public void Success(LunBoTuBean lunBoTuBean) {
                lunbotuViewCallBack.Success(lunBoTuBean);
            }

            @Override
            public void Failure(String e) {
                lunbotuViewCallBack.Failure(e);
            }
        });
    }
}
