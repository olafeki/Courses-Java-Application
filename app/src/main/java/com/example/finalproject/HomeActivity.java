package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    DbHelper my_db;
    ImageButton back;
    //ImageView play = (ImageView)findViewById(R.id.p1);
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        my_db = new DbHelper(this);
        ImageButton btn1 = (ImageButton)findViewById(R.id.imageButton);
        ImageButton search =(ImageButton) findViewById(R.id.imageButton2);
        back= (ImageButton) findViewById(R.id.back2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, welcomescreen.class);
                startActivity(i);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,search.class);
                startActivity(i);
            }
        });
        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case  R.id.nav_home:

                        Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                        startActivity(intent);
                        break;

                    case  R.id.nav_Profile:

                        Intent intentp = new Intent(HomeActivity.this, profile.class);
                        startActivity(intentp);
                        break;

                    case  R.id.nav_About:

                        Intent intenta = new Intent(HomeActivity.this, AboutUs.class);
                        startActivity(intenta);
                        break;

//Paste your privacy policy link

                    case  R.id.nav_Policy:{
                        Intent browserIntent  = new Intent(Intent.ACTION_VIEW , Uri.parse("https://policies.google.com/privacy?hl=en-US"));
                        startActivity(browserIntent);
                    }
                    break;
                    case  R.id.nav_logout:{
                        Intent intentl = new Intent(HomeActivity.this, welcomescreen.class);
                        startActivity(intentl);
                    }
                    break;

                }
                return false;
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,Courseinfo.class);
                startActivity(i);
                try {
                    readprogdata();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    readbuisdata();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    readdesdata();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    readmusdata();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        ImageButton btn2 = (ImageButton)findViewById(R.id.imageButton4);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,Categories.class);
                startActivity(i);
            }
        });


    }
    private List<progsample> progsamples=new ArrayList<>();
    private void readprogdata() throws IOException {
        InputStream is = getResources().openRawResource(R.raw.prog);
        BufferedReader reader=new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line="" ;
        try {
            reader.readLine();
            while((line= reader.readLine())!= null) {
                Log.d("My ACtivity","line"+line);
                //split by ,
                String[] tokens=line.split(",");
                //read the data
                progsample sample = new progsample();
                sample.setCourse_id(Integer.parseInt(tokens[0]));
                sample.setCourse_title(tokens[1]);
                sample.setUrl(tokens[2]);
                sample.setPrice(Integer.parseInt(tokens[3]));
                sample.setNum_subscribers(Integer.parseInt(tokens[4]));
                sample.setNum_reviews(Integer.parseInt(tokens[5]));
                sample.setNum_lectures(Integer.parseInt(tokens[6]));
                sample.setLevel(tokens[7]);
                sample.setRating(Double.parseDouble(tokens[8]));
                sample.setContent_duration(Double.parseDouble(tokens[9]));
                sample.setPublished_timestamp(tokens[10]);
                sample.setSubject(tokens[11]);
                progsamples.add(sample);
                Log.d("My activity","just created"+ sample);
                if(sample!= null ){
                    my_db.inserttodb(sample.getCourse_title(),sample.getUrl(),sample.getPrice(),sample.getNum_subscribers(),
                            sample.getNum_reviews(),sample.getNum_lectures(),sample.getLevel(),sample.getRating(),
                            sample.getContent_duration(),sample.getPublished_timestamp(),sample.getSubject());
                }


            }

        } catch (IOException e) {
            Log.v("My activity","error reading data file on line"+ line,e);
            e.printStackTrace();
        }



    }

    private List<progsample> progsamples2=new ArrayList<>();
    private void readbuisdata() throws IOException {
        InputStream is = getResources().openRawResource(R.raw.buisness);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                Log.d("My ACtivity", "line" + line);
                //split by ,
                String[] tokens = line.split(",");
                //read the data
                progsample sample = new progsample();
                sample.setCourse_id(Integer.parseInt(tokens[0]));
                sample.setCourse_title(tokens[1]);
                sample.setUrl(tokens[2]);
                sample.setPrice(Integer.parseInt(tokens[3]));
                sample.setNum_subscribers(Integer.parseInt(tokens[4]));
                sample.setNum_reviews(Integer.parseInt(tokens[5]));
                sample.setNum_lectures(Integer.parseInt(tokens[6]));
                sample.setLevel(tokens[7]);
                sample.setRating(Double.parseDouble(tokens[8]));
                sample.setContent_duration(Double.parseDouble(tokens[9]));
                sample.setPublished_timestamp(tokens[10]);
                sample.setSubject(tokens[11]);
                progsamples2.add(sample);
                Log.d("My activity", "just created" + sample);
                if (sample != null) {
                    my_db.inserttodb2(sample.getCourse_title(), sample.getUrl(), sample.getPrice(), sample.getNum_subscribers(),
                            sample.getNum_reviews(), sample.getNum_lectures(), sample.getLevel(), sample.getRating(),
                            sample.getContent_duration(), sample.getPublished_timestamp(), sample.getSubject());
                }


            }

        } catch (IOException e) {
            Log.v("My activity", "error reading data file on line" + line, e);
            e.printStackTrace();
        }
    }

    private List<progsample> progsamples3=new ArrayList<>();
    private void readdesdata() throws IOException {
        InputStream is = getResources().openRawResource(R.raw.design);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                Log.d("My ACtivity", "line" + line);
                //split by ,
                String[] tokens = line.split(",");
                //read the data
                progsample sample = new progsample();
                sample.setCourse_id(Integer.parseInt(tokens[0]));
                sample.setCourse_title(tokens[1]);
                sample.setUrl(tokens[2]);
                sample.setPrice(Integer.parseInt(tokens[3]));
                sample.setNum_subscribers(Integer.parseInt(tokens[4]));
                sample.setNum_reviews(Integer.parseInt(tokens[5]));
                sample.setNum_lectures(Integer.parseInt(tokens[6]));
                sample.setLevel(tokens[7]);
                sample.setRating(Double.parseDouble(tokens[8]));
                sample.setContent_duration(Double.parseDouble(tokens[9]));
                sample.setPublished_timestamp(tokens[10]);
                sample.setSubject(tokens[11]);
                progsamples3.add(sample);
                Log.d("My activity", "just created" + sample);
                if (sample != null) {
                    my_db.inserttodb3(sample.getCourse_title(), sample.getUrl(), sample.getPrice(), sample.getNum_subscribers(),
                            sample.getNum_reviews(), sample.getNum_lectures(), sample.getLevel(), sample.getRating(),
                            sample.getContent_duration(), sample.getPublished_timestamp(), sample.getSubject());
                }


            }

        } catch (IOException e) {
            Log.v("My activity", "error reading data file on line" + line, e);
            e.printStackTrace();
        }
    }

    private List<progsample> progsamples4=new ArrayList<>();
    private void readmusdata() throws IOException {
        InputStream is = getResources().openRawResource(R.raw.music);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                Log.d("My ACtivity", "line" + line);
                //split by ,
                String[] tokens = line.split(",");
                //read the data
                progsample sample = new progsample();
                sample.setCourse_id(Integer.parseInt(tokens[0]));
                sample.setCourse_title(tokens[1]);
                sample.setUrl(tokens[2]);
                sample.setPrice(Integer.parseInt(tokens[3]));
                sample.setNum_subscribers(Integer.parseInt(tokens[4]));
                sample.setNum_reviews(Integer.parseInt(tokens[5]));
                sample.setNum_lectures(Integer.parseInt(tokens[6]));
                sample.setLevel(tokens[7]);
                sample.setRating(Double.parseDouble(tokens[8]));
                sample.setContent_duration(Double.parseDouble(tokens[9]));
                sample.setPublished_timestamp(tokens[10]);
                sample.setSubject(tokens[11]);
                progsamples4.add(sample);
                Log.d("My activity", "just created" + sample);
                if (sample != null) {
                    my_db.inserttodb4(sample.getCourse_title(), sample.getUrl(), sample.getPrice(), sample.getNum_subscribers(),
                            sample.getNum_reviews(), sample.getNum_lectures(), sample.getLevel(), sample.getRating(),
                            sample.getContent_duration(), sample.getPublished_timestamp(), sample.getSubject());
                }


            }

        } catch (IOException e) {
            Log.v("My activity", "error reading data file on line" + line, e);
            e.printStackTrace();
        }
    }
    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    }

