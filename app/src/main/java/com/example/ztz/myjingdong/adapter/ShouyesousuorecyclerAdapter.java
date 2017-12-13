package com.example.ztz.myjingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.bean.SouSuoBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2017/12/12.
 */

public class ShouyesousuorecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<SouSuoBean.DataBean> list;

    public ShouyesousuorecyclerAdapter(Context context, List<SouSuoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.shouyesousuorecyclerlayout, null);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewholder holder1 = (viewholder) holder;
        holder1.sousuoTextTitle.setText(list.get(position).getTitle());
        holder1.sousuoTextTime.setText(list.get(position).getCreatetime());

        String[] split = list.get(position).getImages().split("\\|");
        DraweeController controllerBuilder = Fresco.newDraweeControllerBuilder()
                .setUri(split[0])
                .build();
        holder1.sousuoSimpleDrawee.setController(controllerBuilder);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class viewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.sousuo_simpleDrawee)
        SimpleDraweeView sousuoSimpleDrawee;
        @BindView(R.id.sousuo_text_title)
        TextView sousuoTextTitle;
        @BindView(R.id.sousuo_text_time)
        TextView sousuoTextTime;

        viewholder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
