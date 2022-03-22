package com.example.pets.presenter.impl;

import android.util.Log;

import com.example.pets.model.api;
import com.example.pets.model.domain.HomeDifferentThemeThing;
import com.example.pets.presenter.Home_Different_theme_Presenter;
import com.example.pets.utils.UrlUtils;
import com.example.pets.utils.demoGoodsUtils;
import com.example.pets.utils.retrofitManager;
import com.example.pets.view.HomeDifferentThemeCallBack;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class homePreDiffThemeImpl implements Home_Different_theme_Presenter {
    private static final String TAG = "homePreDiffThemeImpl";
    private Map<Integer,Integer> pageInfo = new HashMap<>();  //保存哪一类翻到哪一页的信息
    public static final int DEFAULT_PAGE = 1;

    private ArrayList<HomeDifferentThemeCallBack> callback1 = new ArrayList<>();
    private Integer currentPager;

    @Override
    public void registerViewCallBack(HomeDifferentThemeCallBack CallBack) {
        if (!callback1.contains(CallBack)) {   //XDDDDDDD!
                  callback1.add(CallBack);
        }
    }

    @Override
    public void unregisterViewCallBack(HomeDifferentThemeCallBack CallBack) {
       callback1.remove(CallBack);
    }

    @Override
    public void getContentByThemeId(int cate) {
        for (HomeDifferentThemeCallBack hdtcallback : callback1) {
            if (hdtcallback.getcategoryId() == cate) {
            hdtcallback.onLoading();    //想要加载。
        }}
        //根据分类id加载内容，需要查看分类的情况！！

        Integer nowPage = pageInfo.get(cate);
        //管理页面
        if(nowPage == null){
            nowPage = DEFAULT_PAGE;
            pageInfo.put(cate,nowPage);   //如果nowPage是等于null的话，就把它设置成默认的页数1，然后放到存储的HashMap对象里面。
        }


        Call<HomeDifferentThemeThing> task = createTask(cate, nowPage);
        task.enqueue(new Callback<HomeDifferentThemeThing>() {
            @Override
            public void onResponse(Call<HomeDifferentThemeThing> call, Response<HomeDifferentThemeThing> response) {
                int code = response.code();
                //Log.d(TAG, String.valueOf(code));
                if(code == HttpURLConnection.HTTP_OK){
                    HomeDifferentThemeThing pageContent = response.body(); //内容从这里出来，数据给到UI更新
               //     Log.d(TAG,"this is the content"+pageContent);
                    handleContentOfDifferentPageH(pageContent,cate);
                }else{
                     //TODO
                    handleContentOfDiffPageNetwork(cate);
                }
            }

            @Override
            public void onFailure(Call<HomeDifferentThemeThing> call, Throwable t) {
                Log.d(TAG,t.toString());
                handleContentOfDiffPageNetwork(cate);

            }
        });

    }

    private Call<HomeDifferentThemeThing> createTask(int cate, Integer nowPage) {
        String homePageUrl = UrlUtils.createhomePageUrl(cate, nowPage);//选择第几页？这个应该对应者theme。使用了一个HashMap来管理！
        Retrofit retrofit = retrofitManager.getInstance().getRetrofit();
        api api = retrofit.create(com.example.pets.model.api.class);
        Call<HomeDifferentThemeThing> task = api.getHomeDiffContent(homePageUrl);
        return task;
    }

    private void handleContentOfDiffPageNetwork(int cate) {
        for (HomeDifferentThemeCallBack hdtcallback : callback1) {
            if (hdtcallback.getcategoryId() == cate) {
                hdtcallback.onNetworkError();
            }
        }
    }

    private void handleContentOfDifferentPageH(HomeDifferentThemeThing pageContent, int cate) {
        List<HomeDifferentThemeThing.DataBean> data1 = pageContent.getData();
       // Log.d(TAG,"this is the callback"+callback1);
        for (HomeDifferentThemeCallBack hdtcallback : callback1) {
         //   Log.d(TAG,"this is the right1 place");
            if (hdtcallback.getcategoryId() == cate) {
            //    Log.d(TAG,"this is the right place");
                if (pageContent == null || data1.size() == 0) {
                    hdtcallback.onEmpty();
                }else{
                    hdtcallback.onLooperListLoaded(data1.subList(data1.size()-5,data1.size()));//代表的是每一次如果拿数据，轮播图的都是后五个
                    hdtcallback.onContentLoad(data1);
                }
            }

        }
    }

    @Override
    public void loadMore(int cate) {
        Log.d(TAG,"the temporary result");
        //加载数据更多！
        //1.当前页面获取
        currentPager = pageInfo.get(cate);
        if (currentPager == null) {
            currentPager = 1;
        }
        //2.页码自增
        currentPager++;
        //3.加载数据
        Call<HomeDifferentThemeThing> task = createTask(cate, currentPager);
        //4.再次请求，处理数据结果
        task.enqueue(new Callback<HomeDifferentThemeThing>() {
            @Override
            public void onResponse(Call<HomeDifferentThemeThing> call, Response<HomeDifferentThemeThing> response) {
                //再次请求的结果
                // TODO HERE
                Log.d(TAG,"the result code is =========================>"+response.code());
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    HomeDifferentThemeThing result = response.body();
                  //  Log.d(TAG,"this is the reloaded data"+result);
                    handleLoaderMoreResult(result,cate);

                }else{
                    handleLoadMoreError(cate);

                }
            }

            @Override
            public void onFailure(Call<HomeDifferentThemeThing> call, Throwable t) {
                handleLoadMoreError(cate);

            }
        });

    }

    private void handleLoaderMoreResult(HomeDifferentThemeThing result, int cate) {
        for (HomeDifferentThemeCallBack hDTC : callback1) {
            if (hDTC.getcategoryId() == cate) {
                if (result == null || result.getData().size() == 0) {
                       hDTC.onLoadMoreEmpty();
                }else{
                       hDTC.onLoadMoreLoaded(result.getData());
                }
            }

        }
    }

    private void handleLoadMoreError(int cate) {
        currentPager--;
        pageInfo.put(cate,currentPager);
        for (HomeDifferentThemeCallBack callback0 : callback1) {
            if (callback0.getcategoryId() == cate) {
                callback0.onLoadMoreError();

            }

        }
    }

    @Override
    public void reLoad(int cate) {


    }


    private homePreDiffThemeImpl(){

    }
    private static Home_Different_theme_Presenter sInstance = null;
    public static Home_Different_theme_Presenter getsInstance(){
        if(sInstance==null){
            sInstance = new homePreDiffThemeImpl();
        }
        return sInstance;
    }
}
