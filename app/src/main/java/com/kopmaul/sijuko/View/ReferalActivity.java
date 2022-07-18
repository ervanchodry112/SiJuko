package com.kopmaul.sijuko.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.kopmaul.sijuko.R;
import com.kopmaul.sijuko.SessionManager;
import com.kopmaul.sijuko.databinding.ActivityReferalBinding;

public class ReferalActivity extends AppCompatActivity {

    private ActivityReferalBinding binding;
    private ActionBar actionBar;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReferalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sessionManager = new SessionManager(this);
        String referal = sessionManager.getUserDetail().get(SessionManager.REFERAL);

        binding.referalCode.setText(referal);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}