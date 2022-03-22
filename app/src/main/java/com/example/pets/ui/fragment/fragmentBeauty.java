package com.example.pets.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.ui.activity.BeautyActivity;
import com.example.pets.ui.adapter.beautyAdapter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;

public class fragmentBeauty extends baseFragment {
    @BindView(R.id.beauty_tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.beauty_viewpager)
    ViewPager viewPager;


    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_beauty;
    }
    @Override
    protected void initView(View view) {
        beautyAdapter bA = new beautyAdapter(getChildFragmentManager());
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(bA);
        setUpState(State.SUCCESS);
    }
}
