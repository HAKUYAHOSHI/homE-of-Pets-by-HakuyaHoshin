package com.example.pets.model;

import com.example.pets.model.domain.HomeDifferentThemeThing;
import com.example.pets.model.domain.MainThemeThing;
import com.example.pets.model.domain.demoGoods;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface api {

    @GET("discovery/categories")        //那边的接口的路径get的。不要斜杠！
    Call<MainThemeThing> getItems();

    @GET
    Call<HomeDifferentThemeThing> getHomeDiffContent(@Url String url);

    @GET("goodslist?apikey=86af9dabedce62f7&cid1=6994")
    Call<demoGoods> getDemoGoods(@Query("pageindex") Integer pageindex);
}
