package com.example.pets.presenter.impl;


import android.util.Log;

import com.example.pets.model.api;
import com.example.pets.model.domain.MainThemeThing;
import com.example.pets.presenter.Home_Theme_Presenter;
import com.example.pets.utils.retrofitManager;
import com.example.pets.view.HomeCallBack;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePreImpl implements Home_Theme_Presenter {
    private HomeCallBack mCallBack=null;

    private final String TAG = "HomePreImpl";
    @Override
    public void getCategory() {
        if (mCallBack!=null) {
            mCallBack.onLoading();
        }
     //获取商品分类
        Retrofit retrofit = retrofitManager.getInstance().getRetrofit();
        api api = retrofit.create(com.example.pets.model.api.class);
        Call<MainThemeThing> task = api.getItems();
        task.enqueue(new Callback<MainThemeThing>() {
            @Override
            public void onResponse(Call<MainThemeThing> call, Response<MainThemeThing> response) {
                //回复结果
                int code = response.code();
                if(code== HttpURLConnection.HTTP_OK){
                    //请求成功拿到数据啦！
                    Log.d(TAG,"right!!");
                    MainThemeThing itemOfSwiper = response.body();
                    if(mCallBack!=null){
                        if (itemOfSwiper==null||itemOfSwiper.getData().size()==0) {
                                mCallBack.onEmpty();
                        }else{
                        mCallBack.OnCategoryLoaded(itemOfSwiper);   //报错
                        }
                    }

                }
                else{
                    //请求失败
                    Log.d(TAG,"wrong!!");
                    if (mCallBack!=null) {
                        mCallBack.onNetworkError();
                    }
                }
            }

            @Override
            public void onFailure(Call<MainThemeThing> call, Throwable t) {
                 //加载失败的结果
                if (mCallBack!=null) {
                    mCallBack.onNetworkError();
                }
            }
        });
    }

    @Override
    public void registerViewCallBack(HomeCallBack homeCallBack) {
     //注册UI通知接口
        this.mCallBack = homeCallBack;
    }

    @Override
    public void unregisterViewCallBack(HomeCallBack homeCallBack) {
     //取消UI通知接口
        mCallBack = null;
    }
}
