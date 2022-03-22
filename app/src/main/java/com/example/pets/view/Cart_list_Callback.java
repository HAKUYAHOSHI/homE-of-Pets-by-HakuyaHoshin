package com.example.pets.view;

import com.example.pets.model.domain.demoGoods;

import java.util.List;

public interface Cart_list_Callback {
    void onContentCartLoaded(List<demoGoods.Databean.DataHK> list);

    void onEmpty();

    void onLoading();

    void onNetworkError();
}
