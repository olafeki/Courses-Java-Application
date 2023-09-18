package com.example.finalproject;

import static android.view.LayoutInflater.from;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> implements Filterable {
    private Context context;
   /* private ArrayList course_id;
    private ArrayList course_title;
    private ArrayList url;
    private ArrayList price;
    private ArrayList level;
    private ArrayList rating;
    private ArrayList subject;*/

    private  List<progsample> patientList = new ArrayList<>();      //U
    private List<progsample> patientListAll = new ArrayList<>();

    CustomAdapter(Context context ,/* ArrayList course_id,ArrayList course_title,
                  ArrayList url,ArrayList price,
                  ArrayList level,ArrayList rating,
                  ArrayList subject,*/
                  ArrayList<progsample> patientList){
        this.context=context;
        /*
        this.course_id=course_id;
        this.course_title=course_title;
        this.url=url;
        this.price=price;
        this.level=level;
        this.rating=rating;
        this.subject=subject;*/

        this.patientList = patientList;   //U
        this.patientListAll = new ArrayList<>(patientList);


    }
    public void setfilteredlist(List<progsample> filteredlist){
        this.patientList=filteredlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    //CustomAdapter.
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    //CustomAdapter.
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        /*
           holder.course_id.setText(String.valueOf(course_id.get(position)));
           holder.course_title.setText(String.valueOf(course_title.get(position)));
//           holder.url.setText(String.valueOf(url.get(position)));
           holder.price.setText(String.valueOf(price.get(position)));
           holder.level.setText(String.valueOf(level.get(position)));
           holder.rating.setText(String.valueOf(rating.get(position)));
           holder.subject.setText(String.valueOf(subject.get(position)));*/

        progsample plist =  patientList.get(position);
        //U
         holder.course_id.setText(String.valueOf(plist.getCourse_id()));
        holder.course_title.setText(String.valueOf(plist.getCourse_title()));
//           holder.url.setText(String.valueOf(url.get(position)));
        holder.price.setText(String.valueOf(plist.getPrice()));
        holder.level.setText(String.valueOf(plist.getLevel()));
        holder.rating.setText(String.valueOf(plist.getRating()));
        holder.subject.setText(String.valueOf(plist.getSubject()));

    }

    @Override
    public int getItemCount() {
        //return course_id.size();
        return patientList.size();
    }
    //implement the interface filterable method getfilter

    public  Filter getFilter() {
        return filter;
    }
    //U
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constaint) {

            List<progsample> filteredList = new ArrayList<>();

            if (constaint.toString().isEmpty()) {
                filteredList.addAll(patientListAll);
            } else {
                for (progsample patient : patientListAll) {
                    if (patient.getCourse_title().toLowerCase().contains(constaint.toString().toLowerCase())) {
                        filteredList.add(patient);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
            patientList.clear();
            patientList.addAll((Collection<? extends progsample>) filterResults.values);
            notifyDataSetChanged();
        }
    };


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView course_id,course_title,url , price,level,rating,subject;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            course_id =itemView.findViewById(R.id.courseid);
            course_title =itemView.findViewById(R.id.coursetitle);
           // url=itemView.findViewById(R.id.url);
            price=itemView.findViewById(R.id.price);
            level=itemView.findViewById(R.id.level);
            rating=itemView.findViewById(R.id.rating);
            subject=itemView.findViewById(R.id.subject);
        }
    }
}
