package com.example.ztz.myjingdong.presenter;


import com.example.ztz.myjingdong.bean.FenleiziBean;
import com.example.ztz.myjingdong.model.FenleiZiModel;
import com.example.ztz.myjingdong.model.FenleiziModelCallBack;
import com.example.ztz.myjingdong.view.FenleiviewziCallBack;

/**
 * Created by ztz on 2017/12/8.
 */

public class FenleiZiPresenter {

    private FenleiviewziCallBack fenleiviewziCallBack;
    private final FenleiZiModel fenleiZiModel;

    public FenleiZiPresenter(FenleiviewziCallBack fenleiviewziCallBack) {
        this.fenleiviewziCallBack = fenleiviewziCallBack;
        this.fenleiZiModel = new FenleiZiModel();
    }

    public void getZiData(String cid) {
        fenleiZiModel.getZiData(cid,new FenleiziModelCallBack() {
            @Override
            public void Successzi(FenleiziBean fenleiziBean) {
                fenleiviewziCallBack.Successzi(fenleiziBean);
            }

            @Override
            public void Failurezi(String e) {
                fenleiviewziCallBack.Failurezi(e);
            }
        });
    }
}
