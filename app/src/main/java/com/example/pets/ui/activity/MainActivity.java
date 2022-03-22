package com.example.pets.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.database.Observable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.ui.fragment.fragmentBeauty;
import com.example.pets.ui.fragment.fragmentCart;
import com.example.pets.ui.fragment.fragmentCheck;
import com.example.pets.ui.fragment.fragmentHome;
import com.example.pets.ui.fragment.fragmentMine;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottomNavigation)//replace .findviewById()
    public BottomNavigationView mBtv;
    private fragmentHome mFragmentH;
    private fragmentCheck mFragmentCH;
    private fragmentCart mFragmentCA;
    private fragmentMine mFragmentM;
    private fragmentBeauty mFragmentB;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragments();
        initListener();
    }

    private void initFragments() {
        mFragmentH = new fragmentHome();
        mFragmentCH = new fragmentCheck();
        mFragmentCA = new fragmentCart();
        mFragmentM = new fragmentMine();
        mFragmentB = new fragmentBeauty();
        mFragmentManager = getSupportFragmentManager();
        switchFragment(mFragmentH);
    }

    private void initListener() {
        //监听到导航栏选中的变化。
        mBtv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            /*
            * 这是一个绑定底栏点击的。参数是选的人。
            * */
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home){
                    switchFragment(mFragmentH);
                }
                else if(item.getItemId()==R.id.check){
                    switchFragment(mFragmentCH);
                }
                else if(item.getItemId()==R.id.cart){
                    switchFragment(mFragmentCA);
                }
                else if(item.getItemId()==R.id.meirong){
                    switchFragment(mFragmentB);
                }
                else if(item.getItemId()==R.id.mine){
                    switchFragment(mFragmentM);
                }
                return true;
            }
        });
    }

    private void switchFragment(baseFragment targetFragementH) {
      FragmentTransaction fts =  mFragmentManager.beginTransaction();

      fts.replace(R.id.main_page,targetFragementH);

      fts.commit();

    }


}