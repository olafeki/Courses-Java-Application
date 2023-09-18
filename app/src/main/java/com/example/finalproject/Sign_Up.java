package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;


import java.util.jar.Attributes;

public class Sign_Up extends AppCompatActivity {
    DbHelper my_db;
    EditText Name;
    EditText Surname;
    EditText Password;
    Button signup;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        my_db = new DbHelper(this );


        Name = (EditText)  findViewById(R.id.namee);
        Surname = (EditText)  findViewById(R.id.surname);
        Password = (EditText)  findViewById(R.id.password);
        signup = (Button)  findViewById(R.id.register);
        adddata();


    }


    public void loginactivityView(){
        Intent intent = new Intent(this,Sign_In.class);
        startActivity(intent);
    }
    public void homeactivityView(){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
    public void adddata(){
        signup.setOnClickListener(v -> {
            boolean isinserted = my_db.insertdata(Name.getText().toString(),Surname.getText().toString(),Password.getText().toString());
            if(isinserted) {
                Toast.makeText(Sign_Up.this, "inserted", Toast.LENGTH_LONG).show();
                homeactivityView();
            }
            else
                Toast.makeText(Sign_Up.this,"not inserted, Try Again",Toast.LENGTH_LONG).show();


        });
    }
}