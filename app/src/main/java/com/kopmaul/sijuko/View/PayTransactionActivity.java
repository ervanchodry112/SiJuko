package com.kopmaul.sijuko.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kopmaul.sijuko.R;
import com.kopmaul.sijuko.databinding.ActivityPayTransactionBinding;

public class PayTransactionActivity extends AppCompatActivity {

    private ActivityPayTransactionBinding binding;
    private NominalFragment nominalFragment = new NominalFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPayTransactionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(binding.frameLayout.getId(),nominalFragment).commit();
    }
}