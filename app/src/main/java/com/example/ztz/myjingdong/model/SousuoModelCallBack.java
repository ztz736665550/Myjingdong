package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.bean.SouSuoBean;

/**
 * Created by ztz on 2017/12/12.
 */

public interface SousuoModelCallBack {
    void success(SouSuoBean souSuoBean);
    void Failed(String e);
}
