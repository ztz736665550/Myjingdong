package com.example.ztz.myjingdong.adapter;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.bean.FenleiziBean;
import com.example.ztz.myjingdong.fragment.FenleiFragment;

import java.sql.DatabaseMetaData;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2017/12/11.
 */

public class FenleiRightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<FenleiziBean.DataBean> data;
    public FenleiRightAdapter(Context context,List<FenleiziBean.DataBean> data) {
        this.context = context;
        this.data = data;
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fenleirecyclerziadapter, null);
        return new viewholderfenleiright(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewholderfenleiright holder1 = (viewholderfenleiright) holder;
        holder1.fenleiTextTitle.setText(data.get(position).getName());

        List<FenleiziBean.DataBean.ListBean> listgrid = data.get(position).getList();
        holder1.recyclerGrid.setLayoutManager(new GridLayoutManager(context,3));
        holder1.recyclerGrid.addItemDecoration(new DividerItemDecoration(context,1));
        FenleizigridAdapter fenleizigridAdapter = new FenleizigridAdapter(context, listgrid);
        holder1.recyclerGrid.setAdapter(fenleizigridAdapter);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class viewholderfenleiright extends RecyclerView.ViewHolder{
        @BindView(R.id.fenlei_text_title)
        TextView fenleiTextTitle;
        @BindView(R.id.recycler_grid)
        RecyclerView recyclerGrid;

        viewholderfenleiright(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
