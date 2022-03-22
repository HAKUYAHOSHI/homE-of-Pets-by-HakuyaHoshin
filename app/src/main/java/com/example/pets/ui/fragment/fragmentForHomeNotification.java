package com.example.pets.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.ui.activity.HomeForumActivity;
import com.example.pets.ui.activity.HomeNotificationActivity;

import java.util.zip.Inflater;

import butterknife.BindView;

public class fragmentForHomeNotification extends baseFragment {
    @BindView(R.id.home_notificationPiece)
    LinearLayout linearLayout;

    @Override
    protected void initView(View view) {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HomeNotificationActivity.class));
            }
        });
        setUpState(State.SUCCESS);
    }

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_notificationhome;
    }
}
