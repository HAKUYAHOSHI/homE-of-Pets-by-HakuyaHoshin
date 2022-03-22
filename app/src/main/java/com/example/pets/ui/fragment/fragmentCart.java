package com.example.pets.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.model.domain.MainThemeThing;
import com.example.pets.model.domain.demoGoods;
import com.example.pets.ui.activity.CartRecommendActivity;
import com.example.pets.ui.adapter.CartAdapter;
import com.example.pets.ui.adapter.HomeRecAdapter;
import com.example.pets.utils.constant;
import com.example.pets.utils.demoGoodsUtils;
import com.example.pets.view.Cart_list_Callback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class fragmentCart extends baseFragment implements CartAdapter.OnListItemClickListener, Cart_list_Callback {
    private static final String TAG = "fragmentCart";
    List<demoGoods.Databean.DataHK> list1 = new ArrayList<>();

    @BindView(R.id.cart_recyclerView)
    RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private com.example.pets.utils.demoGoodsUtils demoGoodsUtils;

    public static fragmentCart newInstance(demoGoods.Databean.DataHK cate){
        //給定一個單例的作用：在創建對象的時候順便就給設置了參數，裏面可以使用，
        fragmentCart fFHR = new fragmentCart();
        return fFHR;

    }


    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_cart;
    }

    @Override
    protected void initView(View view) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setReverseLayout(false);
        recyclerView.setLayoutManager(layoutManager);

        cartAdapter = new CartAdapter();
        recyclerView.setAdapter(cartAdapter);
    }

    @Override
    protected void loadData() {
        if (demoGoodsUtils!=null) {
        demoGoodsUtils.addItem();
        }
    }

    @Override
    protected void initListener() {
        cartAdapter.setONItemClickListener(this);
    }

    protected void initPresenter() {
        demoGoodsUtils = new demoGoodsUtils();
        demoGoodsUtils.registerViewCallBack(this);

    }


    @Override
    public void onItemClick(int j) {
        Intent intent = new Intent(getContext(), CartRecommendActivity.class);
        intent.putExtra("imageUri",list1.get(j).getPicurl());
        intent.putExtra("textmain",list1.get(j).getGoods_name());
        intent.putExtra("price",list1.get(j).getPrice());
        intent.putExtra("coupon",list1.get(j).getDiscount());
        intent.putExtra("shopName",list1.get(j).getShopname());
        intent.putExtra("sales",list1.get(j).getSales());

        startActivity(intent);


    }

    @Override
    public void onContentCartLoaded(List<demoGoods.Databean.DataHK> list) {
        list1.clear();
        list1.addAll(list);
        cartAdapter.addData(list);
        setUpState(State.SUCCESS);
    }

    @Override
    protected void release() {
        if (demoGoodsUtils!=null) {
        demoGoodsUtils.unregisterViewCallBack(this);
        }
    }

    @Override
    public void onEmpty() {
        setUpState(State.EMPTY);
    }
    @Override
    public void onLoading() {

        setUpState(State.LOADING);
    }

    @Override
    public void onNetworkError() {

        //网络错误！
        setUpState(State.ERROR);
    }
}