package com.example.sijuko.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sijuko.API.APIConfig;
import com.example.sijuko.LoginActivity;
import com.example.sijuko.MainActivity;
import com.example.sijuko.Model.DataAnggota;
import com.example.sijuko.Model.LoginResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<DataAnggota> dataAnggota = new MutableLiveData<>();
    private MutableLiveData<String> message = new MutableLiveData<>();
    private MutableLiveData<Boolean> status = new MutableLiveData<>();

    public LiveData<DataAnggota> getDataAnggota() {
        return dataAnggota;
    }

    public void setDataAnggota(MutableLiveData<DataAnggota> dataAnggota) {
        this.dataAnggota = dataAnggota;
    }

    public LiveData<String> getMessage() {
        return message;
    }

    public void setMessage(MutableLiveData<String> message) {
        this.message = message;
    }

    public LiveData<Boolean> getStatus() {
        return status;
    }

    public void setStatus(MutableLiveData<Boolean> status) {
        this.status = status;
    }

    public void login(String username, String password){
        Call<LoginResponse> client = APIConfig.getApiService().login(username, password);
        client.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                status.setValue(response.isSuccessful());
                if(response.body() != null && response.isSuccessful()){
                    dataAnggota.setValue(response.body().getDataAnggota());
                }else{
                    message.setValue(response.message());
                    try{
                        if(response.errorBody() != null){
                            LoginResponse loginResponse = new Gson().fromJson(response.errorBody().charStream(),
                                    LoginResponse.class);

                            Log.e("error", loginResponse.getMessage());

                        }
                    }catch (Exception e){
                        Log.e("error", e.toString());
                        Log.e("punya_respon", response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                status.setValue(false);
                Log.e("message", t.getMessage());
            }
        });
    }

}

