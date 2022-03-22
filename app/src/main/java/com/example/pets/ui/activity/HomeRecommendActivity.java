package com.example.pets.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.pets.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

public class HomeRecommendActivity extends AppCompatActivity {

    @BindView(R.id.home_rec_relativelayout)
    RelativeLayout relativeLayout;

    @BindView(R.id.rec_big_pic)
    ImageView imageView;

    @BindView(R.id.rec_textmain_big)
    TextView textView0;

    @BindView(R.id.rec_price_big)
    TextView textView;

    @BindView(R.id.rec_coupon_big)
    TextView textView1;

    @BindView(R.id.rec_shops_big)
    TextView textView2;

    @BindView(R.id.rec_peoplenum_big)
    TextView textView3;


    private int chosenNum;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home_recommend_big);
        Intent intent = getIntent();
        chosenNum = intent.getIntExtra("chosenNum",1);

        relativeLayout = findViewById(R.id.home_rec_relativelayout);
        imageView = findViewById(R.id.rec_big_pic);
        textView0 = findViewById(R.id.rec_textmain_big);
        textView = findViewById(R.id.rec_price_big);
        textView1 = findViewById(R.id.rec_coupon_big);
        textView2 = findViewById(R.id.rec_shops_big);
        textView3 = findViewById(R.id.rec_peoplenum_big);


        setData(chosenNum);
    }


    private void setData(int j) {
        List<String> pic_list = new ArrayList<>();
        pic_list.add("https://img14.360buyimg.com/pop/jfs/t1/135558/30/24376/461776/62204eefE87dc3d37/e8df0bba939c3e9d.jpg");
        pic_list.add("https://img13.360buyimg.com/n1/s800x800_jfs/t1/117639/4/21306/105223/62287c1dE96f1f284/c2ec38ae03351e45.jpg");
        pic_list.add("https://img14.360buyimg.com/pop/jfs/t1/216945/18/5696/132743/619f99cfE33f70ff5/e69bb3d8720a968b.jpg");
        pic_list.add("https://img14.360buyimg.com/pop/jfs/t1/93903/35/19142/374750/61458c89Efb4c071b/5af6f373404dc1a4.jpg");
        pic_list.add("https://img14.360buyimg.com/pop/jfs/t1/135558/30/24376/461776/62204eefE87dc3d37/e8df0bba939c3e9d.jpg");
        pic_list.add("https://img12.360buyimg.com/n1/s800x800_jfs/t1/148100/38/24135/99531/621c8411E4306ab0b/bad5c5d1e2856813.jpg");

        Random random1 =new Random();
        List<String> text_list = new ArrayList<>();
        text_list.add(	"伊萨游猎民族成猫幼猫猫粮全营养配方英短成猫深海鱼5斤天然猫粮 游猎猫粮2.5kg（鱼肉味）");
        text_list.add("【官方自营】雪貂留香 猫多爱猫咪沐浴露");
        text_list.add("芭贝乐 猫碗猫咪饮水机宠物自动喂食器");
        text_list.add("芭贝乐 猫抓板猫窝猫玩具磨爪神器");
        text_list.add("京东京造鲜肉无谷全价猫粮（鸡肉盛宴）2kg【高鲜肉|0肉粉】单一肉源鸡肉配方冻干粉喷涂主粮通用粮全阶段");
        text_list.add("【官方自营】雪貂留香 宠物除臭喷雾消毒液");

        Random random2 =new Random();
        List<Double> price_list = new ArrayList<>();
        price_list.add(48.7);
        price_list.add(19.9);
        price_list.add(19.00);
        price_list.add(21.00);
        price_list.add(11.00);
        price_list.add(89.00);


        Random random3 =new Random();
        List<Integer> discount_list = new ArrayList<>();
        discount_list.add(10);
        discount_list.add(30);
        discount_list.add(5);
        discount_list.add(5);
        discount_list.add(40);
        discount_list.add(0);

        Random random4 =new Random();
        List<String> shop_list = new ArrayList<>();
        shop_list.add(	"伊萨旗舰店");
        shop_list.add("雪貂留香旗舰店");
        shop_list.add("铭羽宠物用品专营店");
        shop_list.add("铭羽宠物用品专营店");
        shop_list.add("京东京造官方自营旗舰店");
        shop_list.add("雪貂留香旗舰店");

        Random random5 =new Random();
        List<Integer> sale_list = new ArrayList<>();
        sale_list.add(65);
        sale_list.add(0);
        sale_list.add(10);
        sale_list.add(157);
        sale_list.add(27658);
        sale_list.add(39);



        Glide.with(this).load(pic_list.get(j)).into(imageView);
        textView1.setText(String.format("已省%1$d",discount_list.get(j)));
        textView.setText(String.format("￥%1$.2f",price_list.get(j)));
        textView2.setText(shop_list.get(j));
        textView3.setText(String.format("已购%1$d",sale_list.get(j)));
        textView0.setText(text_list.get(j));

    }

}
