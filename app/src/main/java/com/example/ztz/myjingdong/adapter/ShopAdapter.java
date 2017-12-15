package com.example.ztz.myjingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ztz.myjingdong.R;
import com.example.ztz.myjingdong.bean.DeleteShopCart;
import com.example.ztz.myjingdong.bean.ShopBean;
import com.example.ztz.myjingdong.customview.PlusView;
import com.example.ztz.myjingdong.presenter.DeleteShopCartPresenter;
import com.example.ztz.myjingdong.view.DeleteShopCartViewCall;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2017/12/11.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.IViewHolder> implements DeleteShopCartViewCall{

    private Context context;
    private List<ShopBean.DataBean.ListBean> list;
    // 存放 商家的id 和 商家名称
    private Map<String,String> map = new HashMap<>();
    public ShopAdapter(Context context) {
        this.context = context;
    }
    /**
     * 添加数据 并更新显示
     * @param bean
     */
    public void add(ShopBean bean) {
    if (this.list == null) {
        this.list = new ArrayList<>();
    }
    // 遍历商家
    for (ShopBean.DataBean shop : bean.getData()) {
        map.put(shop.getSellerid(),shop.getSellerName());
        // 遍历商品
        for (int i = 0; i < shop.getList().size(); i++) {
            this.list.add(shop.getList().get(i));
        }
    }

    setFirst(this.list);
    notifyDataSetChanged();
}

    /**
     * 设置数据源， 控制显示商家
     * @param list
     */
    private void setFirst(List<ShopBean.DataBean.ListBean> list){

        if(list.size() > 0){
            list.get(0).setIsFirst(1);
            for(int i=1;i<list.size();i++){
                if(list.get(i).getSellerid() == list.get(i-1).getSellerid()){
                    list.get(i).setIsFirst(2);
                }else{
                    list.get(i).setIsFirst(1);
                }
            }
        }
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.shop_adapter_layout, null);
        //View view = LayoutInflater.from(context).inflate(R.layout.adapter_layout, null, false);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final IViewHolder holder, final int position) {

        // 显示商品图片
        if(list.get(position).getIsFirst() == 1){
            //显示商家
            holder.shop_checkbox.setVisibility(View.VISIBLE);
            holder.tvItemShopcartShopname.setVisibility(View.VISIBLE);
            holder.shop_checkbox.setChecked(list.get(position).isShopSelected());
            holder.tvItemShopcartShopname.setText(map.get(String.valueOf(list.get(position).getSellerid())));
        } else {
            holder.shop_checkbox.setVisibility(View.GONE);
            holder.tvItemShopcartShopname.setVisibility(View.GONE);
        }
        //控制 商品的  checkbox
        holder.item_checkbox.setChecked(list.get(position).isItemSelected());
        String[] url = list.get(position).getImages().split("\\|");
        //glid加载图片
        //Glide.with(context).load(url[0]).placeholder(R.mipmap.ic_launcher).into(holder.item_pic);
        GenericDraweeHierarchyBuilder builder =
                new GenericDraweeHierarchyBuilder(context.getResources());
        GenericDraweeHierarchy build = builder.setPlaceholderImage(R.mipmap.ic_launcher)
                .build();
        holder.item_pic.setHierarchy(build);
        DraweeController controllerBuilder = Fresco.newDraweeControllerBuilder()
                .setUri(url[0])
                .build();
        holder.item_pic.setController(controllerBuilder);

        holder.item_name.setText(list.get(position).getTitle());
        holder.item_price.setText("￥"+list.get(position).getPrice()+"元");
        holder.plusViewId.setEditText(list.get(position).getNum());
        // 商家的checkbox
        holder.shop_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                list.get(position).setShopSelected(holder.shop_checkbox.isChecked());

                for(int i=0;i<list.size();i++){
                    if(list.get(position).getSellerid() == list.get(i).getSellerid()){
                        list.get(i).setItemSelected(holder.shop_checkbox.isChecked());
                    }
                }

                notifyDataSetChanged();
                sum(list);

            }
        });

        // 商品的checkbox
        holder.item_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                list.get(position).setItemSelected(holder.item_checkbox.isChecked());

                for(int i=0;i<list.size();i++){
                    for (int j=0;j<list.size();j++){
                        if(list.get(i).getSellerid() == list.get(j).getSellerid() && !list.get(j).isItemSelected()){
                            list.get(i).setShopSelected(false);
                            break;
                        }else {
                            list.get(i).setShopSelected(true);
                        }
                    }
                }

                notifyDataSetChanged();
                sum(list);

            }
        });

        holder.item_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pid = list.get(position).getPid()+"";
                Log.i("----", "onClick: "+position+"");
                if (pid!= null){
                    DeleteShopCartPresenter deleteShopCartPresenter = new DeleteShopCartPresenter(ShopAdapter.this);
                    deleteShopCartPresenter.getData(pid);
                }
                list.remove(position);
                setFirst(list);
                notifyDataSetChanged();
                sum(list);

            }
        });

        //加减号
        holder.plusViewId.setListener(new PlusView.ClickListener() {
            @Override
            public void click(int count) {

                list.get(position).setNum(count);
                notifyDataSetChanged();
                sum(list);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    /**
     * 计算总价
     * @param list
     */
    private void sum(List<ShopBean.DataBean.ListBean> list){

        int totalNum = 0 ;
        float totalMoney =  0.0f;

        boolean allCheck =true;
        for(int i=0;i<list.size();i++){
            if(list.get(i).isItemSelected()){
                totalNum += list.get(i).getNum() ;
                totalMoney += list.get(i).getNum() * list.get(i).getPrice();
            }else {
                allCheck = false;
            }
        }

        listener.setTotal(totalMoney+"",totalNum+"",allCheck);
    }

    public void selectAll(boolean check){

        for(int i=0;i<list.size();i++){
            list.get(i).setShopSelected(check);
            list.get(i).setItemSelected(check);

        }
        notifyDataSetChanged();
        sum(list);

    }

    /**
     * 删除购物车的数据返回
     * @param deleteShopCart
     */
    @Override
    public void success(DeleteShopCart deleteShopCart) {
        Toast.makeText(context,deleteShopCart.getMsg().toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failed(String e) {
        Log.i("-------", "failed: "+e);
    }

    static class IViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.view)
        View view;
        @BindView(R.id.shop_checkbox)
        CheckBox shop_checkbox;
        @BindView(R.id.tv_item_shopcart_shopname)
        TextView tvItemShopcartShopname;
        @BindView(R.id.ll_shopcart_header)
        LinearLayout llShopcartHeader;
        @BindView(R.id.item_checkbox)
        CheckBox item_checkbox;
        @BindView(R.id.item_pic)
        SimpleDraweeView item_pic;
        @BindView(R.id.item_price)
        TextView item_price;
        @BindView(R.id.item_name)
        TextView item_name;
        @BindView(R.id.tv_item_shopcart_cloth_size)
        TextView tvItemShopcartClothSize;
        @BindView(R.id.plus_view_id)
        PlusView plusViewId;
        @BindView(R.id.item_del)
        ImageView item_del;

        IViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public UpdateUiListener listener;
    public void setListener(UpdateUiListener listener){
        this.listener = listener;
    }
    //接口必须是public
    public interface UpdateUiListener {
        public void setTotal(String total, String num, boolean allCheck);
    }

}
