package com.example.ztz.myjingdong.presenter;

import com.example.ztz.myjingdong.activity.AddShopCartWebActivity;
import com.example.ztz.myjingdong.bean.ShouyeWebBean;
import com.example.ztz.myjingdong.model.ShouyeaddShopWebModel;
import com.example.ztz.myjingdong.model.ShouyeaddcartWebModelCallBack;
import com.example.ztz.myjingdong.view.ShouyeaddcartwebViewCallBack;

/**
 * Created by ztz on 2017/12/9.
 */

public class ShouyeaddWebPresenter {
    private ShouyeaddcartwebViewCallBack shouyeaddcartwebViewCallBack;
    private final ShouyeaddShopWebModel shouyeaddShopWebModel;

    public ShouyeaddWebPresenter(ShouyeaddcartwebViewCallBack shouyeaddcartwebViewCallBack) {
        this.shouyeaddcartwebViewCallBack = shouyeaddcartwebViewCallBack;
        this.shouyeaddShopWebModel = new ShouyeaddShopWebModel();
    }

    public void getData(String id) {
        shouyeaddShopWebModel.getData(id,new ShouyeaddcartWebModelCallBack() {
            @Override
            public void success(ShouyeWebBean shouyeWebBean) {
                shouyeaddcartwebViewCallBack.success(shouyeWebBean);
            }

            @Override
            public void failure(String e) {
                shouyeaddcartwebViewCallBack.failure(e);
            }
        });
    }
    public void destroy() {
        shouyeaddcartwebViewCallBack = null;
    }
}
