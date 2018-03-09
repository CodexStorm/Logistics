package com.example.codexsstorm.logisticsapp.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.codexsstorm.logisticsapp.Adapter.ItemAdapter;
import com.example.codexsstorm.logisticsapp.Other.CommonFunction;
import com.example.codexsstorm.logisticsapp.Other.SharedPreference;
import com.example.codexsstorm.logisticsapp.R;

import java.util.ArrayList;
import java.util.List;

public class ItemList extends AppCompatActivity {

    AlertDialog alertDialog = null;
    RecyclerView recyclerView;
    ItemAdapter adapter;
    RelativeLayout addItem;
    SharedPreference sharedPreferences;
    CommonFunction commonFunction;
    List<String> Items;
    List<Integer> ItemsQuantity;
    String cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        Bundle b = getIntent().getExtras();
        commonFunction = new CommonFunction();
        sharedPreferences = new SharedPreference();
        cat = b.getString("Category");
        addItem = (RelativeLayout)findViewById(R.id.rladd);
        /*Items = new ArrayList<String>();
        Items = commonFunction.getItemList(ItemList.this,cat);
        ItemsQuantity = new ArrayList<Integer>();
        ItemsQuantity = commonFunction.getItemQuantity(ItemList.this,cat+"Q");*/
        recyclerView=(RecyclerView)findViewById(R.id.rvItems);
        LinearLayoutManager manager=new LinearLayoutManager(ItemList.this);
        recyclerView.setLayoutManager(manager);
        adapter = new ItemAdapter(commonFunction.getItemList(ItemList.this,cat),commonFunction.getItemQuantity(ItemList.this,cat+"Q"), ItemList.this);
        recyclerView.hasFixedSize();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                final View alertLayout = inflater.inflate(R.layout.alert_dialogue_add, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ItemList.this, R.style.AlertDialogBackground);
                alertDialogBuilder
                        .setView(alertLayout)
                        .setTitle("Add Item")
                        .setCancelable(true)
                        .setPositiveButton("Add",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        EditText ItemName = (EditText)alertLayout.findViewById(R.id.itemName);
                                        String iName = ItemName.getText().toString();
                                        EditText ItemQuantity = (EditText)alertLayout.findViewById(R.id.itemQuantity);
                                        String iQuantity = ItemQuantity.getText().toString();
                                        sharedPreferences.add(ItemList.this,cat,iName,iQuantity);
                                        adapter = new ItemAdapter(commonFunction.getItemList(ItemList.this,cat),commonFunction.getItemQuantity(ItemList.this,cat+"Q"), ItemList.this);
                                        recyclerView.hasFixedSize();
                                        adapter.notifyDataSetChanged();
                                        recyclerView.setAdapter(adapter);
                                        alertDialog.dismiss();
                                    }
                                })
                        .setNegativeButton("Back",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        alertDialog.dismiss();
                                    }
                                });
                alertDialog = alertDialogBuilder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
                alertDialog.show();
            }
        });

    }

    public void deleteItem(final int position){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ItemList.this, R.style.AlertDialogBackground);
        alertDialogBuilder
                .setTitle("Delete Item")
                .setMessage("Are you sure you want to delete this item ? ")
                .setCancelable(true)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                sharedPreferences.delete(ItemList.this,cat,position);
                                adapter = new ItemAdapter(commonFunction.getItemList(ItemList.this,cat),commonFunction.getItemQuantity(ItemList.this,cat+"Q"), ItemList.this);
                                recyclerView.hasFixedSize();
                                adapter.notifyDataSetChanged();
                                recyclerView.setAdapter(adapter);
                                alertDialog.dismiss();
                            }
                        })
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                alertDialog.dismiss();
                            }
                        });
        alertDialog = alertDialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        alertDialog.show();
    }

    public void editItem(final String name, final int quantity, final int position){
        LayoutInflater inflater = getLayoutInflater();
        final View alertLayout = inflater.inflate(R.layout.alert_dialogue_edit, null);
        TextView tvQuantity = (TextView)alertLayout.findViewById(R.id.tvQuantity);
        tvQuantity.setText("Available Quanitity : "+quantity+"");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ItemList.this, R.style.AlertDialogBackground);
        alertDialogBuilder
                .setView(alertLayout)
                .setTitle("Edit Quantity")
                .setCancelable(true)
                .setPositiveButton("Add",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                EditText ItemQuantity = (EditText) alertLayout.findViewById(R.id.itemQuantity);
                                String EditQuantity = ItemQuantity.getText().toString();
                                if (EditQuantity.isEmpty()) {
                                    Toast.makeText(ItemList.this, "Invalid", Toast.LENGTH_SHORT).show();
                                } else {
                                    int quant = quantity + Integer.parseInt(EditQuantity);
                                    sharedPreferences.edit(ItemList.this, cat, name, quant, position);
                                    adapter = new ItemAdapter(commonFunction.getItemList(ItemList.this, cat), commonFunction.getItemQuantity(ItemList.this, cat + "Q"), ItemList.this);
                                    recyclerView.hasFixedSize();
                                    adapter.notifyDataSetChanged();
                                    recyclerView.setAdapter(adapter);
                                    alertDialog.dismiss();
                                }
                            }
                        })
                .setNegativeButton("Remove",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                EditText ItemQuantity = (EditText) alertLayout.findViewById(R.id.itemQuantity);
                                String EditQuantity = ItemQuantity.getText().toString();
                                if (EditQuantity.isEmpty()) {
                                    Toast.makeText(ItemList.this, "Invalid", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (quantity > Integer.parseInt(EditQuantity)) {
                                        int quant = quantity - Integer.parseInt(EditQuantity);
                                        sharedPreferences.edit(ItemList.this, cat, name, quant, position);
                                        adapter = new ItemAdapter(commonFunction.getItemList(ItemList.this, cat), commonFunction.getItemQuantity(ItemList.this, cat + "Q"), ItemList.this);
                                        recyclerView.hasFixedSize();
                                        adapter.notifyDataSetChanged();
                                        recyclerView.setAdapter(adapter);
                                        alertDialog.dismiss();
                                    } else
                                        Toast.makeText(ItemList.this, "Unavailable", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
        alertDialog = alertDialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        alertDialog.show();
    }

}
