package com.example.kingwen.quickbox.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.kingwen.quickbox.Adapters.ShopAdapter;
import com.example.kingwen.quickbox.Beans.Shop;
import com.example.kingwen.quickbox.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingwen on 2016/12/12.
 */
public class ShoppingFragment extends Fragment {

    private List<Shop>  shopList;

    private ShopAdapter shopAdapter;
    
    private RecyclerView shopRecyvleview;

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDatas();
        
        mContext=getActivity();

    }


    private void initDatas() {

        shopList=new ArrayList<Shop>() {
            {
                add(new Shop("START",R.drawable.java));
                add(new Shop("创意直通车",R.drawable.java));
                add(new Shop("筱熙文学院",R.drawable.java));
                add(new Shop("带你看历史",R.drawable.java));
                add(new Shop("Geek俱乐部",R.drawable.java));
                add(new Shop("Company Name",R.drawable.java));
            }
        };
        
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view =inflater.inflate(R.layout.fragment_shopping,container,false);

        shopRecyvleview= (RecyclerView) view.findViewById(R.id.recycleview_shopping);

        GridLayoutManager manager=new GridLayoutManager(mContext,2);
        shopRecyvleview.setLayoutManager(manager);

        shopAdapter=new ShopAdapter(shopList);

        shopRecyvleview.setAdapter(shopAdapter);

        return view;
    }




}
