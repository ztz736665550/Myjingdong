package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.bean.ShouyeWebBean;

/**
 * Created by ztz on 2017/12/9.
 */

public interface ShouyeaddcartWebModelCallBack {
    void success(ShouyeWebBean shouyeWebBean);
    void failure(String e);
}
