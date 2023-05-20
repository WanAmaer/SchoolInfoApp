package com.example.payment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.TBMainAct);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.DLMain);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavHostFragment host = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.NHFMain);
        NavController navController = host.getNavController();
        AppBarConfiguration appBarConfiguration = new
                AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this,
                navController, appBarConfiguration);
        setupBottomNavMenu(navController);
        setupNavMenu(navController);
    }
    private void setupNavMenu(NavController navController){
        NavigationView sideNav = findViewById(R.id.sideNav);
        NavigationUI.setupWithNavController(sideNav,
                navController,false);

    }
    private void setupBottomNavMenu(NavController navController) {
        BottomNavigationView bottomNav =
                findViewById(R.id.bottom_nav_view);
        NavigationUI.setupWithNavController(bottomNav,
                navController,false);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bottom, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            Navigation.findNavController(this,
                    R.id.NHFMain).navigate(item.getItemId());
            return true;
        }
        catch (Exception ex)
        {
            return super.onOptionsItemSelected(item);
        }
    }
}
