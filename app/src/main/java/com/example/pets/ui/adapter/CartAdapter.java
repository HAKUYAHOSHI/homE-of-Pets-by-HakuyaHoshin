package com.example.pets.ui.adapter;

import android.content.Context;
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
import com.example.pets.model.domain.demoGoods;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.InnerHolder> {

    private static final String TAG = "CartAdapter";
    List<demoGoods.Databean.DataHK> data = new ArrayList<>();
    private CartAdapter.OnListItemClickListener onListItemClickListener;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View items = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_cart_recommend_piece,parent,false);
        Log.d(TAG,"onCreateViewHolder() here");
        return new InnerHolder(items);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder() here");
        System.out.println(data);
        demoGoods.Databean.DataHK item = data.get(position);
        holder.setData(item,position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onListItemClickListener!=null){
                    onListItemClickListener.onItemClick(holder.getAdapterPosition());
                }
            }
        });


    }

    public void addData(List<demoGoods.Databean.DataHK> content){  //给外面的人使用！
        data.clear();
        data.addAll(content);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rec_cover1)
        public ImageView coverCart;

        @BindView(R.id.rec_textmain1)
        public TextView textMainCart;

        @BindView(R.id.rec_price1)
        public TextView priceCart;

        @BindView(R.id.rec_coupon1)
        public TextView couponCart;

        @BindView(R.id.rec_shops1)
        public TextView shopsCart;

        @BindView(R.id.rec_peoplenum1)
        public TextView peopleNumCart;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            //这个到底是干嘛的
            ButterKnife.bind(this,itemView);
        }

        public void setData(demoGoods.Databean.DataHK item, int position) {
            Context context = itemView.getContext();


            textMainCart.setText(item.getGoods_name());

            Glide.with(context).load(item.picurl).into(coverCart);
            couponCart.setText(String.format(context.getString(R.string.rec_coupon_text),item.discount));
            priceCart.setText(String.format(context.getString(R.string.rec_price_text),Float.parseFloat(item.price_after)));
            shopsCart.setText(item.shopname);
            peopleNumCart.setText(String.format(context.getString(R.string.rec_peopleNum_text),item.sales));

        }
    }
    public interface OnListItemClickListener{
        void onItemClick(int j);
    }

    public void setONItemClickListener(CartAdapter.OnListItemClickListener itemClickListener){
        this.onListItemClickListener = itemClickListener;
    }
}
