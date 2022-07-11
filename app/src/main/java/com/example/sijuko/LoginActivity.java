package com.example.sijuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sijuko.API.APIConfig;
import com.example.sijuko.Model.DataAnggota;
import com.example.sijuko.Model.LoginResponse;
import com.example.sijuko.ViewModel.LoginViewModel;
import com.example.sijuko.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity{

    private ActivityLoginBinding binding;
    private String username, password;
    private String nama, npm, nomor_anggota, referal;
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
//                    Intent i = new Intent(this, MainActivity.class);
//                    startActivity(i);
                    finish();
                });
            }else{
                Toast.makeText(LoginActivity.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                Log.d("gagal", "Login gagal");
            }
        });
    }


}