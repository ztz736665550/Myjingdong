package com.example.ztz.myjingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.bean.ShouyeGridBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2017/12/8.
 */

public class shouyeviewpagergridadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ShouyeGridBean.DataBean> list;
    public shouyeviewpagergridadapter(Context context, List<ShouyeGridBean.DataBean> list) {
        this.context = context;
        this.list = list;
        //Log.i("-------", "addData: "+"进来了");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(context).inflate(R.layout.shouyeviewpagergrid, parent, false);
        //return new shouyeviewpagergrid(view);
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.i("-------", "addData: "+list.get(position).getName());
        ((shouyeviewpagergrid) holder).shouyeGridText.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class shouyeviewpagergrid extends RecyclerView.ViewHolder {
        @BindView(R.id.shouye_grid_simpleDrawee)
        SimpleDraweeView shouyeGridSimpleDrawee;
        @BindView(R.id.shouye_grid_text)
        TextView shouyeGridText;

        shouyeviewpagergrid(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
