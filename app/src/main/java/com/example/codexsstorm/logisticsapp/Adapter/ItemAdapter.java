package com.example.codexsstorm.logisticsapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.codexsstorm.logisticsapp.R;

import java.util.List;

/**
 * Created by codexsstorm on 7/3/18.
 */

public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private final List Item;

    public ItemAdapter(Context mContext, List<String> item) {
        this.mContext = mContext;
        Item = item;
    }

    @Override
    public int getCount() {
        int length = Item.size();
        return length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null){
            grid = new View(mContext);
            Log.d("qwerIndex",i+"");
            Log.d("qwerName",Item.get(i).toString()+"");
            grid = inflater.inflate(R.layout.item_layout,null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            textView.setText(Item.get(i).toString());
        }else {
            grid = (View)view;
        }
        return grid;
    }
}
