package com.example.codexsstorm.logisticsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private String Name;
    private String Password;

    private EditText etName;
    private EditText etPassword;
    private Button bProceed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = (EditText)findViewById(R.id.etFullName);
        etPassword = (EditText)findViewById(R.id.etPassword);
        bProceed = (Button)findViewById(R.id.bProceed);
        bProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().trim().length()==0){
                    etName.setError("Username is not entered");
                    etName.requestFocus();
                }
                else if(etPassword.getText().toString().trim().length()==0){
                    etPassword.setError("Password is not entered");
                    etPassword.requestFocus();
                }
                else{
                    Name = etName.getText().toString();
                    Password = etPassword.getText().toString();
                }
            }
        });
    }
}
