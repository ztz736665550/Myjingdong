package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.bean.AddShopCartBean;

/**
 * Created by ztz on 2017/12/13.
 */

public interface AddShopCartModelCallBack {
    void success(AddShopCartBean addShopCartBean);
    void failed(String e);
}
