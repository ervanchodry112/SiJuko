package com.kopmaul.sijuko.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.kopmaul.sijuko.Model.DataAnggota;
import com.kopmaul.sijuko.SessionManager;
import com.kopmaul.sijuko.ViewModel.LoginViewModel;
import com.kopmaul.sijuko.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity{

    private ActivityLoginBinding binding;
    private String username, password;
    private LoginViewModel viewModel;
    private DataAnggota _dataAnggota;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        sessionManager = new SessionManager(getApplicationContext());

        binding.btnLogin.setOnClickListener(view -> {
            username = binding.username.getText().toString().toLowerCase();
            password = binding.password.getText().toString();

            viewModel.login(username, password);

        });

        viewModel.getStatus().observe(LoginActivity.this, status -> {
            if(status){
                viewModel.getDataAnggota().observe(LoginActivity.this, dataAnggota -> {
                    _dataAnggota = dataAnggota;
                    Log.d("simpen", _dataAnggota.getNpm());
                    sessionManager.createLoginSession(_dataAnggota);
                    finish();
                });
            }else{
                Toast.makeText(LoginActivity.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                Log.d("gagal", "Login gagal");
            }
        });

        binding.toRegister.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(i);
        });
    }


}