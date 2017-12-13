package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.bean.ZhuceBean;

/**
 * Created by ztz on 2017/12/11.
 */

public interface MyZhuceModelCallBack {
    void success(ZhuceBean zhuceBean);
    void failure(String e);
}
