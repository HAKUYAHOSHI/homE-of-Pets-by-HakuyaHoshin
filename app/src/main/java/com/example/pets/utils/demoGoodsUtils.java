package com.example.pets.utils;

import com.example.pets.model.api;
import com.example.pets.model.domain.demoGoods;
import com.example.pets.presenter.Cart_Presenter;
import com.example.pets.view.Cart_list_Callback;
import com.example.pets.view.HomeDifferentThemeCallBack;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class demoGoodsUtils implements Cart_Presenter {
    public List<demoGoods.Databean.DataHK> list = new ArrayList<>();

    private ArrayList<Cart_list_Callback> callback2 = new ArrayList<>();


    public void addItem(){
        for (Cart_list_Callback hdtcallback : callback2)
                hdtcallback.onLoading();    //想要加载。


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api-gw.haojingke.com/index.php/v1/api/jd/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api service = retrofit.create(api.class);
        Call<demoGoods> model = service.getDemoGoods(1);
        model.enqueue(new Callback<demoGoods>() {
            @Override
            public void onResponse(Call<demoGoods> call, Response<demoGoods> response) {
                if(response.code()== HttpURLConnection.HTTP_OK){
                    demoGoods body = response.body();
                    if (body!=null) {
                        list.addAll(body.getData().getData());
                        for(Cart_list_Callback cart_list_callback:callback2){
                            if (list == null || list.size() == 0) {
                                cart_list_callback.onEmpty();
                            }else
                                cart_list_callback.onContentCartLoaded(list);
                        }
                    }
                }else{
                    for (Cart_list_Callback hdtcallback : callback2) {
                            hdtcallback.onNetworkError();
                    }
                }
            }

            @Override
            public void onFailure(Call<demoGoods> call, Throwable t) {
                System.out.println(t.getMessage());
                System.out.println("wrong here---------------------");
                for (Cart_list_Callback hdtcallback : callback2) {
                        hdtcallback.onNetworkError();
                }

            }
        });

    }

    @Override
    public void registerViewCallBack(Cart_list_Callback CallBack) {
        if (!callback2.contains(CallBack)) {
            callback2.add(CallBack);
        }

    }

    @Override
    public void unregisterViewCallBack(Cart_list_Callback CallBack) {
        callback2.remove(CallBack);
    }
}
