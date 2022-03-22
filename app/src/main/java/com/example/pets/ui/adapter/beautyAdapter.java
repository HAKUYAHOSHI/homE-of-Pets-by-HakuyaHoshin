package com.example.pets.ui.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.pets.ui.fragment.fragmentBeautyAnother;
import com.example.pets.ui.fragment.fragmentBeautyOne;

public class beautyAdapter extends FragmentPagerAdapter {
    public beautyAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public beautyAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0) {
            return "宠物美容";
        }
        else{
            return "宠物医疗";
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==0)
            return new fragmentBeautyOne();
        else
            return new fragmentBeautyAnother();
    }

}
