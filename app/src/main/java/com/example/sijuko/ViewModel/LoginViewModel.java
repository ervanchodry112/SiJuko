package com.example.sijuko.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sijuko.API.APIConfig;
import com.example.sijuko.Model.DataAnggota;
import com.example.sijuko.Model.ErrorResponse;
import com.example.sijuko.Model.LoginResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<DataAnggota> dataAnggota = new MutableLiveData<>();
    private MutableLiveData<String> message = new MutableLiveData<>();
    private MutableLiveData<Boolean> status = new MutableLiveData<>();

    private static final String TAG = "LoginViewModel";

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
                Log.d("status", Boolean.toString(response.isSuccessful()));
                if(response.body() != null && response.isSuccessful()){
                    if(response.body().isStatus()){
                        dataAnggota.setValue(response.body().getDataAnggota());
                    }else{
                        message.setValue(response.body().getMessage());
                        Log.d(TAG, response.body().getMessage());
                    }
                }else{
                    status.setValue(false);
                    message.setValue(response.message());
                    try{
                        if(response.errorBody() != null){
                            ErrorResponse loginResponse = new Gson().fromJson(response.errorBody().charStream(),
                                    ErrorResponse.class);

                            Log.e("error", loginResponse.getMessage());
                        }
                    }catch (Exception e){
                        Log.e("error", e.toString());
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

