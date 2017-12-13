package com.example.ztz.myjingdong.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.bean.AddShopCartBean;
import com.example.ztz.myjingdong.bean.ShouyeWebBean;
import com.example.ztz.myjingdong.presenter.AddShopCartPresenter;
import com.example.ztz.myjingdong.presenter.ShouyeaddWebPresenter;
import com.example.ztz.myjingdong.view.AddShopCartViewCallBack;
import com.example.ztz.myjingdong.view.ShouyeaddcartwebViewCallBack;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddShopCartWebActivity extends AppCompatActivity implements ShouyeaddcartwebViewCallBack , AddShopCartViewCallBack {


    @BindView(R.id.Shouye_xiangqing_simpleDeawee)
    SimpleDraweeView ShouyeXiangqingSimpleDeawee;
    @BindView(R.id.shouye_xq_text_title)
    TextView shouyeXqTextTitle;
    @BindView(R.id.shouye_xq_text_name)
    TextView shouyeXqTextName;
    @BindView(R.id.shouye_xq_addcart)
    TextView shouyeXqAddcart;
    @BindView(R.id.shouye_xq_text_price)
    TextView shouyeXqTextPrice;
    private ShouyeaddWebPresenter shouyeaddWebPresenter;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                ShouyeWebBean bean = (ShouyeWebBean) msg.obj;
                String[] split = bean.getData().getImages().split("\\|");
                ShouyeXiangqingSimpleDeawee.setImageURI(split[0]);
                shouyeXqTextTitle.setText(bean.getData().getTitle());
                shouyeXqTextName.setText(bean.getData().getSubhead());
                shouyeXqTextPrice.setText("¥："+bean.getData().getPrice()+"");

            }
        }
    };
    private AddShopCartPresenter addShopCartPresenter;
    private String pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shop_cart_web);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        //商品详情
        shouyeaddWebPresenter = new ShouyeaddWebPresenter(this);
        shouyeaddWebPresenter.getData(id);
        //点击添加购物车按钮添加到购物车
        shouyeXqAddcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(AddShopCartWebActivity.this,"成功加入购物车",Toast.LENGTH_SHORT).show();
                //添加到购物车
                addShopCartPresenter = new AddShopCartPresenter(AddShopCartWebActivity.this);
                //传过去商品的pid
                //Log.i("----", "onClick: "+pid);
                addShopCartPresenter.addCart(pid);
            }
        });
    }

    /**
     * 首页详情的数据
     * @param shouyeWebBean
     */
    @Override
    public void success(ShouyeWebBean shouyeWebBean) {
        pid = shouyeWebBean.getData().getPid()+"";
        ShouyeWebBean.DataBean list = shouyeWebBean.getData();
        Message message = new Message();
        message.what = 0;
        message.obj = shouyeWebBean;
        handler.sendMessage(message);
    }

    @Override
    public void failure(String e) {
    }

    /**
     * 添加购物车返回的数据
     * @param addShopCartBean
     */
    @Override
    public void success(AddShopCartBean addShopCartBean) {
        Toast.makeText(AddShopCartWebActivity.this,addShopCartBean.getMsg(),Toast.LENGTH_SHORT).show();
    }
    @Override
    public void failed(String e) {
        Toast.makeText(AddShopCartWebActivity.this,e.toString()+"错",Toast.LENGTH_SHORT).show();
    }
}
