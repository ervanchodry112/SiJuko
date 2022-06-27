package com.example.sijuko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sijuko.databinding.ActivitySuccessBinding;

public class SuccessPresensiActivity extends AppCompatActivity {

    ActivitySuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.homeButton.setOnClickListener(view -> finish());
    }
}