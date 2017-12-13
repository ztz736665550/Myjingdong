package com.example.ztz.myjingdong.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ztz.myjingdong.fragment.TabFragment;

/**
 * Created by ztz on 2017/12/12.
 */

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    private static final String[] mTitles =
            {"关注", "精选", "直播", "视频", "社区", "生活", "数码", "亲子", "风尚","美食"};
    public TabFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return TabFragment.newInstance(mTitles[position]);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}