package com.kopmaul.sijuko.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kopmaul.sijuko.API.APIConfig;
import com.kopmaul.sijuko.Model.RegisterResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends ViewModel {
    private MutableLiveData<Integer> code = new MutableLiveData<>();
    private MutableLiveData<String> message = new MutableLiveData<>();
    private MutableLiveData<Boolean> status = new MutableLiveData<>();

    private static final String TAG = "RegisterViewModel";

    public LiveData<Boolean> getStatus() {
        return status;
    }

    public void setStatus(MutableLiveData<Boolean> status) {
        this.status = status;
    }

    public LiveData<String> getMessage() {
        return message;
    }

    public void setMessage(MutableLiveData<String> message) {
        this.message = message;
    }

    public MutableLiveData<Integer> getCode() {
        return code;
    }

    public void setCode(MutableLiveData<Integer> code) {
        this.code = code;
    }

    public void register(String username, String password, String npm){
        Call<RegisterResponse> client = APIConfig.getApiService().registrasi(username, password, npm);
        client.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                status.setValue(response.isSuccessful());
                Log.d(TAG, Boolean.toString(response.isSuccessful()));
                if(response.body() != null && response.isSuccessful()){
                    code.setValue(response.body().getStatus());
                    message.setValue(response.body().getMessage());
                }else{
                    status.setValue(false);
                    message.setValue(response.message());
                    try{
                        if(response.errorBody() != null){
                            RegisterResponse errorResponse = new Gson().fromJson(response.errorBody().charStream(),
                                    RegisterResponse.class);

                            Log.e("error", errorResponse.getMessage());
                        }
                    }catch (Exception e){
                        Log.e("error", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                status.setValue(false);
                Log.e(TAG, "ON FAILURE "+t.getMessage());
            }
        });
    }
}
