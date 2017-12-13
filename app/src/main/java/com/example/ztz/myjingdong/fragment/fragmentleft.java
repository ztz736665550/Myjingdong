package com.example.ztz.myjingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.adapter.shouyeviewpagergridadapter;
import com.example.ztz.myjingdong.bean.ShouyeGridBean;
import com.example.ztz.myjingdong.presenter.ShouyeGridPresenter;
import com.example.ztz.myjingdong.view.ShouyeGridViewCallBack;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ztz on 2017/12/8.
 */

public class fragmentleft extends Fragment implements ShouyeGridViewCallBack{
    //@BindView(R.id.shouye_recycler_viewpager_fragmentleft)
    //RecyclerView shouyeRecyclerViewpagerFragmentleft;
    Unbinder unbinder;
    //shouyeviewpagergridadapter shouyeviewpagergridadapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.leftfragmentgrid, null);
        unbinder = ButterKnife.bind(this, view);
        //ShouyeGridPresenter shouyeGridPresenter = new ShouyeGridPresenter(this);
        //shouyeGridPresenter.getData();

        //shouyeRecyclerViewpagerFragmentleft.setLayoutManager(new GridLayoutManager(getContext(),5));
        //shouyeRecyclerViewpagerFragmentleft.addItemDecoration(new DividerItemDecoration(getContext(),1));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 请求得到的数据
     * @param shouyeGridBean
     */
    @Override
    public void Success(ShouyeGridBean shouyeGridBean) {
        //Log.i("-----", "Success: "+shouyeGridBean.getData().get(0).getName());
        //if (shouyeGridBean != null) {
            //List<ShouyeGridBean.DataBean> list = shouyeGridBean.getData();
            //shouyeviewpagergridadapter.addData(list);
            //shouyeviewpagergridadapter = new shouyeviewpagergridadapter(getContext(),list);
            //shouyeRecyclerViewpagerFragmentleft.setAdapter(shouyeviewpagergridadapter);
        //}

    }

    @Override
    public void failure(String e) {

    }
}
