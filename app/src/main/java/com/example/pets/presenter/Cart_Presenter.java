package com.example.pets.presenter;

import com.example.pets.base.basePresenter;
import com.example.pets.view.Cart_list_Callback;
import com.example.pets.view.HomeDifferentThemeCallBack;

public interface Cart_Presenter extends basePresenter<Cart_list_Callback> {
    void addItem();  //暂时不用

;}
