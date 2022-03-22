package com.example.pets.ui.fragment;

import android.util.Log;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.model.domain.MainThemeThing;
import com.example.pets.presenter.Home_Theme_Presenter;
import com.example.pets.presenter.impl.HomePreImpl;
import com.example.pets.ui.adapter.homePagerAdapter;
import com.example.pets.view.HomeCallBack;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;


public class fragmentHome extends baseFragment implements HomeCallBack {

    private static final String TAG = "fragmentHome";
    private Home_Theme_Presenter mHomePreImpl;

    @BindView(R.id.tabLayoutHome)
    public TabLayout mTableLayout;

    @BindView(R.id.leaflet_home)
    public ViewPager homeLeaflet;

    private homePagerAdapter mHomePagerAdapters;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
       // Log.d(TAG,"fFHR here");
        //tab匹配ViewPager
        mTableLayout.setupWithViewPager(homeLeaflet);
        //适配器ViewPager
        mHomePagerAdapters = new homePagerAdapter(getChildFragmentManager());
        //适配器
        homeLeaflet.setAdapter(mHomePagerAdapters);
     }


    @Override
    protected void loadData() {

        //加载数据
        mHomePreImpl.getCategory();

    }

    @Override
    protected void initPresenter() {
        //加载presenter
        mHomePreImpl = new HomePreImpl();
        mHomePreImpl.registerViewCallBack(this);
    }

    @Override
    public void OnCategoryLoaded(MainThemeThing mainThemeThing) {
        setUpState(State.SUCCESS);
        //加载数据从这里进来
        if(mHomePagerAdapters!=null){
           // Log.d(TAG,"data here"+mainThemeThing);
            mHomePagerAdapters.setTitleData(mainThemeThing);
    }

}

    @Override
    protected void release() {
        //释放资源取消回调
        if(mHomePreImpl!=null)
            mHomePreImpl.unregisterViewCallBack(this);
    }

    @Override
    public void onNetworkError() {
        setUpState(State.ERROR);
    }

    @Override
    public void onLoading() {
        setUpState(State.LOADING);
    }

    @Override
    public void onEmpty() {
        setUpState(State.EMPTY);
    }

    @Override
    protected void onRetryClick() {
        //網絡錯誤點擊重試的具體事情
        //重新加載分類
        if (mHomePreImpl!=null) {
            mHomePreImpl.getCategory();
        }
    }
}
