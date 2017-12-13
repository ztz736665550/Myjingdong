package com.example.ztz.myjingdong.view;

import com.example.ztz.myjingdong.bean.ShopBean;
import com.example.ztz.myjingdong.bean.ZhuceBean;

/**
 * Created by ztz on 2017/12/11.
 */

public interface MyZhuceViewCallBack {
    void success(ZhuceBean zhuceBean);
    void failure(String e);
}
