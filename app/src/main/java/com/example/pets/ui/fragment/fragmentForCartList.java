package com.example.pets.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.example.pets.R;
import com.example.pets.base.baseFragment;
import com.example.pets.model.domain.HomeDifferentThemeThing;
import com.example.pets.model.domain.MainThemeThing;
import com.example.pets.presenter.Home_Different_theme_Presenter;
import com.example.pets.presenter.impl.homePreDiffThemeImpl;
import com.example.pets.ui.activity.HomeRecommendActivity;
import com.example.pets.ui.adapter.HomeRecAdapter;
import com.example.pets.ui.adapter.HomeRecSwiperAdapter;
import com.example.pets.utils.ToastUtils;
import com.example.pets.utils.constant;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.bezierlayout.BezierLayout;

import java.util.List;

import butterknife.BindView;

public class fragmentForCartList extends baseFragment{

    @Override
    protected int getRootViewResId() {
        return 0;
    }


}
