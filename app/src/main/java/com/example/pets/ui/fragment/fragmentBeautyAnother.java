package com.example.pets.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;

import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.ui.activity.BeautyActivity;
import com.example.pets.ui.activity.BeautyuActivityAnother;

import butterknife.BindView;

public class fragmentBeautyAnother extends baseFragment {

    @BindView(R.id.beauty_small_1)
    public LinearLayout linearLayout;




    @Override
    protected void initView(View view) {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BeautyuActivityAnother.class);
                startActivity(intent);
            }
        });

        setUpState(State.SUCCESS);
    }

    @Override
    protected int getRootViewResId() {
        return R.layout.beauty_forrealmedical;
    }
}
