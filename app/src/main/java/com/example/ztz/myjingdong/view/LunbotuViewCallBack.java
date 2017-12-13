package com.example.ztz.myjingdong.view;

import com.example.ztz.myjingdong.bean.LunBoTuBean;

/**
 * Created by ztz on 2017/12/7.
 */

public interface LunbotuViewCallBack {
    void Success(LunBoTuBean lunBoTuBean);
    void Failure(String e);
}
