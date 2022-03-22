package com.example.pets.ui.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.model.domain.HomeDifferentThemeThing;
import com.example.pets.model.domain.MainThemeThing;
import com.example.pets.presenter.Home_Different_theme_Presenter;
import com.example.pets.presenter.impl.homePreDiffThemeImpl;
import com.example.pets.ui.activity.HomeRecommendActivity;
import com.example.pets.ui.adapter.HomeRecAdapter;
import com.example.pets.ui.adapter.HomeRecSwiperAdapter;
import com.example.pets.utils.ToastUtils;
import com.example.pets.utils.constant;
import com.example.pets.view.HomeDifferentThemeCallBack;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.bezierlayout.BezierLayout;

import java.util.List;

import butterknife.BindView;

public class fragmentForHomeRec extends baseFragment implements HomeDifferentThemeCallBack, HomeRecAdapter.OnListItemClickListener {


    private static final String TAG = "fragmentForHomeRec";
    private Home_Different_theme_Presenter mhdtPresenter;
    private int id;

    //分页面的内容
    @BindView(R.id.home_pager_recommend)
    public RecyclerView mContent_Home;

    @BindView(R.id.home_pager_swiper)
    public ViewPager mSwiper_home;

    @BindView(R.id.home_pager_refresh)
    public TwinklingRefreshLayout mRefresh_home;

    @BindView(R.id.home_page_container)
    public LinearLayout homePageContainer1;

    private HomeRecAdapter mhomeRecAdapter;
    private HomeRecSwiperAdapter mhomeRecSwiperAdapter;  //实例化的Adapter对象设置了参数等等，被加入ViewPager对象中


    public static fragmentForHomeRec newInstance(MainThemeThing.DataBean cate){
        //給定一個單例的作用：在創建對象的時候順便就給設置了參數，裏面可以使用，
        fragmentForHomeRec fFHR = new fragmentForHomeRec();

        Bundle bundle = new Bundle();
        bundle.putString(constant.HOMEPAGE_KEY_THEME,cate.getTitle());//需绑定参数！根据你传入的HomeDifferentThemeThing.DataBean类型的对象决定你的绑定参数！
        bundle.putInt(constant.HOMEPAGE_KEY_ID,cate.getId());
        fFHR.setArguments(bundle);
        return fFHR;

    }

    @Override
    protected void initView(View view) {
        Log.d(TAG,"fFHR here");
        //兩件事：綁定下邊的瀑布流和上邊的swiper
        //準備佈局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setReverseLayout(false);
        Log.d(TAG,"here1-----------------------------------");
        //给组件設置佈局管理器
        mContent_Home.setLayoutManager(layoutManager);
        Log.d(TAG,"here2-----------------------------------");
        //創建適配器
        mhomeRecAdapter = new HomeRecAdapter(); //Adapter告诉你应该怎么管理数据，单并不直接接收数据。
        Log.d(TAG,"here3-----------------------------------");
        //設置適配器
        mContent_Home.setAdapter(mhomeRecAdapter);
        Log.d(TAG,"here4-----------------------------------");

        //轮播图适配器创建
        mhomeRecSwiperAdapter = new HomeRecSwiperAdapter();
        //给轮播图组件设置适配器
         mSwiper_home.setAdapter(mhomeRecSwiperAdapter);

         //设置Refresh的相关内容
        mRefresh_home.setEnableRefresh(false);
        mRefresh_home.setEnableLoadmore(true);
        //TwinkingRefreshLayout
        BezierLayout bezierLayout = new BezierLayout(getContext());
        bezierLayout.setWaveColor(255);
//        mRefresh_home.setHeaderView(bezierLayout);
    }


    @Override
    protected void initListener() {
        mhomeRecAdapter.setOnListItemClickListener(this);

        if(homePageContainer1!=null)
        homePageContainer1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int measuredHeight = homePageContainer1.getMeasuredHeight();
                Log.d(TAG,"this is the measured height : "+measuredHeight);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mContent_Home.getLayoutParams();
                layoutParams.height = measuredHeight;
                mContent_Home.setLayoutParams(layoutParams);
                if (measuredHeight != 0) {
                    homePageContainer1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });

        mRefresh_home.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                if (mhdtPresenter != null) {
                    mhdtPresenter.loadMore(id);
                }
            }
        });
    }

    @Override
    protected void loadData() {
        Bundle arguments = getArguments();
        String theme = arguments.getString(constant.HOMEPAGE_KEY_THEME);
        id = arguments.getInt(constant.HOMEPAGE_KEY_ID);
        Log.d(TAG,"theme:"+theme);
        Log.d(TAG,"id:"+id);
        if (mhdtPresenter!=null) {
            mhdtPresenter.getContentByThemeId(id);
        }

    }
    //分页面的layout,子类需要实现这一方法的原因是baseFragment的loadSuccessView需要一个绑定了如下layout的页面
    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home_recommend_base;
    }

    @Override
    protected void initPresenter() {
        mhdtPresenter = homePreDiffThemeImpl.getsInstance();
        mhdtPresenter.registerViewCallBack(this);
    }

    @Override
    public void onContentLoad(List<HomeDifferentThemeThing.DataBean> contents) {
        //數據列表加載到了
//        if(contents!=null){
//            Log.d(TAG,"this is the data---------------------------------");
//        }
        Log.d(TAG,"meishi");
        mhomeRecAdapter.setData(contents);
        setUpState(State.SUCCESS);

    }

    @Override
    public int getcategoryId() {
        return id;
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

    @Override
    public void onEmpty() {

        setUpState(State.EMPTY);
    }

    @Override
    public void onLoadMoreError() {
        ToastUtils.showToast("网络异常，请稍后重试");
        if (mRefresh_home !=null) {
            mRefresh_home.finishLoadmore();
        }
    }

    @Override
    public void onLoadMoreEmpty() {
        ToastUtils.showToast("没有更多的数据了!");
        if (mRefresh_home !=null) {
            mRefresh_home.finishLoadmore();
        }

    }

    @Override
    public void onLoadMoreLoaded(List<HomeDifferentThemeThing.DataBean> contents) {
        mhomeRecAdapter.addData(contents);
        if (mRefresh_home !=null) {
            mRefresh_home.finishLoadmore();
        }
        ToastUtils.showToast("加载了"+contents.size()+"条记录!");

    }

    @Override
    public void onLooperListLoaded(List<HomeDifferentThemeThing.DataBean> contents) {
        Log.d(TAG,"ladder 8888");
        mhomeRecSwiperAdapter.setData(contents);
        mSwiper_home.setCurrentItem(Integer.MAX_VALUE /2);

    }

    @Override
    protected void release() {
        if(mhdtPresenter !=null){
            mhdtPresenter.unregisterViewCallBack(this);
        }
    }

    @Override
    public void onItemClick(int j) {
         handleItemClick(j);

    }

    private void handleItemClick(int j) {
        Intent intent =  new Intent(getContext(), HomeRecommendActivity.class);
        intent.putExtra("chosenNum",j);
        startActivity(intent);
    }
}

