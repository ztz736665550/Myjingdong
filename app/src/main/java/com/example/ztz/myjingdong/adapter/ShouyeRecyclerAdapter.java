package com.example.ztz.myjingdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.activity.AddShopCartWebActivity;
import com.example.ztz.myjingdong.bean.LunBoTuBean;
import com.example.ztz.myjingdong.bean.ShouyeGoodsBean;
import com.example.ztz.myjingdong.fragment.fragmentleft;
import com.example.ztz.myjingdong.fragment.fragmentright;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2017/12/8.
 */

public class ShouyeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<String> images = new ArrayList<>();
    public static Context context;
    private FragmentManager supportFragmentManager;
    private List<LunBoTuBean.DataBean> data;
    private LunBoTuBean.TuijianBean tuijian;
    public ShouyeRecyclerAdapter(Context context, FragmentManager supportFragmentManager, List<LunBoTuBean.DataBean> data, LunBoTuBean.TuijianBean tuijian) {
        this.context = context;
        this.supportFragmentManager = supportFragmentManager;
        this.data = data;
        this.tuijian = tuijian;
        for (int i = 0; i < data.size(); i++) {
            images.add(data.get(i).getIcon());
        }
    }
    /**
     * 首页goods商品
     * @param subjects
     */
    private List<ShouyeGoodsBean.DataBean.SubjectsBean> subjects;
    public void addGoods(List<ShouyeGoodsBean.DataBean.SubjectsBean> subjects) {
        Log.i("----", "addGoods: "+"商品页面可显示");
        this.subjects = subjects;
        notifyDataSetChanged();
    }

    /*private List<LunBoTuBean.DataBean> data;
    private LunBoTuBean.TuijianBean tuijian;
    public void addData(List<LunBoTuBean.DataBean> data, LunBoTuBean.TuijianBean tuijian) {*//*
        //this.data = data;
       // this.tuijian = tuijian;
        for (int i = 0; i < data.size(); i++) {
            images.add(data.get(i).getIcon());
        }
        //notifyDataSetChanged();
   // }*/
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position >= 2) {
            return 2;
        }
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.shouyezibanner, parent, false);
            holder = new viewHolderBanner(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.shouyeviewpageradapter, parent, false);
            holder = new viewpagerviewholder(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.shouyegoodsadapter, parent, false);
            holder = new shouyegoodsviewholder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof viewHolderBanner) {
            ((viewHolderBanner) holder).banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).placeholder(R.mipmap.lunbotumoren).into(imageView);
                }
            });
            ((viewHolderBanner) holder).banner.setImages(images);
            //开始启动轮播
            ((viewHolderBanner) holder).banner.start();
        } else if (holder instanceof viewpagerviewholder) {
            //viewpager界面
            ArrayList<Fragment> fragments = new ArrayList<>();
            fragments.add(new fragmentleft());
            fragments.add(new fragmentright());
            ShouyeviewpagerAdapter shouyeviewpagerAdapter = new ShouyeviewpagerAdapter(supportFragmentManager, fragments);
            ((viewpagerviewholder) holder).shouyeViewpager.setAdapter(shouyeviewpagerAdapter);
        } else if (holder instanceof shouyegoodsviewholder) {
            DraweeController builder = Fresco.newDraweeControllerBuilder()
                    .setUri(subjects.get(position - 2).getDescImage())
                    .build();
            ((shouyegoodsviewholder) holder).shouyeGoodsSimpleDraweeview.setController(builder);
            ((shouyegoodsviewholder) holder).shouyeGoodsSimpleDraweeview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //跳转到详情页面
                    String id = subjects.get(position-2).getId();
                    if (id != null){
                        Intent intent = new Intent(context, AddShopCartWebActivity.class);
                        intent.putExtra("id",id);
                        context.startActivity(intent);
                    }else{
                        Toast.makeText(context,"pid为空",Toast.LENGTH_SHORT).show();
                    }

                }
            });
            ((shouyegoodsviewholder) holder).shouyeGoodsRecyclerview.setLayoutManager(new GridLayoutManager(context, 2));
            ((shouyegoodsviewholder) holder).shouyeGoodsRecyclerview.addItemDecoration(new DividerItemDecoration(context, 1));
            List<ShouyeGoodsBean.DataBean.SubjectsBean.GoodsListBeanX> goodsList = subjects.get(position - 2).getGoodsList();
            //让recyclerview失去焦点,因为它默认获取了焦点导致切换页面后自动聚焦
            ((shouyegoodsviewholder) holder).shouyeGoodsRecyclerview.setFocusable(false);
            ShouyegoodsrecyclerGrid shouyegoodsrecyclerGrid = new ShouyegoodsrecyclerGrid(context, goodsList,tuijian);
            ((shouyegoodsviewholder) holder).shouyeGoodsRecyclerview.setAdapter(shouyegoodsrecyclerGrid);
        }
    }

    /**
     * 返回条目的总数
     * @return
     */
    @Override
    public int getItemCount() {
        return subjects == null ? 0 : subjects.size() + 2;
    }

    static class viewHolderBanner extends RecyclerView.ViewHolder {
        @BindView(R.id.banner)
        Banner banner;

        viewHolderBanner(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public static class viewpagerviewholder extends RecyclerView.ViewHolder {

        @BindView(R.id.shouye_viewpager)
        ViewPager shouyeViewpager;

        viewpagerviewholder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ViewFlipper vf = view.findViewById(R.id.view_filpper);
            vf.addView(View.inflate(context,R.layout.item_paomadeng01,null));
            vf.addView(View.inflate(context,R.layout.item_paomadeng,null));
        }
    }

    static class shouyegoodsviewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.shouye_goods_simpleDraweeview)
        SimpleDraweeView shouyeGoodsSimpleDraweeview;
        @BindView(R.id.shouye_goods_recyclerview)
        RecyclerView shouyeGoodsRecyclerview;

        shouyegoodsviewholder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
