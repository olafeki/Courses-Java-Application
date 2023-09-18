package com.example.finalproject;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class search extends AppCompatActivity {
    RecyclerView recyclerView;
    //FloatingActionButton add_button;
    SearchView searchview;
    //  private SearchView searchview;
    DbHelper my_db;
    //ArrayList<String> course_title, course_id, url, price, level, Rating, subject;
    CustomAdapter customeradapter;
    ArrayList<progsample> patientList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        my_db = new DbHelper(this);

       // ArrayList<progsample> patientList = new ArrayList<>();
        /*
        course_id = new ArrayList<>();
        course_title = new ArrayList<>();
        url = new ArrayList<>();
        price = new ArrayList<>();
        level = new ArrayList<>();
        Rating = new ArrayList<>();
        subject = new ArrayList<>();*/
        recyclerView = findViewById(R.id.recyclerView);

        searchview=findViewById(R.id.searchview);
        searchview.clearFocus();
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }


        });



        customeradapter = new CustomAdapter(search.this, patientList);
        recyclerView.setAdapter(customeradapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(search.this));
        storedatainarray();
        setUpRecyclerView();
    }

    private void filterList(String text) {
        List<progsample> filteredList = new ArrayList<>();
        for(progsample item : patientList ){
            if(item.getCourse_title().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }

        }
        if(filteredList.isEmpty()){
            Toast.makeText(this, "NO DATA FOUND ", Toast.LENGTH_SHORT).show();
        }
        else {
            customeradapter.setfilteredlist(filteredList);

        }

    }

    private void setUpRecyclerView() {

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customeradapter);
    }
   /*public boolean onCreateOptionsMenu(Menu menu) {
        // below line is to get our inflater
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.example_menu, menu);

       MenuItem searchItem = menu.findItem(R.id.action_search);
       SearchView searchView = (SearchView) searchItem.getActionView();
       searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               // inside on query text change method we are
               // calling a method to filter our recycler view.
               customeradapter.getFilter().filter(newText);
               return false;
           }
       });
       return true;
        }*/
       /*@Override        //U
       public boolean onCreateOptionsMenu(Menu menu)
       {
           getMenuInflater().inflate(R.menu.example_menu, menu);
           MenuItem item = menu.findItem(R.id.action_search);

           SearchView searchView = (SearchView)item.getActionView();
           searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
               @Override
               public boolean onQueryTextSubmit(String query) {
                   return false;
               }

               @Override
               public boolean onQueryTextChange(String newText) {
                   customeradapter.getFilter().filter(newText);
                   return false;
               }
           });

           return  super.onCreateOptionsMenu(menu);
       }*/


    void storedatainarray() {
        Cursor cursor = my_db.readalldata();

            if (cursor.getCount() == 0) {
                Toast.makeText(this, "no data.", Toast.LENGTH_SHORT).show();
                return;
            }
            else {
                while (cursor.moveToNext()) {
                    //ArrayList<progsample> patientList=new ArrayList<>();
                    patientList.add(new progsample(cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(3),
                            cursor.getString(7),
                            cursor.getString(8),
                            cursor.getString(11)));
/*
                    course_id.add(cursor.getString(0));
                    course_title.add(cursor.getString(1));
                    url.add(cursor.getString(2));
                    price.add(cursor.getString(3));
                    level.add(cursor.getString(7));
                    Rating.add(cursor.getString(8));
                    subject.add(cursor.getString(11));*/

                }
            }
            cursor.close();
        }


}
