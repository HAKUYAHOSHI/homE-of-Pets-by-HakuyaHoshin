package com.example.pets.view;

import com.example.pets.base.baseCallback;
import com.example.pets.model.domain.HomeDifferentThemeThing;

import java.util.List;

public interface HomeDifferentThemeCallBack  extends baseCallback{
    //数据加载回来
    void onContentLoad(List<HomeDifferentThemeThing.DataBean> contents);

    int getcategoryId();

    void onLoadMoreError();

    void onLoadMoreEmpty();

    void onLoadMoreLoaded(List<HomeDifferentThemeThing.DataBean> contents);

    void onLooperListLoaded(List<HomeDifferentThemeThing.DataBean> contents);
}
