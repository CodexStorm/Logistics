package com.example.codexsstorm.logisticsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.codexsstorm.logisticsapp.Activity.ItemList;
import com.example.codexsstorm.logisticsapp.Activity.LogisticsList;
import com.example.codexsstorm.logisticsapp.Entity.CategoryEntity;
import com.example.codexsstorm.logisticsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by codexsstorm on 6/3/18.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context mContext;
    private String[] category;
    private int[] id;
    private CallBack mCallBack;

    public interface CallBack{
        void CallItemList(int id,String name);

    }

    public CategoryAdapter(Context mContext, String[] category, int[] id, CallBack callback) {
        this.mContext = mContext;
        this.category = category;
        this.id = id;
        this.mCallBack = callback;
    }

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout,parent,false);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, final int position) {
        final String name = category[position];
        final int image = id[position];
        holder.Image.setImageResource(image);
        holder.Category.setText(name);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallBack.CallItemList(position,category[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return category.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView Category;
        ImageView Image;
        View cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView=itemView;
            Category = (TextView)itemView.findViewById(R.id.grid_text) ;
            Image = (ImageView)itemView.findViewById(R.id.grid_image);
        }

    }
}
