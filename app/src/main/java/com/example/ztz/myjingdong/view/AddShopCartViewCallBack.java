package com.example.ztz.myjingdong.view;

import com.example.ztz.myjingdong.bean.AddShopCartBean;

/**
 * Created by ztz on 2017/12/13.
 */

public interface AddShopCartViewCallBack {
    void success(AddShopCartBean addShopCartBean);
    void failed(String e);
}
