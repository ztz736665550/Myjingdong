package com.example.ztz.myjingdong.model;

import com.example.ztz.myjingdong.bean.LoginBean;

/**
 * Created by ztz on 2017/12/11.
 */

public interface MyLoginModelCallBack {
    void success(LoginBean loginBean);
    void failed(String e);
}
