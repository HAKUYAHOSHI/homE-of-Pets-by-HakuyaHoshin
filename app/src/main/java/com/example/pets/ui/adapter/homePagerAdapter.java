package com.example.pets.ui.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pets.model.domain.MainThemeThing;
import com.example.pets.ui.fragment.fragmentForHomeForum;
import com.example.pets.ui.fragment.fragmentForHomeNotification;
import com.example.pets.ui.fragment.fragmentForHomeRec;

import java.util.ArrayList;
import java.util.List;

//這是處理主頁面的Adapter
public class homePagerAdapter extends FragmentPagerAdapter {

    private final String TAG="homePagerAdapter";
    private List<MainThemeThing.DataBean> mItemSwiList = new ArrayList<>();

    public homePagerAdapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "推荐";
        else if (position==1)
            return "通知";
        else
            return "来聊";
        //mItemSwiList.get(position).getTitle()
    }//这里是获得

    @NonNull
    @Override
    public Fragment getItem(int position) {   //切换到首页只是调用2次懒加载？
        if(position==0){
            MainThemeThing.DataBean dataBean = mItemSwiList.get(position);   //根据position拿到对应的dataBean！
            fragmentForHomeRec fFHR =  fragmentForHomeRec.newInstance(dataBean);  //都给返回首页那个了？现在不是！這裏也是鏈接主頁面和副頁面的關節
            // 这一方法返回的是获得了对应搜索结果的fragment！
            return fFHR;
        }
        else if(position==1){
            return new fragmentForHomeNotification();
        }
        else {
            return new fragmentForHomeForum();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public void setTitleData(MainThemeThing mainThemeThing) {

        mItemSwiList.clear();
        List<MainThemeThing.DataBean> data = mainThemeThing.getData(); //获得了dataBean，这里是和参数那里对应的？

        if(data!=null){
            Log.d(TAG,"this one ====>"+data.toString());
            this.mItemSwiList.addAll(data);  //报错
            notifyDataSetChanged();
        }else{
            Log.d(TAG,"NO FILE");
        }

    }
}
