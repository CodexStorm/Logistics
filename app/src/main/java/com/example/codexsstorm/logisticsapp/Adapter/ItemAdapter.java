package com.example.codexsstorm.logisticsapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.codexsstorm.logisticsapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codexsstorm on 7/3/18.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    List<String> itemList=new ArrayList<>();
    Context context;

    public ItemAdapter(List<String> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String name = itemList.get(position);
        holder.Item.setText(name);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView Item;
        View cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView=itemView;
            Item = (TextView)itemView.findViewById(R.id.grid_text) ;
        }

    }
}
