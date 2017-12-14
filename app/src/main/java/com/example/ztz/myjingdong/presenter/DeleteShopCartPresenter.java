package com.example.ztz.myjingdong.presenter;

import android.content.Context;

import com.example.ztz.myjingdong.bean.DeleteShopCart;
import com.example.ztz.myjingdong.model.DeleteShopCartModel;
import com.example.ztz.myjingdong.model.DeleteShopCartModelCallBack;
import com.example.ztz.myjingdong.view.DeleteShopCartViewCall;

/**
 * Created by ztz on 2017/12/14.
 */

public class DeleteShopCartPresenter {
    private DeleteShopCartViewCall deleteShopCartViewCall;
    private final DeleteShopCartModel deleteShopCartModel;

    public DeleteShopCartPresenter( DeleteShopCartViewCall deleteShopCartViewCall) {
        this.deleteShopCartViewCall = deleteShopCartViewCall;
        this.deleteShopCartModel = new DeleteShopCartModel();
    }

    public void getData(String pid) {
        deleteShopCartModel.getData(pid,new DeleteShopCartModelCallBack() {
            @Override
            public void success(DeleteShopCart deleteShopCart) {
                deleteShopCartViewCall.success(deleteShopCart);
            }

            @Override
            public void failed(String e) {
                deleteShopCartViewCall.failed(e);
            }
        });
    }
}
