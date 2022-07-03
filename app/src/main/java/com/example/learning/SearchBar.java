package com.example.learning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.learning.adapter.MyAdapter;

import java.util.ArrayList;

public class SearchBar extends AppCompatActivity {

    MyAdapter adapter;

    RecyclerView recyclerView;


    ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);

        recyclerView=findViewById(R.id.recyclerview);

        arrayList=new ArrayList<>();

        arrayList.add("Janakpur");
        arrayList.add("Dhanusha");
        arrayList.add("Biratnagar");
        arrayList.add("Pokhara");
        arrayList.add("Kathmandu");
        arrayList.add("Delhi");

        adapter=new MyAdapter(arrayList,getApplicationContext());



        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));



        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater=getMenuInflater();

        inflater.inflate(R.menu.menu_item,menu);


        SearchView searchView= (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return true;
            }
        });

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        return true;
    }
}