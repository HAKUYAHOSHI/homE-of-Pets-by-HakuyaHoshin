package com.example.pets.utils;

import android.widget.Toast;

import com.example.pets.base.baseApplication;

public class ToastUtils {

    private static Toast toast;

    public static void showToast(String tips){
        if(toast == null){
            toast = Toast.makeText(baseApplication.getAppContext(),tips,Toast.LENGTH_SHORT);
        }else{
            toast.setText(tips);
        }
        toast.show();
    }
}
