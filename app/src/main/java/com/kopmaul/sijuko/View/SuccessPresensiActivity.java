package com.kopmaul.sijuko.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kopmaul.sijuko.databinding.ActivitySuccessBinding;

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