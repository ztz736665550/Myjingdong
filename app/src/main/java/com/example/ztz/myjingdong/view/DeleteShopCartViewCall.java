package com.example.ztz.myjingdong.view;

import com.example.ztz.myjingdong.bean.DeleteShopCart;

/**
 * Created by ztz on 2017/12/14.
 */

public interface DeleteShopCartViewCall {
    void success(DeleteShopCart deleteShopCart);
    void failed(String e);
}
