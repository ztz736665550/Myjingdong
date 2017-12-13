package com.example.ztz.myjingdong.presenter;

import android.content.Context;

import com.example.ztz.myjingdong.bean.ShouyeGridBean;
import com.example.ztz.myjingdong.model.ShouyeModel;
import com.example.ztz.myjingdong.model.ShouyeModelCallBack;
import com.example.ztz.myjingdong.view.ShouyeGridViewCallBack;

/**
 * Created by ztz on 2017/12/8.
 */

public class ShouyeGridPresenter {
    private ShouyeGridViewCallBack shouyeGridViewCallBack;
    private final ShouyeModel shouyeModel;
    private Object data;

    public ShouyeGridPresenter(ShouyeGridViewCallBack shouyeGridViewCallBack) {
        this.shouyeGridViewCallBack = shouyeGridViewCallBack;
        this.shouyeModel = new ShouyeModel();
    }

    public void getData() {
        shouyeModel.getData(new ShouyeModelCallBack() {
            @Override
            public void Success(ShouyeGridBean shouyeGridBean) {
                shouyeGridViewCallBack.Success(shouyeGridBean);
            }

            @Override
            public void failure(String e) {
                shouyeGridViewCallBack.failure(e);
            }
        });
    }
}
