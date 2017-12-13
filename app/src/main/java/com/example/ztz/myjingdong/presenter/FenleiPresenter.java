package com.example.ztz.myjingdong.presenter;

import com.example.ztz.myjingdong.bean.FenleileftBean;
import com.example.ztz.myjingdong.model.FenleiModel;
import com.example.ztz.myjingdong.model.FenleiModelCallBack;
import com.example.ztz.myjingdong.view.FenleiviewCallBack;

/**
 * Created by ztz on 2017/12/8.
 */

public class FenleiPresenter {

    private FenleiviewCallBack fenleiviewCallBack;
    private final FenleiModel fenleiModel;

    public FenleiPresenter(FenleiviewCallBack fenleiviewCallBack) {
        this.fenleiviewCallBack = fenleiviewCallBack;
        this.fenleiModel = new FenleiModel();
    }

    public void getData() {
        fenleiModel.getData(new FenleiModelCallBack() {
            @Override
            public void Success(FenleileftBean fenleileftBean) {
                fenleiviewCallBack.Success(fenleileftBean);
            }

            @Override
            public void Failure(String e) {
                fenleiviewCallBack.Failure(e);
            }
        });
    }

}
