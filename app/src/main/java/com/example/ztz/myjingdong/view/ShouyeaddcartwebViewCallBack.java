package com.example.ztz.myjingdong.view;

import com.example.ztz.myjingdong.bean.ShouyeWebBean;

/**
 * Created by ztz on 2017/12/9.
 */

public interface ShouyeaddcartwebViewCallBack {
    void success(ShouyeWebBean shouyeWebBean);
    void failure(String e);
}
