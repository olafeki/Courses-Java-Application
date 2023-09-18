package com.example.finalproject;

import static java.lang.Integer.parseInt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME ="project.db" ;
    public static final String TABLE_NAME ="USERS" ;
    public static final String id_1 ="ID" ;
    public static final String name_2 ="NAME" ;
    public static final String surname_3 ="SURNAME" ;
    public static final String password_4 ="PASSWORD" ;

    public static final String TABLE_NAME3 ="programming" ;
    public static final String coursep_id= ("prog_id");
    public static final String coursep_title="PROG_TITLE";
    public static final String coursep_url="PROG_URL" ;
    public static final String coursep_price = ("prog_price");
    public static final String coursep_num_subscribers= ("prog_num_subscribers");
    public static final String coursep_num_reviews= ("prog_num_reviews");
    public static final String coursep_num_lectures= ("prog_num_lectures");
    public static final String coursep_level="prog_level";
    public static final String coursep_Rating=("prog_rating");
    public static final String coursep_content_duration=("prog_duration");;
    public static final String coursep_published_timestamp="prog_time_published";
    public static final String coursep_subject="prog_subject";

    public static final String TABLE_NAME4 ="buisness" ;
    public static final String courseb_id= ("buis_id");
    public static final String courseb_title="buis_TITLE";
    public static final String courseb_url="buis_URL" ;
    public static final String courseb_price = ("buis_price");
    public static final String courseb_num_subscribers= ("buis_num_subscribers");
    public static final String courseb_num_reviews= ("buis_num_reviews");
    public static final String courseb_num_lectures= ("buis_num_lectures");
    public static final String courseb_level="buis_level";
    public static final String courseb_Rating=("buis_rating");
    public static final String courseb_content_duration=("buis_duration");;
    public static final String courseb_published_timestamp="buis_time_published";
    public static final String courseb_subject="buis_subject";

    public static final String TABLE_NAME5 ="design" ;
    public static final String coursed_id= ("des_id");
    public static final String coursed_title="des_TITLE";
    public static final String coursed_url="des_URL" ;
    public static final String coursed_price = ("des_price");
    public static final String coursed_num_subscribers= ("des_num_subscribers");
    public static final String coursed_num_reviews= ("des_num_reviews");
    public static final String coursed_num_lectures= ("des_num_lectures");
    public static final String coursed_level="des_level";
    public static final String coursed_Rating=("des_rating");
    public static final String coursed_content_duration=("des_duration");;
    public static final String coursed_published_timestamp="des_time_published";
    public static final String coursed_subject="des_subject";


    public static final String TABLE_NAME6 ="music" ;
    public static final String coursem_id= ("mus_id");
    public static final String coursem_title="mus_TITLE";
    public static final String coursem_url="mus_URL" ;
    public static final String coursem_price = ("mus_price");
    public static final String coursem_num_subscribers= ("mus_num_subscribers");
    public static final String coursem_num_reviews= ("mus_num_reviews");
    public static final String coursem_num_lectures= ("mus_num_lectures");
    public static final String coursem_level="mus_level";
    public static final String coursem_Rating=("mus_rating");
    public static final String coursem_content_duration=("mus_duration");;
    public static final String coursem_published_timestamp="mus_time_published";
    public static final String coursem_subject="mus_subject";




    public DbHelper(@Nullable Context context) {
        super(context,DB_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME STRING , SURNAME STRING , PASSWORD INTEGER)");

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME3+" (prog_id INTEGER PRIMARY KEY  AUTOINCREMENT ,  PROG_TITLE TEXT , PROG_URL TEXT , prog_price TEXT,prog_num_subscribers TEXT,prog_num_reviews TEXT,prog_num_lectures TEXT,prog_level TEXT,prog_rating TEXT,prog_duration TEXT,prog_time_published TEXT,prog_subject TEXT )");

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME4+" (buis_id INTEGER PRIMARY KEY  AUTOINCREMENT ,  buis_TITLE TEXT , buis_URL TEXT , buis_price TEXT,buis_num_subscribers TEXT,buis_num_reviews TEXT,buis_num_lectures TEXT,buis_level TEXT,buis_rating TEXT,buis_duration TEXT,buis_time_published TEXT,buis_subject TEXT )");

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME5+" (des_id INTEGER PRIMARY KEY  AUTOINCREMENT ,  des_TITLE TEXT , des_URL TEXT , des_price TEXT,des_num_subscribers TEXT,des_num_reviews TEXT,des_num_lectures TEXT,des_level TEXT,des_rating TEXT,des_duration TEXT,des_time_published TEXT,des_subject TEXT )");

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME6+" (mus_id INTEGER PRIMARY KEY  AUTOINCREMENT ,  mus_TITLE TEXT , mus_URL TEXT , mus_price TEXT,mus_num_subscribers TEXT,mus_num_reviews TEXT,mus_num_lectures TEXT,mus_level TEXT,mus_rating TEXT,mus_duration TEXT,mus_time_published TEXT,mus_subject TEXT )");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS " +TABLE_NAME);
        sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS " +TABLE_NAME3);
        sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS " +TABLE_NAME4);
        sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS " +TABLE_NAME5);
        sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS " +TABLE_NAME6);


        onCreate(sqLiteDatabase);
    }
    public void inserttodb(String title, String url,String price
            ,String num_subscribers,String num_reviews,String num_lectures
            ,String level,String rating,String duration , String time_published ,String subject){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put(coursep_id,id);
        cv.put(coursep_title,title);
        cv.put(coursep_url,url);
        cv.put(coursep_price,price);
        cv.put(coursep_num_subscribers,num_subscribers);
        cv.put(coursep_num_reviews,num_reviews);
        cv.put(coursep_num_lectures,num_lectures);
        cv.put(coursep_level,level);
        cv.put(coursep_Rating,rating);
        cv.put(coursep_content_duration,duration);
        cv.put(coursep_published_timestamp,time_published);
        cv.put(coursep_subject,subject);
        DB.insert(TABLE_NAME3,null,cv);

    }
    public void inserttodb2(String title, String url,String price
            ,String num_subscribers,String num_reviews,String num_lectures
            ,String level,String rating,String duration , String time_published ,String subject){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put(coursep_id,id);
        cv.put(courseb_title,title);
        cv.put(courseb_url,url);
        cv.put(courseb_price,price);
        cv.put(courseb_num_subscribers,num_subscribers);
        cv.put(courseb_num_reviews,num_reviews);
        cv.put(courseb_num_lectures,num_lectures);
        cv.put(courseb_level,level);
        cv.put(courseb_Rating,rating);
        cv.put(courseb_content_duration,duration);
        cv.put(courseb_published_timestamp,time_published);
        cv.put(courseb_subject,subject);
        DB.insert(TABLE_NAME4,null,cv);

    }

    public void inserttodb3(String title, String url,String price
            ,String num_subscribers,String num_reviews,String num_lectures
            ,String level,String rating,String duration , String time_published ,String subject){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put(coursep_id,id);
        cv.put(coursed_title,title);
        cv.put(coursed_url,url);
        cv.put(coursed_price,price);
        cv.put(coursed_num_subscribers,num_subscribers);
        cv.put(coursed_num_reviews,num_reviews);
        cv.put(coursed_num_lectures,num_lectures);
        cv.put(coursed_level,level);
        cv.put(coursed_Rating,rating);
        cv.put(coursed_content_duration,duration);
        cv.put(coursed_published_timestamp,time_published);
        cv.put(coursed_subject,subject);
        DB.insert(TABLE_NAME5,null,cv);

    }


    public void inserttodb4(String title, String url,String price
            ,String num_subscribers,String num_reviews,String num_lectures
            ,String level,String rating,String duration , String time_published ,String subject){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put(coursep_id,id);
        cv.put(coursem_title,title);
        cv.put(coursem_url,url);
        cv.put(coursem_price,price);
        cv.put(coursem_num_subscribers,num_subscribers);
        cv.put(coursem_num_reviews,num_reviews);
        cv.put(coursem_num_lectures,num_lectures);
        cv.put(coursem_level,level);
        cv.put(coursem_Rating,rating);
        cv.put(coursem_content_duration,duration);
        cv.put(coursem_published_timestamp,time_published);
        cv.put(coursem_subject,subject);
        DB.insert(TABLE_NAME6,null,cv);

    }





    public boolean insertdata(String name, String surname, String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(name_2, name);
        cv.put(surname_3,surname);
        cv.put(password_4, password);
        Long result = DB.insert(TABLE_NAME,null,cv);
        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkusernamepaassword(String username,String password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor check = DB.rawQuery("select * from " +TABLE_NAME+" where " +name_2+" = ? and "+ password_4+" = ?", new String[]{username,password});
        if(check.getCount()>0)
        {
            return true;
        }
        else
            return false ;
    }
    Cursor readalldata(){
      String query =" SELECT  *  FROM "+TABLE_NAME3+" UNION SELECT  *  FROM "+TABLE_NAME4+" UNION SELECT  *  FROM "+TABLE_NAME5+" UNION SELECT  *  FROM "+TABLE_NAME6;
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor cursor =null;
      if(db!=null){
          cursor=db.rawQuery(query,null);
      }
      return cursor;
    }

    Cursor readprogdata(){
        String query =" SELECT  *  FROM "+TABLE_NAME3;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =null;
        if(db!=null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }
    Cursor readbusinessdata(){
        String query =" SELECT  *  FROM "+TABLE_NAME4;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =null;
        if(db!=null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }
    Cursor readgraphdata(){
        String query =" SELECT  *  FROM "+TABLE_NAME5;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =null;
        if(db!=null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }
    Cursor readmusicdata(){
        String query =" SELECT  *  FROM "+TABLE_NAME6;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =null;
        if(db!=null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }

}
