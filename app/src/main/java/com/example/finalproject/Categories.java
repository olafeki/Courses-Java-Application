package com.example.finalproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Categories extends AppCompatActivity {

    DbHelper my_db;
    Button back,play1,play2,play3,play4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        my_db = new DbHelper(this);

        back= (Button) findViewById(R.id.back);
        play1= (Button) findViewById(R.id.play1);
        play2= (Button) findViewById(R.id.play2);
        play3= (Button) findViewById(R.id.play3);
        play4= (Button) findViewById(R.id.play4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Categories.this, HomeActivity.class);
                startActivity(i);
            }
        });
        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Categories.this, webprog.class);
                startActivity(i);
            }
        });
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Categories.this, Business.class);
                startActivity(i);
            }
        });
        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Categories.this, GraphicDesign.class);
                startActivity(i);
            }
        });
        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Categories.this, music.class);
                startActivity(i);
            }
        });
    }
}

