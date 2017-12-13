package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.bean.ShouyeGridBean;

/**
 * Created by ztz on 2017/12/8.
 */

public interface ShouyeModelCallBack {
    void Success(ShouyeGridBean shouyeGridBean);
    void failure(String e);
}
