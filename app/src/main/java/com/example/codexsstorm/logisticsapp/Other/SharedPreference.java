package com.example.codexsstorm.logisticsapp.Other;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.codexsstorm.logisticsapp.Activity.Login;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by codexsstorm on 9/3/18.
 */

public class SharedPreference {
    public void store(Context context){
        Data d = new Data();
        SharedPreferences settings = context.getSharedPreferences("YourActivityPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Set<String> Category = settings.getStringSet("Tools", new HashSet<String>());
        Category.addAll(d.getTools());
        editor.putStringSet("Tools", Category);
        editor.putInt("Stored",1);
        editor.commit();
    }
}
