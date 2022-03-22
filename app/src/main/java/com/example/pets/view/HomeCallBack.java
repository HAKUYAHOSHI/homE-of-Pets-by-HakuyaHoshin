package com.example.pets.view;

import com.example.pets.base.baseCallback;
import com.example.pets.model.domain.MainThemeThing;

public interface HomeCallBack extends baseCallback {
    void OnCategoryLoaded(MainThemeThing mainThemeThing);

    void onNetworkError();

    void onLoading();

    void onEmpty();

}
