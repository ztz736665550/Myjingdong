package com.example.ztz.myjingdong.presenter;

import com.example.ztz.myjingdong.activity.SousuoActivity;
import com.example.ztz.myjingdong.bean.SouSuoBean;
import com.example.ztz.myjingdong.model.SousuoModel;
import com.example.ztz.myjingdong.model.SousuoModelCallBack;
import com.example.ztz.myjingdong.view.ShouyeSousuoViewCallBack;

/**
 * Created by ztz on 2017/12/12.
 */

public class SousuoPresenter {

    private ShouyeSousuoViewCallBack shouyeSousuoViewCallBack;
    private final SousuoModel sousuoModel;

    public SousuoPresenter(ShouyeSousuoViewCallBack shouyeSousuoViewCallBack) {
        this.shouyeSousuoViewCallBack = shouyeSousuoViewCallBack;
        this.sousuoModel = new SousuoModel();
    }

    public void getData(String string) {
        sousuoModel.getData(string,new SousuoModelCallBack() {
            @Override
            public void success(SouSuoBean souSuoBean) {
                shouyeSousuoViewCallBack.success(souSuoBean);
            }

            @Override
            public void Failed(String e) {
                shouyeSousuoViewCallBack.Failed(e);
            }
        });
    }
}
