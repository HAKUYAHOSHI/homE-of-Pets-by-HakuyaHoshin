package com.example.pets.ui.adapter;

import android.util.Log;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.pets.R;
import com.example.pets.model.domain.HomeDifferentThemeThing;
import com.example.pets.utils.GlideCircleTransformWithBorderUtils;
import com.example.pets.utils.UrlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

//這是處理swiper的Adapter
public class HomeRecSwiperAdapter extends PagerAdapter {

    private static final String TAG = "HomeRecSwiperAdapter";
    private List<HomeDifferentThemeThing.DataBean> mData = new ArrayList<>();


    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            Log.d(TAG,"measured height is"+container.getMeasuredHeight()/2);

            Random random =new Random();
            List<String> pic_list = new ArrayList<>();
            pic_list.add("https://img14.360buyimg.com/pop/jfs/t1/135558/30/24376/461776/62204eefE87dc3d37/e8df0bba939c3e9d.jpg");
            pic_list.add("https://img13.360buyimg.com/n1/s800x800_jfs/t1/117639/4/21306/105223/62287c1dE96f1f284/c2ec38ae03351e45.jpg");
            pic_list.add("https://img14.360buyimg.com/pop/jfs/t1/216945/18/5696/132743/619f99cfE33f70ff5/e69bb3d8720a968b.jpg");
            pic_list.add("https://img14.360buyimg.com/pop/jfs/t1/93903/35/19142/374750/61458c89Efb4c071b/5af6f373404dc1a4.jpg");
            pic_list.add("https://img14.360buyimg.com/pop/jfs/t1/135558/30/24376/461776/62204eefE87dc3d37/e8df0bba939c3e9d.jpg");
            pic_list.add("https://img12.360buyimg.com/n1/s800x800_jfs/t1/148100/38/24135/99531/621c8411E4306ab0b/bad5c5d1e2856813.jpg");

             int j  = random.nextInt(5);


        int realPosition = position % mData.size();
            HomeDifferentThemeThing.DataBean dataBean = mData.get(realPosition);
            String coverUrl = pic_list.get(j);
            ImageView iv = new ImageView(container.getContext());

        //设置参数与控件拉伸以匹配ViewPager
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        iv.setLayoutParams(layoutParams);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

        RoundedCorners roundedCorners = new RoundedCorners(1);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);


        Glide.with(container.getContext()).load(coverUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL).transform(new GlideCircleTransformWithBorderUtils(iv.getContext(),2,0))
                .into(iv);  //轻便的android图片加载框架，简单加载图片！
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    public void setData(List<HomeDifferentThemeThing.DataBean> contents) {
        mData.clear();
        mData.addAll(contents);
        notifyDataSetChanged();
        Log.d(TAG,"ladder 3");
    }
}
