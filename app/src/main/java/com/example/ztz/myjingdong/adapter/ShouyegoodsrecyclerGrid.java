package com.example.ztz.myjingdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.activity.AddShopCartWebActivity;
import com.example.ztz.myjingdong.bean.LunBoTuBean;
import com.example.ztz.myjingdong.bean.ShouyeGoodsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2017/12/9.
 */

public class ShouyegoodsrecyclerGrid extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ShouyeGoodsBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList;
    private LunBoTuBean.TuijianBean tuijian;
    public ShouyegoodsrecyclerGrid(Context context, List<ShouyeGoodsBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList, LunBoTuBean.TuijianBean tuijian) {
        this.context = context;
        this.goodsList = goodsList;
        this.tuijian = tuijian;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shouyegoodsrecygridlayout, parent, false);
        return new shouyegoodsgridviewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        shouyegoodsgridviewHolder holder1 = (shouyegoodsgridviewHolder) holder;
        holder1.shouyeGoodsGridSimpleDrawee.setImageURI(goodsList.get(position).getGoodsImage());
        holder1.shouyeGoodsGridTextName.setText(goodsList.get(position).getGoods_name());
        holder1.shouyeGoodsGridTextTitle.setText(goodsList.get(position).getGoodsName());
        holder1.shouyeGoodsGridSimpleDrawee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到详情页面
                String pid = tuijian.getList().get(position).getPid()+"";
                if(pid != null){
                    Intent intent = new Intent(context, AddShopCartWebActivity.class);
                    intent.putExtra("id",pid);
                    context.startActivity(intent);
                }else{
                    Toast.makeText(context,"Goodspid为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return goodsList == null ? 0 : goodsList.size();
    }

    static class shouyegoodsgridviewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.shouye_goods_grid_text_name)
        TextView shouyeGoodsGridTextName;
        @BindView(R.id.shouye_goods_grid_simpleDrawee)
        SimpleDraweeView shouyeGoodsGridSimpleDrawee;
        @BindView(R.id.shouye_goods_grid_text_title)
        TextView shouyeGoodsGridTextTitle;

        shouyegoodsgridviewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
