package com.example.ztz.myjingdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.bean.FenleiziBean;
import java.util.List;
import java.util.logging.Handler;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2017/12/8.
 */

public class FenleizigridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<FenleiziBean.DataBean.ListBean> list;

    public FenleizigridAdapter(Context context, List<FenleiziBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fenleigridadapter, null, false);
        return new gridviewholder(view);
}

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        gridviewholder holder1 = (gridviewholder) holder;
        holder1.gridTextName.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon()).placeholder(R.mipmap.ic_launcher).into(holder1.fenleiGridImg);
        //点击商品时跳转到详情页面
        holder1.gridTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pcid = list.get(position).getPcid()+"";
                Message message = new Message();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class gridviewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.fenlei_grid_img)
        ImageView fenleiGridImg;
        @BindView(R.id.grid_text_name)
        TextView gridTextName;

        gridviewholder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
