package com.example.pets.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.pets.R;
import com.example.pets.ui.fragment.fragmentForCheckSmall;

import butterknife.BindView;

public class CheckSmallAdapter extends PagerAdapter {
    private static final String TAG = "CheckSmallAdapter";
    private CheckItemClickListener checkItemClickListener;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View linearLayout = LayoutInflater.from(container.getContext()).inflate(R.layout.check_small_place_layout,null,false);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkItemClickListener.onCheckItemClick();
            }
        });
        container.addView(linearLayout);
        return linearLayout;
    }


    @Override
    public int getCount() {
        Log.d(TAG,"HERE 2");
        return 100;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    public void setOnCheckItemClickListener(CheckItemClickListener checkItemClickListener){
        this.checkItemClickListener = checkItemClickListener;
    }
    public interface  CheckItemClickListener{
        void onCheckItemClick();
    }
}
