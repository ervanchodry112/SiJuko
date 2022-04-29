package com.example.sijuko;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sijuko.R;
import com.example.sijuko.databinding.ActivityMainBinding;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ActivityMainBinding binding;

    private com.example.sijuko.HomeFragment homeFragment = new com.example.sijuko.HomeFragment();
    private com.example.sijuko.HistoryFragment historyFragment = new com.example.sijuko.HistoryFragment();
    private com.example.sijuko.ScannerFragment scannerFragment = new com.example.sijuko.ScannerFragment();
    private com.example.sijuko.NotificationFragment notificationFragment = new com.example.sijuko.NotificationFragment();
    private com.example.sijuko.ProfileFragment profileFragment = new com.example.sijuko.ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        bottomNavigationView = binding.battomNav;

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.history:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,historyFragment).commit();
                        return true;
                    case R.id.qrscanner:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,scannerFragment).commit();
                        return true;
                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,notificationFragment).commit();
                        return true;
                    case R.id.profil:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}