package com.example.ztz.myjingdong.presenter;

import com.example.ztz.myjingdong.activity.AddShopCartWebActivity;
import com.example.ztz.myjingdong.bean.AddShopCartBean;
import com.example.ztz.myjingdong.model.AddShopCartModel;
import com.example.ztz.myjingdong.model.AddShopCartModelCallBack;
import com.example.ztz.myjingdong.view.AddShopCartViewCallBack;

/**
 * Created by ztz on 2017/12/13.
 */

public class AddShopCartPresenter {
    private AddShopCartViewCallBack addShopCartViewCallBack;
    private final AddShopCartModel addShopCartModel;

    public AddShopCartPresenter(AddShopCartViewCallBack addShopCartViewCallBack) {
        this.addShopCartViewCallBack = addShopCartViewCallBack;
        this.addShopCartModel = new AddShopCartModel();
    }

    public void addCart(String pid) {
        addShopCartModel.addCart(pid,new AddShopCartModelCallBack() {
            @Override
            public void success(AddShopCartBean addShopCartBean) {
                addShopCartViewCallBack.success(addShopCartBean);
            }

            @Override
            public void failed(String e) {
                addShopCartViewCallBack.failed(e);
            }
        });
    }
}
