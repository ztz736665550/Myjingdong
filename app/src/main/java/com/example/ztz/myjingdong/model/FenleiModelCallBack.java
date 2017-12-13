package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.bean.FenleileftBean;

/**
 * Created by ztz on 2017/12/8.
 */

public interface FenleiModelCallBack {
    void Success(FenleileftBean fenleileftBean);
    void Failure(String e);

}
