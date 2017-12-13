package com.example.ztz.myjingdong.view;

import com.example.ztz.myjingdong.bean.ShouyeGoodsBean;

/**
 * Created by ztz on 2017/12/9.
 */

public interface ShouyeGoodsViewCallback {
    void successful(ShouyeGoodsBean shouyeGoodsBean);
    void failed(String e);
}
