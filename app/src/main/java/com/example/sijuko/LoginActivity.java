package com.example.sijuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sijuko.API.APIConfig;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        nama = "Fulan";
        npm = "2017051001";
        nomor_anggota = "2083/KOPMA_UL/20";
        referal = nomor_anggota.substring(0,3)+nomor_anggota.substring(14);


        binding.btnLogin.setOnClickListener(view -> {
            username = binding.username.getText().toString().toLowerCase();
            password = binding.password.getText().toString();

            viewModel.login(username, password);
        });
    }


}