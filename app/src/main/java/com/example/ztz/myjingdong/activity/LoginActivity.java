package com.example.ztz.myjingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.bean.LoginBean;
import com.example.ztz.myjingdong.presenter.MyLoginPresenter;
import com.example.ztz.myjingdong.view.MyLoginViewCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements MyLoginViewCallBack {

    @BindView(R.id.my_image_guanbi)
    ImageView myImageGuanbi;
    @BindView(R.id.my_login_zk)
    EditText myLoginZk;
    @BindView(R.id.my_login_mima)
    EditText myLoginMima;
    @BindView(R.id.my_btn_login)
    Button myBtnLogin;
    @BindView(R.id.my_zhuce)
    TextView myZhuce;
    private MyLoginPresenter myLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        myLoginPresenter = new MyLoginPresenter(this);
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
        myBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String zk = myLoginZk.getText().toString();
                String mima = myLoginMima.getText().toString();
                myLoginPresenter.getData(zk, mima);
                Log.i("----login", "onClick: " + zk + "    " + mima);
            }
        });
        //注册
        myZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ZhuceActivity.class));
            }
        });
    }

    /**
     * 登陆成功的返回
     *
     * @param loginBean
     */
    @Override
    public void success(LoginBean loginBean) {
        Toast.makeText(LoginActivity.this, loginBean.getMsg() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failed(String e) {
        Toast.makeText(LoginActivity.this, e + "", Toast.LENGTH_SHORT).show();
    }
}
