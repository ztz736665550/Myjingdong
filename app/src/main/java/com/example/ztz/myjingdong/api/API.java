package com.example.ztz.myjingdong.api;

import com.example.ztz.myjingdong.bean.AddShopCartBean;
import com.example.ztz.myjingdong.bean.DeleteShopCart;
import com.example.ztz.myjingdong.bean.FenleileftBean;
import com.example.ztz.myjingdong.bean.FenleiziBean;
import com.example.ztz.myjingdong.bean.LoginBean;
import com.example.ztz.myjingdong.bean.LunBoTuBean;
import com.example.ztz.myjingdong.bean.ShouyeGoodsBean;
import com.example.ztz.myjingdong.bean.ShouyeGridBean;
import com.example.ztz.myjingdong.bean.ShouyeWebBean;
import com.example.ztz.myjingdong.bean.SouSuoBean;
import com.example.ztz.myjingdong.bean.ZhuceBean;


import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ztz on 2017/12/7.
 */

public interface API {
    /**
     * 首页轮播图
     * @return
     */
    @GET("ad/getAd")
    Observable<LunBoTuBean> getData();

    @GET("product/getCatagory")
    Observable<ShouyeGridBean> getBean();

    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611")
    Observable<ShouyeGoodsBean> getGoods(@Query("uri") String uri);

    @GET("product/getProductDetail")
    Observable<ShouyeWebBean> getWebBean(@Query("pid") String pid,@Query("source") String source);
    //pid=100&source=android

    @GET("product/getCatagory")
    Observable<FenleileftBean> getfenlei();

    @GET("product/getCarts")
    Observable<FenleiziBean> getcart(@Query("uid") String uid, @Query("source") String source);

    @GET("product/getProductCatagory")
    Call<FenleiziBean> getzifenlei(@Query("cid") String cid);


    /**
     * post请求用表单提交
     * @param zk
     * @param mima
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> post(@Field("mobile") String mobile,@Field("password") String password);

    @FormUrlEncoded
    @POST("user/reg")
    Observable<ZhuceBean> postzhuce(@Field("mobile") String mobile, @Field("password") String password);

    @GET("product/searchProducts")
    Observable<SouSuoBean> sousuo(@Query("keywords") String keywords,@Query("page") String page,@Query("source") String source);

    @GET("product/addCart")
    Observable<AddShopCartBean> addCart(@Query("uid") String uid,@Query("pid") String pid ,@Query("source") String source);

    @GET("product/deleteCart")
    Observable<DeleteShopCart> deletecart(@Query("uid") String uid,@Query("pid") String pid,@Query("source") String source);

}
