package com.example.pets.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitManager {

    private static final retrofitManager ourInstance = new retrofitManager();
    private final Retrofit mRetrofit;
    public static retrofitManager getInstance() {
        return ourInstance;
    }

    private retrofitManager(){
       mRetrofit = new Retrofit.Builder()
                .baseUrl(constant.BASE_URL)   //你的后端的网址
                .addConverterFactory(GsonConverterFactory.create())
                .build();
     }
     public Retrofit getRetrofit(){
        return mRetrofit;
     }

}
