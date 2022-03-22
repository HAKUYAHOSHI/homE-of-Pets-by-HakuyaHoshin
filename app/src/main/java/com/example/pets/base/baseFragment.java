package com.example.pets.base;


import static com.amap.api.maps.MapsInitializer.setApiKey;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pets.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public abstract class baseFragment extends Fragment {

    private State currentState = State.NONE;
    private View mloadingView;
    private View msuccessView;
    private View merrorView;
    private View memptyView;

    protected Bundle savedInstanceState;

    public enum State{
        NONE,LOADING,SUCCESS,ERROR,EMPTY
    }

    private Unbinder mBind;
    private FrameLayout blankPageContainer;


    @OnClick(R.id.network_error_display)
    public void retry(){
        //重新加载内容…… 具體業務不知道，需要子類覆寫
        onRetryClick();
    }

    //子類需要設置網絡錯誤的點擊事件，覆寫這個
    protected void onRetryClick() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.blank_fragment_layout, container, false);
        blankPageContainer = rootView.findViewById(R.id.blank_page);
        loadStateView(inflater,container);

        mBind  = ButterKnife.bind(this,rootView);

        initView(rootView);
        initListener();
        initPresenter();
        loadData();
        this.savedInstanceState = savedInstanceState;
        setApiKey("8a48b12ba838220448e2eeeebb693589");
        return rootView;
    }

    protected void initListener() {

    }


    //返回的正确的绑定了的页面被加入空的FrameLayout内
    private void loadStateView(LayoutInflater inflater, ViewGroup container) {
        //成功的view
        msuccessView = loadSuccessView(inflater, container);
        blankPageContainer.addView(msuccessView);

        //Loading的view
        mloadingView = dealLoadingView(inflater, container);
        blankPageContainer.addView(mloadingView);

        //錯誤的頁面
        merrorView = loadErrorView(inflater, container);
        blankPageContainer.addView(merrorView);

        //空的頁面
        memptyView = loadEmptyView(inflater, container);
        blankPageContainer.addView(memptyView);

        setUpState(State.NONE);


    }

    protected View loadErrorView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.error_fragment_layout,container,false);
    }
    protected View loadEmptyView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.empty_fragment_layout,container,false);
    }


    //暴露一個方法來切換狀態，子類通過這個方法來切換狀態頁面即可……
    public void setUpState(State state){
        this.currentState = state;
        if (currentState== State.SUCCESS) {
            msuccessView.setVisibility(View.VISIBLE);
        }else{
            msuccessView.setVisibility(View.GONE);
        }
        if (currentState== State.LOADING) {
            mloadingView.setVisibility(View.VISIBLE);
        }else{
            mloadingView.setVisibility(View.GONE);
        }
        //可以這樣寫……
        merrorView.setVisibility(currentState==State.ERROR?View.VISIBLE:View.GONE);
        memptyView.setVisibility(currentState==State.EMPTY?View.VISIBLE:View.GONE);
    }

    //子類可以覆寫
    protected View dealLoadingView(LayoutInflater inflater, ViewGroup container) {
        return  inflater.inflate(R.layout.loading_fragment_layout, container, false);

    }


    protected void initView(View view) {
    }

    protected void initPresenter() {

    }

    protected void loadData() {
    }

    protected View loadSuccessView(LayoutInflater inflater, ViewGroup container){
        int resId = getRootViewResId();
        return inflater.inflate(resId,container,false);
    }

    protected abstract int getRootViewResId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mBind!=null){
            mBind.unbind();
        }
        release();
    }

    protected void release() {

    }
}
