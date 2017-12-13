package com.example.ztz.myjingdong.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.adapter.ShouyesousuorecyclerAdapter;
import com.example.ztz.myjingdong.bean.SouSuoBean;
import com.example.ztz.myjingdong.presenter.SousuoPresenter;
import com.example.ztz.myjingdong.view.ShouyeSousuoViewCallBack;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SousuoActivity extends AppCompatActivity implements ShouyeSousuoViewCallBack {


    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.edit_text_sousuo)
    EditText editTextSousuo;
    @BindView(R.id.sousuo)
    ImageView sousuo;
    @BindView(R.id.shouye_recyclerview)
    RecyclerView shouyeRecyclerview;
    private SousuoPresenter sousuoPresenter;
    private ShouyesousuorecyclerAdapter shouyesousuorecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo);
        ButterKnife.bind(this);
        sousuoPresenter = new SousuoPresenter(this);
        shouyeRecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        shouyeRecyclerview.addItemDecoration(new DividerItemDecoration(this,1));

        /**
         * 点击搜索按钮开始搜索
         */
        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = editTextSousuo.getText().toString();
                sousuoPresenter.getData(string);
            }
        });
        /**
         * 点击返回结束当前页面
         */
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * 搜索成功返回的数据
     *
     * @param souSuoBean
     */
    @Override
    public void success(SouSuoBean souSuoBean) {
        Log.i("----", "success: " + souSuoBean.getMsg());
        List<SouSuoBean.DataBean> list = souSuoBean.getData();
        shouyesousuorecyclerAdapter = new ShouyesousuorecyclerAdapter(this, list);
        shouyeRecyclerview.setAdapter(shouyesousuorecyclerAdapter);
    }

    @Override
    public void Failed(String e) {

    }
}
