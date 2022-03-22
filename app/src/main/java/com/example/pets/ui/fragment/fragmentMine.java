package com.example.pets.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;

import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.ui.activity.AppraisalActivity;
import com.example.pets.ui.activity.CheckingActivity;
import com.example.pets.ui.activity.WalletActivity;

import butterknife.BindView;


public class fragmentMine extends baseFragment {

    @BindView(R.id.authentication)
    ImageButton authentication;

    @BindView(R.id.customerService)
    ImageButton customerService;

    @BindView(R.id.mine_versionAdaptation)
    ImageButton imageButton;

    @BindView(R.id.checking)
    ImageButton checking;

    @BindView(R.id.appraisal)
    ImageButton appraisal;

    @BindView(R.id.wallet)
    ImageButton wallet;

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view) {
        setClickListener();

        setUpState(State.SUCCESS);
    }

    private void setClickListener(){
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/HAKUYAHOSHI/R-androidandwxapps");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);


            }
        });
        customerService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext()).setTitle("提示")
                        .setMessage("功能暂未开放！").setPositiveButton("確定",null)
                        .setNegativeButton("取消",null).show();
            }
        });
        authentication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getContext()!=null) {
                    new AlertDialog.Builder(getContext()).setTitle("提示")
                            .setMessage("达到寄养50天或者购买商品30次或者购买医美服务总计30次即可获得VIP用户身份！").setPositiveButton("確定",null)
                            .setNegativeButton("取消",null).show();
                }
            }
        });
        checking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CheckingActivity.class);
                startActivity(intent);
            }
        });
        appraisal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AppraisalActivity.class);
                startActivity(intent);
            }
        });
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WalletActivity.class);
                startActivity(intent);
            }
        });

    }
}