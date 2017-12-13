package com.example.ztz.myjingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.application.MyApplication;
import com.example.ztz.myjingdong.bean.FenleileftBean;
import com.example.ztz.myjingdong.bean.FenleiziBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/9.
 */

public class fenleiRecyclerviewLeftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<FenleileftBean.DataBean> list;

    public fenleiRecyclerviewLeftAdapter(Context context, List<FenleileftBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    //对Activity暴露
    private MyItemOnClickListener listener;
    public void setItemOnClickListener(MyItemOnClickListener listener){
        this.listener=listener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        fenleileftviewholder fenleileftviewholder = new fenleileftviewholder(LayoutInflater.from(context).inflate(R.layout.fenleirecyclerleftadapter, parent, false),listener);
        return fenleileftviewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final fenleileftviewholder holder1 = (fenleileftviewholder) holder;
        holder1.textLeft.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class fenleileftviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.text_left)
        TextView textLeft;
        MyItemOnClickListener mListener;
        fenleileftviewholder(View view,MyItemOnClickListener myItemOnClickListener) {
            super(view);
            ButterKnife.bind(this, view);
            this.mListener=myItemOnClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mListener!=null){
                mListener.onItemOnClick(view,getPosition());
            }
        }
    }
    //定义接口
    public interface MyItemOnClickListener {
        void onItemOnClick(View view,int postion);
    }
}
