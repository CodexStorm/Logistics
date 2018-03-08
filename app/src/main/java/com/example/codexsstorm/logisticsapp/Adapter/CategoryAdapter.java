package com.example.codexsstorm.logisticsapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

    public CategoryAdapter(Context mContext, String[] category, int[] id) {
        this.mContext = mContext;
        this.category = category;
        this.id = id;
    }

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout,parent,false);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, int position) {
        final String name = category[position];
        final int image = id[position];
        holder.Image.setImageResource(image);
        holder.Category.setText(name);
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
