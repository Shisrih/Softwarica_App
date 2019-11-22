package com.example.softwaricaapp;

import android.os.Bundle;

import com.example.softwaricaapp.Model.Students;
import com.example.softwaricaapp.ui.Students.StudentFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_studentform,R.id.navigation_aboutus)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        StudentFragment.stList.add(new Students("Kiran Rana", "35", "Male", "Kathmandu", R.drawable.male));
        StudentFragment.stList.add(new Students("Salman Khan", "55", "Male", "Mumbai", R.drawable.male));
        StudentFragment.stList.add(new Students("Katrina Kaif", "55", "Female", "Mumbai", R.drawable.female));

    }

}
