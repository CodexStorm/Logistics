package com.example.codexsstorm.logisticsapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.codexsstorm.logisticsapp.Adapter.CategoryAdapter;
import com.example.codexsstorm.logisticsapp.Other.Data;
import com.example.codexsstorm.logisticsapp.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LogisticsList extends AppCompatActivity {

    GridView grid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics_list);
        Data data = new Data();
       /* SharedPreferences sharedPrefs = LogisticsList.this.getSharedPreferences("YourActivityPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        Set<String> oldSet = sharedPrefs.getStringSet("Category", new HashSet<String>());
        List<String> category = new ArrayList<>();
        category.addAll(oldSet);*/
        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(),data.getCategory(),data.getImageId());
        grid = (GridView)findViewById(R.id.gridview);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(gMaetApplicationContext(),"You have clicked"+ category.get(i), Toast.LENGTH_SHORT).show();
                Intent j = new Intent(getApplicationContext(),ItemList.class);
                startActivity(j);
            }
        });
    }
}
