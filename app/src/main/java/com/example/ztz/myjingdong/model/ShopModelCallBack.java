package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.bean.ShopBean;

/**
 * Created by ztz on 2017/12/11.
 */

public interface ShopModelCallBack {
    void success(ShopBean bean);
    void failure(Exception e);
}
