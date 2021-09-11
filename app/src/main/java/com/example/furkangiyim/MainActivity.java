package com.example.furkangiyim;

import android.content.Intent;
import android.graphics.Color;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private Toolbar toolbar;
    private Intent intent;
    private Fragment tempFragment;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Furkan Giyim");
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);

        // Bottom Navigation View
        bottomNavigation = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_tutucu, new FragmentHomePage()).commit();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.Anasayfa) {
                    tempFragment = new FragmentHomePage();
                }
                if(menuItem.getItemId() == R.id.Ürünler) {
                    tempFragment = new FragmentProducts();
                }
                if(menuItem.getItemId() == R.id.Ayarlar) {
                    tempFragment = new FragmentSettings();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu, tempFragment).commit();
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.Sepet ) {
            Intent intent = new Intent(this, ActivityBasket.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}

