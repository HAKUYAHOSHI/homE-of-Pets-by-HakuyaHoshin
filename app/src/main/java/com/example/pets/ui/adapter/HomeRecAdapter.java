package com.example.pets.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pets.R;
import com.example.pets.model.domain.HomeDifferentThemeThing;
import com.example.pets.ui.fragment.fragmentForHomeRec;
import com.example.pets.utils.UrlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

//這是處理瀑布流的Adapter
public class HomeRecAdapter extends RecyclerView.Adapter<HomeRecAdapter.InnerHolder> {
    private static final String TAG = "HomeRecAdapter";
    //即使外面的數據置空了裏面也不會崩潰
    List<HomeDifferentThemeThing.DataBean> data  = new ArrayList<>();
    private View mitemView;
    private List<String> dataFromDataBase;
    private OnListItemClickListener mItemClickListener = null;

    //爲何暫時沒有getItem()？因爲我們還沒有設置不同界面的數據拿取

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  //创建ViewHolder的时刻就给一个绑定，
        mitemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_recommend_piece, parent, false);

        return new InnerHolder(mitemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //設置數據


        Random random =new Random();
        int j  = random.nextInt(5);

        HomeDifferentThemeThing.DataBean dataBean = data.get(position);
        try {
            holder.setData(dataBean,position,j);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //注意
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemClickListener!=null){
                    mItemClickListener.onItemClick(holder.getAdapterPosition());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<HomeDifferentThemeThing.DataBean> contents) {
        //拿数据
        data.clear();
        data.addAll(contents);
//        Log.d(TAG,"this one plus:====>"+data.toString());
        notifyDataSetChanged();
    }

    public void addData(List<HomeDifferentThemeThing.DataBean> contents) { //这是给外面的用的
        //添加之前拿到原来的size
        int oldSize = data.size();

        data.addAll(contents);
        //更新UI
        notifyItemRangeChanged(oldSize,contents.size());

    }



    public void setOnListItemClickListener(OnListItemClickListener listener) { //这个方法用于把一个别处定义的方法拿到这里使用
        this.mItemClickListener = listener;
    }

    public interface OnListItemClickListener{
        void onItemClick(int j);
    }



    public class InnerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rec_cover)
        public ImageView coverRec;

        @BindView(R.id.rec_textmain)
        public TextView textMainRec;

        @BindView(R.id.rec_price)
        public TextView priceRec;

        @BindView(R.id.rec_coupon)
        public TextView couponRec;

        @BindView(R.id.rec_shops)
        public TextView shopsRec;

        @BindView(R.id.rec_peoplenum)
        public TextView peopleNumRec;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(HomeDifferentThemeThing.DataBean dataBean,int position,int j) throws Exception {
            //设置数据
            Context context = itemView.getContext();
            long couponAmount = dataBean.getCoupon_amount();
            float realPrice = Float.parseFloat(dataBean.getZk_final_price())-couponAmount;


            ViewGroup.LayoutParams layoutParams = coverRec.getLayoutParams();
            int width = layoutParams.width;
            int height = layoutParams.height;
            int coverSize = width;


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




            textMainRec.setText(text_list.get(j));

            Glide.with(context).load(pic_list.get(position%5)).into(coverRec);
            couponRec.setText(String.format(context.getString(R.string.rec_coupon_text),discount_list.get(position%5)));
            priceRec.setText(String.format(context.getString(R.string.rec_price_text),price_list.get(position%5)));
            shopsRec.setText(shop_list.get(position%5));
            peopleNumRec.setText(String.format(context.getString(R.string.rec_peopleNum_text),sale_list.get(position%5)));
        }
    }
}
