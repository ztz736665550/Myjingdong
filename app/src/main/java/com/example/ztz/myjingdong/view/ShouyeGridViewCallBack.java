package com.example.ztz.myjingdong.view;

import com.example.ztz.myjingdong.bean.ShouyeGridBean;

/**
 * Created by ztz on 2017/12/8.
 */

public interface ShouyeGridViewCallBack {
    void Success(ShouyeGridBean shouyeGridBean);
    void failure(String e);
}
