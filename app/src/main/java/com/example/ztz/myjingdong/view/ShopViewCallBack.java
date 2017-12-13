package com.example.ztz.myjingdong.view;

import com.example.ztz.myjingdong.bean.ShopBean;

/**
 * Created by ztz on 2017/12/11.
 */

public interface ShopViewCallBack {
    void success(ShopBean bean);
    void failure(Exception e);
}
