package com.example.pets.presenter;

import com.example.pets.base.basePresenter;
import com.example.pets.view.HomeDifferentThemeCallBack;

public interface Home_Different_theme_Presenter extends basePresenter<HomeDifferentThemeCallBack> {
    void getContentByThemeId(int cate);

    void loadMore(int cate);

    void reLoad(int cate);   //暂时不用

;}
