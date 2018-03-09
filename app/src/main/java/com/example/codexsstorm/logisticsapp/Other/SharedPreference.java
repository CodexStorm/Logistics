package com.example.codexsstorm.logisticsapp.Other;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.codexsstorm.logisticsapp.Activity.Login;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by codexsstorm on 9/3/18.
 */

public class SharedPreference {
    public void store(Context context){
        SharedPreferences settings = context.getSharedPreferences("YourActivityPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Tools", Data.getTools());
        editor.putString("ToolsQ", Data.getToolsq());
        editor.putString("Electronics", Data.getElectronics());
        editor.putString("ElectronicsQ", Data.getElctronicsq());
        editor.putString("Stationary", Data.getStationary());
        editor.putString("StationaryQ", Data.getStationaryq());
        editor.putString("Furniture", Data.getFurniture());
        editor.putString("FurnitureQ", Data.getFurnitureq());
        editor.putString("Toys", Data.getToys());
        editor.putString("ToysQ", Data.getToysq());
        editor.putString("Cutlery", Data.getCutlery());
        editor.putString("CutleryQ", Data.getCutleryq());
        editor.putString("Travel", Data.getTravel());
        editor.putString("TravelQ", Data.getTravelq());
        editor.putString("Books", Data.getBooks());
        editor.putString("BooksQ", Data.getBooksq());
        editor.putInt("Stored",1);
        editor.commit();
    }

    public void add(Context context,String category,String item,String quantity){
        SharedPreferences settings = context.getSharedPreferences("YourActivityPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String ItemList = settings.getString(category,"");
        String QuantityList = settings.getString(category+"Q","");
        ItemList = ItemList+","+item;
        QuantityList = QuantityList+","+quantity;
        Log.d("ItemList",ItemList);
        Log.d("QuantityList",QuantityList);
        editor.putString(category,ItemList);
        editor.putString(category+"Q",QuantityList);
        editor.commit();
    }

    public void edit(Context context, String category, String itemName, int itemQuantity, int position){
        SharedPreferences settings = context.getSharedPreferences("YourActivityPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String ItemString = settings.getString(category,"");
        String QuantityString = settings.getString(category+"Q","");
        StringTokenizer ItemToken = new StringTokenizer(ItemString,",");
        StringTokenizer QuantityToken = new StringTokenizer(QuantityString,",");
        ArrayList<String> ItemList = new ArrayList<String>();
        ArrayList<Integer> QuantityList = new ArrayList<Integer>();
        while (ItemToken.hasMoreTokens()) {
            ItemList.add(ItemToken.nextToken());
        }

        while (QuantityToken.hasMoreTokens()){
            QuantityList.add(Integer.parseInt(QuantityToken.nextToken()));
        }

        Log.d("Hello",ItemList.get(position));
        QuantityList.set(position,itemQuantity);

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < QuantityList.size(); i++) {
            str.append(QuantityList.get(i)).append(",");
        }

        editor.putString(category+"Q",str.toString());
        editor.commit();

    }

    public void delete(Context context, String category, int position){
        SharedPreferences settings = context.getSharedPreferences("YourActivityPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        String ItemString = settings.getString(category,"");
        String QuantityString = settings.getString(category+"Q","");
        StringTokenizer ItemToken = new StringTokenizer(ItemString,",");
        StringTokenizer QuantityToken = new StringTokenizer(QuantityString,",");
        ArrayList<String> ItemList = new ArrayList<String>();
        ArrayList<Integer> QuantityList = new ArrayList<Integer>();
        while (ItemToken.hasMoreTokens()) {
            ItemList.add(ItemToken.nextToken());
        }

        while (QuantityToken.hasMoreTokens()){
            QuantityList.add(Integer.parseInt(QuantityToken.nextToken()));
        }

        ItemList.remove(position);
        QuantityList.remove(position);

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < QuantityList.size(); i++) {
            str.append(QuantityList.get(i)).append(",");
        }

        editor.putString(category+"Q",str.toString());

        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < ItemList.size(); i++) {
            str2.append(ItemList.get(i)).append(",");
        }

        editor.putString(category,str2.toString());
        editor.commit();

    }
}
