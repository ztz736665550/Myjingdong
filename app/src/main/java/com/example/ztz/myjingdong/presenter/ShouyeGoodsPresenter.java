package com.example.ztz.myjingdong.presenter;

import com.example.ztz.myjingdong.bean.ShouyeGoodsBean;
import com.example.ztz.myjingdong.fragment.ShouyeFragment;
import com.example.ztz.myjingdong.model.ShouyeGoodsModel;
import com.example.ztz.myjingdong.model.ShouyeGoodsModelCallBack;
import com.example.ztz.myjingdong.view.ShouyeGoodsViewCallback;

/**
 * Created by ztz on 2017/12/9.
 */

public class ShouyeGoodsPresenter {
    private ShouyeGoodsViewCallback shouyeGoodsViewCallback;
    private final ShouyeGoodsModel shouyeGoodsModel;

    public ShouyeGoodsPresenter(ShouyeGoodsViewCallback shouyeGoodsViewCallback) {
        this.shouyeGoodsViewCallback = shouyeGoodsViewCallback;
        this.shouyeGoodsModel = new ShouyeGoodsModel();
    }

    public void getGoods() {
        shouyeGoodsModel.getData(new ShouyeGoodsModelCallBack() {
            @Override
            public void successful(ShouyeGoodsBean shouyeGoodsBean) {
                shouyeGoodsViewCallback.successful(shouyeGoodsBean);
            }

            @Override
            public void failed(String e) {
                shouyeGoodsViewCallback.failed(e);
            }
        });
    }
}
