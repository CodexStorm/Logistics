package com.example.codexsstorm.logisticsapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.codexsstorm.logisticsapp.Other.Data;
import com.example.codexsstorm.logisticsapp.Other.SharedPreference;
import com.example.codexsstorm.logisticsapp.R;

import java.util.HashSet;
import java.util.Set;

public class Login extends AppCompatActivity {

    private String Name;
    private String Password;

    private EditText etName;
    private EditText etPassword;
    private Button bProceed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button click;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        click = (Button)findViewById(R.id.user_profile_photo);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = Login.this.getSharedPreferences("YourActivityPreferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();

                int flag = settings.getInt("Stored", 0);
                if(flag == 0){
                    SharedPreference s = new SharedPreference();
                    s.store(Login.this);
                    editor.putInt("Stored",1);
                    Intent i = new Intent(getApplicationContext(),LogisticsList.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(getApplicationContext(),LogisticsList.class);
                    startActivity(i);
                }
            }
        });

    }
}
