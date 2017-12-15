package com.example.ztz.myjingdong.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.adapter.FenleiRightAdapter;
import com.example.ztz.myjingdong.adapter.fenleiRecyclerviewLeftAdapter;
import com.example.ztz.myjingdong.bean.FenleileftBean;
import com.example.ztz.myjingdong.bean.FenleiziBean;
import com.example.ztz.myjingdong.presenter.FenleiPresenter;
import com.example.ztz.myjingdong.presenter.FenleiZiPresenter;
import com.example.ztz.myjingdong.view.FenleiviewCallBack;
import com.example.ztz.myjingdong.view.FenleiviewziCallBack;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ztz on 2017/12/7.
 */

public class FenleiFragment extends Fragment implements FenleiviewCallBack, FenleiviewziCallBack {

    Unbinder unbinder;
    @BindView(R.id.rwm_01)
    ImageView rwm01;
    @BindView(R.id.editText)
    LinearLayout editText;
    @BindView(R.id.xx)
    ImageView xx;
    @BindView(R.id.line)
    LinearLayout line;
    @BindView(R.id.fenlei_recyclerview_left)
    RecyclerView fenleiRecyclerviewLeft;
    @BindView(R.id.fenlei_recyclerview_right)
    RecyclerView fenleiRecyclerviewRight;
    private FenleiZiPresenter fenleiZiPresenter;
    private FenleiPresenter fenleiPresenter;
    @SuppressLint("HandlerLeak")

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmentfenlei, container, false);

        unbinder = ButterKnife.bind(this, view);
        fenleiRecyclerviewLeft.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        fenleiRecyclerviewLeft.addItemDecoration(new DividerItemDecoration(getContext(), 1));

        //recyclerview_right
        fenleiRecyclerviewRight.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        fenleiRecyclerviewRight.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fenleiPresenter = new FenleiPresenter(this);
        fenleiPresenter.getData();

        fenleiZiPresenter = new FenleiZiPresenter(this);
        fenleiZiPresenter.getZiData("1");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 分类列表
     * @param fenleileftBean
     */
    @Override
    public void Success(final FenleileftBean fenleileftBean) {
        List<FenleileftBean.DataBean> list = fenleileftBean.getData();
        fenleiRecyclerviewLeftAdapter fenleiRecyclerviewLeftAdapter = new fenleiRecyclerviewLeftAdapter(getContext(), list);
        fenleiRecyclerviewLeft.setAdapter(fenleiRecyclerviewLeftAdapter);
        fenleiRecyclerviewLeftAdapter.setItemOnClickListener(new fenleiRecyclerviewLeftAdapter.MyItemOnClickListener() {
            @Override
            public void onItemOnClick(View view, int postion) {
                fenleiZiPresenter.getZiData(fenleileftBean.getData().get(postion).getCid()+"");
            }
        });
    }

    @Override
    public void Failure(String e) {
    }

    /**
     * 分类grid
     */
    @Override
    public void Successzi(FenleiziBean fenleiziBean) {
        List<FenleiziBean.DataBean> data = fenleiziBean.getData();
        FenleiRightAdapter fenleiRightAdapter = new FenleiRightAdapter(getContext(),data);
        fenleiRecyclerviewRight.setAdapter(fenleiRightAdapter);
    }

    @Override
    public void Failurezi(String e) {
    }
}
