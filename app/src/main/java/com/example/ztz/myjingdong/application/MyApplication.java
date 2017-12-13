package com.example.ztz.myjingdong.application;

import android.app.Application;

import com.example.ztz.myjingdong.api.API;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ztz on 2017/12/7.
 */

public class MyApplication extends Application {

    public static API api;
    public static API apIgoods;

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 轮播图请求
         */
        Retrofit builder = new Retrofit.Builder()

                .baseUrl("https://www.zhaoapi.cn/")

                .addConverterFactory(GsonConverterFactory.create())

                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = builder.create(API.class);

        /**
         * 首页多条目
         */
        Retrofit builder1 = new Retrofit.Builder()
                .baseUrl("http://result.eolinker.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apIgoods = builder1.create(API.class);

        /**
         * fresco图片加载器初始化
         */
        Fresco.initialize(this);
    }
}
