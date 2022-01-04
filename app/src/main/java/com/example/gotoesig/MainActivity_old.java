package com.example.gotoesig;
/*

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.essaidrawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}*/
/*
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout ;
    private Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view) ;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_profil:
                        Toast.makeText(getApplicationContext(), "Profil", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break ;
                    case R.id.nav_addTrip:
                        Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break ;
                    case R.id.nav_allTrips:
                        Toast.makeText(getApplicationContext(), "All", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break ;
                    case R.id.nav_findTrip:
                        Toast.makeText(getApplicationContext(), "Find", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break ;
                    case R.id.nav_rateTrip:
                        Toast.makeText(getApplicationContext(), "Rate", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break ;
                    case R.id.nav_stats:
                        Toast.makeText(getApplicationContext(), "Statistiques", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break ;
                    case R.id.nav_exit:
                        Toast.makeText(getApplicationContext(), "Profil", Toast.LENGTH_SHORT).show();
                        finish();
                        break ;
                }
                return true;
            }
        });

        View header = navigationView.getHeaderView(0) ;
        TextView tvEmail = (TextView)header.findViewById(R.id.tv_email) ;
        tvEmail.setText("Yoo");
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer) ;
        ActionBarDrawerToggle actionBarDrawerToggle
                = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0) {
            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }
            @Override
            public void onDrawerOpened(View v){
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}*/