package com.example.codexsstorm.logisticsapp.Other;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.ContextThemeWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by codexsstorm on 9/3/18.
 */

public class CommonFunction {
    public List getItemList(Context context,String category){
        SharedPreferences settings = context.getSharedPreferences("YourActivityPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String listString = settings.getString(category,"");
        StringTokenizer stringTokenizer = new StringTokenizer(listString,",");
        ArrayList<String> list = new ArrayList<String>();
        while (stringTokenizer.hasMoreTokens()){
            list.add(stringTokenizer.nextToken());
        }
        return list;
    }

    public List getItemQuantity(Context context,String categoryQ){
        SharedPreferences settings = context.getSharedPreferences("YourActivityPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String listString = settings.getString(categoryQ,"");
        StringTokenizer stringTokenizer = new StringTokenizer(listString,",");
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (stringTokenizer.hasMoreTokens()){
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        return list;
    }
}
