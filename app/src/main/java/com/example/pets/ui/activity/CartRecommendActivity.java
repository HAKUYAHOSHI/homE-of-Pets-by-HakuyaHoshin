package com.example.pets.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.model.domain.demoGoods;
import com.example.pets.utils.demoGoodsUtils;
import com.example.pets.view.Cart_list_Callback;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

public class CartRecommendActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView0;

    TextView textView;

    TextView textView1;

    TextView textView2;
    TextView textView3;


    private int chosenNum;
    private List<demoGoods.Databean.DataHK> list1;
    private String imageUri;
    private String textmain;
    private double price;
    private int coupon;
    private String shopName;
    private int sales;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cart_recommend_big);
        Intent intent = getIntent();
        imageUri = intent.getStringExtra("imageUri");
        textmain = intent.getStringExtra("textmain");
        price = intent.getDoubleExtra("price", 10.00);
        coupon = intent.getIntExtra("coupon", 0);
        shopName = intent.getStringExtra("shopName");
        sales = intent.getIntExtra("sales", 0);

        imageView = findViewById(R.id.rec_big_pic1);
        textView0 = findViewById(R.id.rec_textmain_big1);
        textView = findViewById(R.id.rec_price_big1);
        textView1 = findViewById(R.id.rec_coupon_big1);
        textView2 = findViewById(R.id.rec_shops_big1);
        textView3 = findViewById(R.id.rec_peoplenum_big1);
        setData();

    }


    private void setData() {
        Glide.with(this).load(imageUri).into(imageView);
        textView1.setText(String.format("已省%1$d",coupon));
        textView.setText(String.format("￥%1$.2f",price));
        textView2.setText(shopName);
        textView3.setText(String.format("已购%1$d",sales));
        textView0.setText(textmain);

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

}
