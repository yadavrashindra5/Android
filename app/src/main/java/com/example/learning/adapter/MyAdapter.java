package com.example.learning.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learning.R;

import java.util.ArrayList;
import java.util.Collection;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {


    ArrayList<String>arrayList;
    Context context;

    ArrayList<String>backup;


    public MyAdapter() {
    }

    public MyAdapter(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        this.backup=new ArrayList<>(arrayList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView.setText(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }


    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<String>filterData=new ArrayList<>();

            if(charSequence.toString().isEmpty())
            {
                filterData.addAll(backup);
            }
            else{
                for(String obj:backup)
                {
                    /*
                    *
                    *
                    * This line only search for items that contains the charsequence
                    *
                    * in contains method it doesn't give correct result
                    * if you change contains method with startsWith() then it will only search the correct result
                    *
                    * */
                    if(obj.toLowerCase().contains(charSequence.toString().toLowerCase()))
                    {
                        filterData.add(obj);
                    }
                }
            }

            FilterResults results=new FilterResults();
            results.values=filterData;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            arrayList.clear();

            arrayList.addAll((ArrayList<String>)filterResults.values);
            notifyDataSetChanged();

        }
    };


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.cityname);
        }
    }

}
