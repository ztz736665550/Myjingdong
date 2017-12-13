package com.example.ztz.myjingdong.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.activity.SousuoActivity;
import com.example.ztz.myjingdong.adapter.ShouyeRecyclerAdapter;
import com.example.ztz.myjingdong.bean.LunBoTuBean;
import com.example.ztz.myjingdong.bean.ShouyeGoodsBean;
import com.example.ztz.myjingdong.presenter.LunbotuPresenter;
import com.example.ztz.myjingdong.presenter.ShouyeGoodsPresenter;
import com.example.ztz.myjingdong.view.LunbotuViewCallBack;
import com.example.ztz.myjingdong.view.ShouyeGoodsViewCallback;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/**
 * Created by ztz on 2017/12/7.
 */

public class ShouyeFragment extends Fragment implements LunbotuViewCallBack, ShouyeGoodsViewCallback {
    @BindView(R.id.recyclerview_shouye)
    RecyclerView recyclerviewShouye;
    Unbinder unbinder;
    @BindView(R.id.rwm_01)
    ImageView rwm01;
    @BindView(R.id.editText)
    LinearLayout editText;
    @BindView(R.id.xx)
    ImageView xx;
    private ShouyeRecyclerAdapter shouyeRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragmentshouye, null, false);
        unbinder = ButterKnife.bind(this, view);
        LunbotuPresenter lunbotuPresenter = new LunbotuPresenter(this);
        lunbotuPresenter.getData();
        ShouyeGoodsPresenter shouyeGoodsPresenter = new ShouyeGoodsPresenter(this);
        shouyeGoodsPresenter.getGoods();
        recyclerviewShouye.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        shouyeRecyclerAdapter = new ShouyeRecyclerAdapter(getContext(), getChildFragmentManager());
        recyclerviewShouye.setAdapter(shouyeRecyclerAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /**
         * 点击进行搜索
         */
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),SousuoActivity.class));
            }
        });
        /**
         * 二维码扫描
         */
        rwm01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击扫一扫时,开始扫描二维码
                Intent intent = new Intent(getActivity(),CaptureActivity.class);
                startActivityForResult(intent,-1);
            }
        });
    }
    //二维码的回传值
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            Toast.makeText(getContext(),result.toString(),Toast.LENGTH_SHORT).show();
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(getContext(),"扫描出错",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 请求成功返回数据
     *
     * @param lunBoTuBean
     */
    @Override
    public void Success(LunBoTuBean lunBoTuBean) {
        if (lunBoTuBean != null) {
            List<LunBoTuBean.DataBean> data = lunBoTuBean.getData();
            LunBoTuBean.TuijianBean tuijian = lunBoTuBean.getTuijian();
            shouyeRecyclerAdapter.addData(data,tuijian);
        }
    }

    @Override
    public void Failure(String e) {
    }

    /**
     * 首页下方商品多条目
     *
     * @param shouyeGoodsBean
     */
    @Override
    public void successful(ShouyeGoodsBean shouyeGoodsBean) {
        List<ShouyeGoodsBean.DataBean.SubjectsBean> subjects = shouyeGoodsBean.getData().getSubjects();
        shouyeRecyclerAdapter.addGoods(subjects);
    }

    @Override
    public void failed(String e) {
    }
}
