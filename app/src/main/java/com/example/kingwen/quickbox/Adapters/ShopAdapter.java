package com.example.kingwen.quickbox.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kingwen.quickbox.Beans.Shop;
import com.example.kingwen.quickbox.R;

import java.util.List;

/**
 * Created by kingwen on 2016/12/12.
 */
public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    /**
     * TAG
     */
    private static final String TAG="shopAdapter";

    /**
     * 上下文对象
     */
    private Context mContext;

    /**
     * 商店列表
     */
    private List<Shop> shopList;


    /**
     * ShopAdapter构造方法
     * @param shopList 保存有shopAdapter的构造方法
     */
    public ShopAdapter(List<Shop> shopList) {
        this.shopList = shopList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_shop,null,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Shop shop=shopList.get(position);

        holder.shopName.setText(shop.getName());
        Glide.with(mContext).load(shop.getImgid()).into(holder.shopImage);

    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount: shopList,size"+shopList.size() );
        return shopList.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;

        ImageView shopImage;

        TextView shopName;

        public ViewHolder(View itemView) {

            super(itemView);
//            cardView= (CardView) itemView;
            shopImage= (ImageView) itemView.findViewById(R.id.iv_item_shop);
            shopName= (TextView) itemView.findViewById(R.id.tv_item_shop);

        }
    }
}
