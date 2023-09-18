package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class music extends AppCompatActivity {

    RecyclerView recyclerView;
    //FloatingActionButton add_button;
    private SearchView searchview;
    DbHelper my_db;
    //ArrayList<String> course_title, course_id, url, price, level, Rating, subject;
    CustomAdapter customeradapter;
    ArrayList<progsample> patientList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        my_db = new DbHelper(this);
        /*course_id = new ArrayList<>();
        course_title = new ArrayList<>();
        url = new ArrayList<>();
        price = new ArrayList<>();
        level = new ArrayList<>();
        Rating = new ArrayList<>();
        subject = new ArrayList<>();*/
        recyclerView = findViewById(R.id.recyclerView);


        customeradapter = new CustomAdapter(music.this, patientList);
        recyclerView.setAdapter(customeradapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(music.this));
        storedatainarray();
    }
    /*public boolean onCreateOptionsMenu(Menu menu) {
        // below line is to get our inflater
        MenuInflater inflater = getMenuInflater();

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.main_menu, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.action_search);

        // getting search view of our item.
        SearchView searchView = (SearchView) searchItem.getActionView();

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<String> filteredlist = new ArrayList<String>();

        // running a for loop to compare elements.
        for (String item : course_title) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            filteringList(filteredlist);
        }
    }*/


    void storedatainarray() {
        Cursor cursor = my_db.readmusicdata();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "no data.", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()) {
                patientList.add(new progsample(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(3),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(11)));

            }
        }
        cursor.close();
    }


}

