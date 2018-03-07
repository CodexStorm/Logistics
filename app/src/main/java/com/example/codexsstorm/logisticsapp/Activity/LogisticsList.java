package com.example.codexsstorm.logisticsapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.codexsstorm.logisticsapp.Adapter.CategoryAdapter;
import com.example.codexsstorm.logisticsapp.Other.Data;
import com.example.codexsstorm.logisticsapp.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LogisticsList extends AppCompatActivity {

    GridView grid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics_list);
        Data data = new Data();
        final String[] category = data.getCategory();
        int[] image = data.getImageId();

        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(),category,image);
        grid = (GridView)findViewById(R.id.gridview);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"You have clicked"+category[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
