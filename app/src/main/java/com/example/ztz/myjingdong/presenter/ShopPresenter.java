package com.example.ztz.myjingdong.presenter;

import com.example.ztz.myjingdong.bean.ShopBean;
import com.example.ztz.myjingdong.model.ShopModel;
import com.example.ztz.myjingdong.model.ShopModelCallBack;
import com.example.ztz.myjingdong.view.ShopViewCallBack;

/**
 * Created by ztz on 2017/12/11.
 */

public class ShopPresenter {
    private ShopViewCallBack listener;
    private ShopModel shopModel;
    public ShopPresenter(ShopViewCallBack listener){
        this.listener = listener ;
        this.shopModel = new ShopModel();
    }

    public void getData(){

        shopModel.getData(new ShopModelCallBack() {

            @Override
            public void success(ShopBean bean) {

                if(listener != null){
                    listener.success(bean);
                }
            }

            @Override
            public void failure(Exception e) {

                if(listener != null){
                    listener.failure(e);
                }
            }
        });
    }
    /**
     * 防止内存泄漏
     */
    public void detach(){
        listener = null;
    }

}
