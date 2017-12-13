package com.example.ztz.myjingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ztz.myjingdong.R;

/**
 * Created by ztz on 2017/12/12.
 */

public class TabFragment extends Fragment {

    public static final String PAGE_TITLE = "PAGE_TITLE";
    private String title;

    public static TabFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(PAGE_TITLE, title);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString(PAGE_TITLE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        TextView titleTv = (TextView) view.findViewById(R.id.title_tv);
        titleTv.setText(title);
        return view;
    }
}
