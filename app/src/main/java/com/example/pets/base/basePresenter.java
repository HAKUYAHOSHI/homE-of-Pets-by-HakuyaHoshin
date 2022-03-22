package com.example.pets.base;

import com.example.pets.view.HomeCallBack;

public interface basePresenter<T> {

    void registerViewCallBack(T CallBack);

    void unregisterViewCallBack(T CallBack);
}
