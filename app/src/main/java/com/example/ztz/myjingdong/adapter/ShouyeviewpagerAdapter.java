package com.example.ztz.myjingdong.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ztz on 2017/12/8.
 */

public class ShouyeviewpagerAdapter extends FragmentPagerAdapter {

    private FragmentManager supportFragmentManager;
    private ArrayList<Fragment> fragments;
    public ShouyeviewpagerAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> fragments) {
        super(supportFragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
