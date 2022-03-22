package com.example.pets.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.pets.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

public class HomeRecBigAdapter extends PagerAdapter {

    private int j;

    @Override
    public int getCount() {
        return 50;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public void setData(int j){

    }

}
