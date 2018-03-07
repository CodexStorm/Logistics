package com.example.codexsstorm.logisticsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.codexsstorm.logisticsapp.R;

/**
 * Created by codexsstorm on 6/3/18.
 */

public class CategoryAdapter extends BaseAdapter {

    private Context mContext;
    private final String[] Category;
    private final int[] Imageid;

    public CategoryAdapter(Context mContext, String[] category, int[] imageid) {
        this.mContext = mContext;
        Category = category;
        Imageid = imageid;
    }

    @Override
    public int getCount() {
        int length = Category.length;
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
            grid = inflater.inflate(R.layout.grid_layout,null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(Category[i]);
            imageView.setImageResource(Imageid[i]);
        }else {
            grid = (View)view;
        }
        return grid;
    }
}
