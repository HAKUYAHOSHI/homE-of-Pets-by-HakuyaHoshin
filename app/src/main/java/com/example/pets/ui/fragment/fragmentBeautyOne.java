package com.example.pets.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.ui.activity.BeautyActivity;

import butterknife.BindView;

public class fragmentBeautyOne extends baseFragment {


    @BindView(R.id.beauty_small)
    public LinearLayout linearLayout;

    @Override
    protected void initView(View view) {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BeautyActivity.class);
                startActivity(intent);
            }
        });
        setUpState(State.SUCCESS);
    }

    @Override
    protected int getRootViewResId() {
            return R.layout.beauty_forrealbeauty;
    }
}
