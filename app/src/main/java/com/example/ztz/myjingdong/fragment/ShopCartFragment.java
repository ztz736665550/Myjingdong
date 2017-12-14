package com.example.ztz.myjingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.adapter.ShopAdapter;
import com.example.ztz.myjingdong.bean.ShopBean;
import com.example.ztz.myjingdong.presenter.ShopPresenter;
import com.example.ztz.myjingdong.view.ShopViewCallBack;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ztz on 2017/12/7.
 */

public class ShopCartFragment extends Fragment implements ShopViewCallBack {
    @BindView(R.id.third_recyclerview)
    RecyclerView thirdRecyclerview;
    @BindView(R.id.third_allselect)
    CheckBox thirdAllselect;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    @BindView(R.id.third_totalnum)
    TextView thirdTotalnum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    Unbinder unbinder;
    @BindView(R.id.shopcart_spring)
    SpringView shopcartSpring;
    private ShopPresenter presenter;
    private ShopAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragmentshopcart, null, false);
        unbinder = ButterKnife.bind(this, view);

        presenter = new ShopPresenter(this);
        presenter.getData();
        return view;
    }
    /*@Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden){
            //Fragment隐藏时调用

        }else {
            //Fragment显示时调用
            presenter.getData();
        }

    }*/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new ShopAdapter(getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        thirdRecyclerview.setLayoutManager(manager);
        thirdRecyclerview.setAdapter(adapter);

        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num, boolean allCheck) {
                thirdAllselect.setChecked(allCheck);
                thirdTotalnum.setText(num);
                thirdTotalprice.setText(total);
            }
        });
        /*shopcartSpring.setHeader(new DefaultHeader(getContext()));
        shopcartSpring.setFooter(new DefaultFooter(getContext()));
        shopcartSpring.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {


            }
            @Override
            public void onLoadmore() {
                shopcartSpring.onFinishFreshAndLoad();
            }
        });*/
    }

    @Override
    public void success(ShopBean bean) {
        //向适配器添加数据
        if (bean != null) {
            adapter.add(bean);
        }
    }

    @Override
    public void failure(Exception e) {
        //失败toast提示
        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @OnClick(R.id.third_allselect)
    public void onViewClicked() {
        adapter.selectAll(thirdAllselect.isChecked());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
