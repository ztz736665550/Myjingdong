package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.bean.ShouyeGoodsBean;

/**
 * Created by ztz on 2017/12/9.
 */

public interface ShouyeGoodsModelCallBack {
    void successful(ShouyeGoodsBean shouyeGoodsBean);
    void failed(String e);
}
