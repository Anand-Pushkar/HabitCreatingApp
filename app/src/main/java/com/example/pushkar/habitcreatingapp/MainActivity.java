package com.example.pushkar.habitcreatingapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.pushkar.habitcreatingapp.Fragments.Fragment_home;
import com.example.pushkar.habitcreatingapp.Fragments.Fragment_journeys;
import com.example.pushkar.habitcreatingapp.Fragments.Fragment_progress;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new Fragment_home());
    }

    private boolean loadFragment(Fragment fragment){

        if(fragment != null)
        {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }

        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        switch (menuItem.getItemId()){

            case R.id.navigation_home :
                fragment = new Fragment_home();
                break;

            case R.id.navigation_progress :
                fragment = new Fragment_progress();
                break;

            case R.id.navigation_journeys:
                fragment = new Fragment_journeys();
                break;

        }

        return  loadFragment(fragment);
    }
}
