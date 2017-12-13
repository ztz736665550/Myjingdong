package com.example.ztz.myjingdong.view;

import com.example.ztz.myjingdong.bean.LoginBean;

/**
 * Created by ztz on 2017/12/11.
 */

public interface MyLoginViewCallBack {
    void success(LoginBean loginBean);
    void failed(String e);
}
