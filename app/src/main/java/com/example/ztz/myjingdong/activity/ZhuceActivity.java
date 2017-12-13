package com.example.ztz.myjingdong.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.bean.ZhuceBean;
import com.example.ztz.myjingdong.presenter.MyLoginPresenter;
import com.example.ztz.myjingdong.presenter.MyZhucePresenter;
import com.example.ztz.myjingdong.view.MyZhuceViewCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhuceActivity extends AppCompatActivity implements MyZhuceViewCallBack{

    @BindView(R.id.my_image_guanbi)
    ImageView myImageGuanbi;
    @BindView(R.id.my_zhuce_zk)
    EditText myZhuceZk;
    @BindView(R.id.my_zhuce_mima)
    EditText myZhuceMima;
    @BindView(R.id.my_btn_zhuce)
    Button myBtnZhuce;
    private MyZhucePresenter myZhucePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);
        myZhucePresenter = new MyZhucePresenter(this);
        myImageGuanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //结束页面
                finish();
            }
        });
        /**
         * 当点击登录按钮时,进行读取数据登录
         */
        myBtnZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String zk = myZhuceZk.getText().toString();
                String mima = myZhuceMima.getText().toString();
                myZhucePresenter.getData(zk, mima);
                Log.i("----login", "onClick: " + zk + "    " + mima);
            }
        });
    }

    /**
     * 注册返回的数据
     * @param zhuceBean
     */
    @Override
    public void success(ZhuceBean zhuceBean) {
        Toast.makeText(ZhuceActivity.this, zhuceBean.getMsg() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String e) {
        Toast.makeText(ZhuceActivity.this, e + "", Toast.LENGTH_SHORT).show();
    }
}
