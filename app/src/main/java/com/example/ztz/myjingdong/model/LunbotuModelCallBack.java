package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.bean.LunBoTuBean;

/**
 * Created by ztz on 2017/12/7.
 */

public interface LunbotuModelCallBack {
    void Success(LunBoTuBean lunBoTuBean);
    void Failure(String e);
}
