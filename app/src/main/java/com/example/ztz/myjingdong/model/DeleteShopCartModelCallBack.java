package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.bean.DeleteShopCart;
import com.example.ztz.myjingdong.view.DeleteShopCartViewCall;

/**
 * Created by ztz on 2017/12/14.
 */

public interface DeleteShopCartModelCallBack {
    void success(DeleteShopCart deleteShopCart);
    void failed(String e);
}
