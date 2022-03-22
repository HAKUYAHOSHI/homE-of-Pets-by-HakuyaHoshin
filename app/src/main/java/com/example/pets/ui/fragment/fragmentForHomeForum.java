package com.example.pets.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.ui.activity.HomeForumActivity;

import butterknife.BindView;

public class fragmentForHomeForum extends baseFragment {
    @BindView(R.id.forumPiece)
    LinearLayout linearLayout;

    @Override
    protected void initView(View view) {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HomeForumActivity.class));
            }
        });
        setUpState(State.SUCCESS);
    }

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_forumhome;
    }
}
