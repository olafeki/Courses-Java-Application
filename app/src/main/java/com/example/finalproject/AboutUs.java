package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {
    Button facebook, instagram, youtube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        facebook = findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent  = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.facebook.com/mirna.radwan.925"));
                startActivity(browserIntent);
            }
        });

        youtube = findViewById(R.id.youtube);
        youtube.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent  = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.youtube.com/"));
                startActivity(browserIntent);
            }
        });


        instagram = findViewById(R.id.instagram);
        instagram.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent  = new Intent(Intent.ACTION_VIEW , Uri.parse("https://www.instagram.com/"));
                startActivity(browserIntent);
            }
        });

    }
    }

