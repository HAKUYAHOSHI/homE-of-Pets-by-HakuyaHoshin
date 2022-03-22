package com.example.pets.base;

public interface baseCallback {
    //基本每个页面都需要网络处理
    void onNetworkError();

    void onLoading();

    void onEmpty();
}
