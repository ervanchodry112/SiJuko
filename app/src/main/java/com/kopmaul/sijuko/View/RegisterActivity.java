package com.kopmaul.sijuko.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kopmaul.sijuko.R;
import com.kopmaul.sijuko.ViewModel.RegisterViewModel;
import com.kopmaul.sijuko.databinding.ActivityRegisterBinding;
import com.kopmaul.sijuko.databinding.SuccessDialogBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private RegisterViewModel viewModel;
    private String message, username;
    private Integer code;
    private Dialog dialog;
    private SuccessDialogBinding dialogBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        binding.btnRegister.setOnClickListener(view -> {
            boolean isValid = true;

            String npm = binding.npm.getText().toString();
            String nama = binding.namaLengkap.getText().toString();
            String nomor_anggota = binding.nomorAnggota.getText().toString();
            String password = binding.password.getText().toString();
            String password2 = binding.passwordConfirm.getText().toString();

            if (npm.isEmpty() || npm.length() < 10) {
                binding.npm.setError("NPM tidak valid");
                isValid = false;
            }
            if (nama.length() == 0) {
                binding.namaLengkap.setError("Nama tidak boleh kosong!");
                isValid = false;
            }
            if (nomor_anggota.isEmpty() || nomor_anggota.length() < 16) {
                binding.nomorAnggota.setError("Nomor Anggota Tidak Valid");
                isValid = false;
            }
            if (password.length() == 0 || password2.length() == 0) {
                binding.password.setError("Password tidak boleh kosong");
                binding.passwordConfirm.setError("Password tidak boleh kosong");
                isValid = false;
            } else if (!password.equals(password2)) {
                binding.password.setError("Password tidak sama!");
                binding.passwordConfirm.setError("Password tidak sama!");
                isValid = false;
            }

            if (isValid){
                username = nomor_anggota.substring(0, 4) + nomor_anggota.substring(14);
                viewModel.register(username, password, npm);
            }
        });

        binding.btnCancel.setOnClickListener(view -> finish());

        viewModel.getStatus().observe(RegisterActivity.this, status -> {
            if (status) {

                viewModel.getMessage().observe(this, _message -> {
                    message = _message;
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                });
                viewModel.getCode().observe(this, _code -> {
                    if (_code == 301 || _code == 401) {
                        binding.npm.setError(message);
                    } else if (_code == 501 || _code == 403) {
                        binding.konten.setText(message);
                        binding.alert.setVisibility(View.VISIBLE);
                    } else {
                        dialogBinding.registedUsername.setText(username);
                        dialog.show();
                    }
                });
            }else{

            }
        });

        dialogBinding = SuccessDialogBinding.inflate(getLayoutInflater());
        dialog = new Dialog(this);
        dialog.setContentView(dialogBinding.getRoot());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_dialog));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        dialogBinding.btnBack.setOnClickListener(view -> {
            dialog.dismiss();
            finish();
        });
    }
}