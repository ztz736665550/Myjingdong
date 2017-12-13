package com.example.ztz.myjingdong.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.adapter.TabFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ztz on 2017/12/7.
 */

@SuppressLint("ValidFragment")
public class FaxianFragment extends Fragment {
    @BindView(R.id.tablayout_faxian)
    TabLayout tablayoutFaxian;
    @BindView(R.id.viewpager_faxian)
    ViewPager viewpagerFaxian;
    Unbinder unbinder;

    @SuppressLint("ValidFragment")
    private FragmentManager supportFragmentManager;
    public FaxianFragment() {
        this.supportFragmentManager = supportFragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragmentfaxian, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //关注精选直播视频社区生活数码亲子风尚美食
        tablayoutFaxian.addTab(tablayoutFaxian.newTab().setText("关注"));
        tablayoutFaxian.addTab(tablayoutFaxian.newTab().setText("精选"));
        tablayoutFaxian.addTab(tablayoutFaxian.newTab().setText("直播"));
        tablayoutFaxian.addTab(tablayoutFaxian.newTab().setText("视频"));
        tablayoutFaxian.addTab(tablayoutFaxian.newTab().setText("社区"));
        tablayoutFaxian.addTab(tablayoutFaxian.newTab().setText("生活"));
        tablayoutFaxian.addTab(tablayoutFaxian.newTab().setText("数码"));
        tablayoutFaxian.addTab(tablayoutFaxian.newTab().setText("亲子"));
        tablayoutFaxian.addTab(tablayoutFaxian.newTab().setText("风尚"));
        tablayoutFaxian.addTab(tablayoutFaxian.newTab().setText("美食"));

        //创建adapter的适配器
        TabFragmentPagerAdapter adapter = new TabFragmentPagerAdapter(getChildFragmentManager());
        viewpagerFaxian.setAdapter(adapter);
        tablayoutFaxian.setupWithViewPager(viewpagerFaxian);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
