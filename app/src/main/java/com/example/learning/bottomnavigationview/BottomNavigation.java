package com.example.learning.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.learning.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        bottomNavigation=findViewById(R.id.bottomnav);

        load(new FirstFragment());

        bottomNavigation.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment=null;

        switch (item.getItemId())
        {
            case R.id.first:
                fragment=new FirstFragment();
                break;
            case R.id.second:
                fragment=new SecondFragment();
                break;
            case R.id.third:
                fragment=new ThirdFragment();
                break;
        }

        return load(fragment);
    }

    private boolean load(Fragment fragment) {

        if(fragment!=null)
        {
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentcontainer,fragment,null).commit();
        }
        return true;
    }

    @Override
    public void onBackPressed() {


        if(bottomNavigation.getSelectedItemId()==R.id.first)
        {
            super.onBackPressed();
            finish();
        }
        else{
            bottomNavigation.setSelectedItemId(R.id.first);
        }

    }
}