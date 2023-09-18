package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class profile extends AppCompatActivity {
    Button home,cat,wel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        home= findViewById(R.id.imageView44);
        cat= findViewById(R.id.imageView66);
        wel= findViewById(R.id.imageView3);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(profile.this, HomeActivity.class);
                startActivity(i);
            }
        });
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2= new Intent(profile.this, Categories.class);
                startActivity(i2);
            }
        });
        wel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3= new Intent(profile.this, welcomescreen.class);
                startActivity(i3);
            }
        });


    }
}
