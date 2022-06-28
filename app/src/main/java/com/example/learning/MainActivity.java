package com.example.learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.learning.adapter.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyAdapter adapter;

    RecyclerView recyclerView;


    ArrayList<String>arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);

        arrayList=new ArrayList<>();

        arrayList.add("Janakpur");
        arrayList.add("Dhanusha");
        arrayList.add("Biratnagar");
        arrayList.add("Pokhara");
        arrayList.add("Kathmandu");
        arrayList.add("Delhi");

        adapter=new MyAdapter(arrayList,getApplicationContext());



        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        recyclerView.setAdapter(adapter);

    }
}