package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Sign_In extends AppCompatActivity {
    DbHelper my_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        my_db = new DbHelper(this );

        EditText NAME =(EditText) findViewById(R.id.na);
        EditText PASS =(EditText) findViewById(R.id.pass);
        Button LOGIN =(Button) findViewById(R.id.login);
        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = NAME.getText().toString();
                String password = PASS.getText().toString();
                int in = Integer.parseInt(password);
                User user = new User(in,username);
                SessionManagement sessionManagement = new SessionManagement(Sign_In.this);
                sessionManagement.saveSession(user);
                if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password) ){
                    Toast.makeText(Sign_In.this,"all fields required",Toast.LENGTH_LONG).show();
                }
                else{
                    boolean checkuserdata = my_db.checkusernamepaassword(username,password);
                    if(checkuserdata == true)
                    {
                        Toast.makeText(Sign_In.this,"login sucessfully",Toast.LENGTH_LONG).show();
                        homeactivityView();
                    }
                    else
                    {
                        Toast.makeText(Sign_In.this,"fail to login ",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }
    public void homeactivityView(){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

}