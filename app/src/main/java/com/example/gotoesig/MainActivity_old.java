package com.example.gotoesig;

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

public class MainActivity_old extends AppCompatActivity {
    private DrawerLayout drawerLayout ;
    private Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view) ;
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
        actionBarDrawerToggle.syncState();*/
    }
}