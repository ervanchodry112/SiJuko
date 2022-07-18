package com.kopmaul.sijuko.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kopmaul.sijuko.API.APIConfig;
import com.kopmaul.sijuko.Model.DataItem;
import com.kopmaul.sijuko.Model.SimpananResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<Boolean> status = new MutableLiveData<>();
    private MutableLiveData<String> message = new MutableLiveData<>();
    private MutableLiveData<DataItem> data = new MutableLiveData<>();

    public final String TAG = "HomeViewModel";

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

    public LiveData<DataItem> getData() {
        return data;
    }

    public void setData(MutableLiveData<DataItem> data) {
        this.data = data;
    }

    public void retrieveData(String npm){
        Call<SimpananResponse> client = APIConfig.getApiService().getSimpanan(npm);
        client.enqueue(new Callback<SimpananResponse>() {
            @Override
            public void onResponse(Call<SimpananResponse> call, Response<SimpananResponse> response) {
                status.setValue(response.isSuccessful());
                if(response.body() != null && response.isSuccessful()){
                    if(response.body().getStatus() == 1){
                        status.setValue(true);
                        data.postValue(response.body().getData());
                        Log.d(TAG, "Data berhasil masuk");
                    }else{
                        status.setValue(false);
                        message.setValue(response.body().getMessage());
                        Log.e(TAG, response.message());
                    }
                }else{
                    status.setValue(false);
                    message.setValue(response.message());
                    Log.e(TAG, "Gagal mendapatkan response");
                }
            }

            @Override
            public void onFailure(Call<SimpananResponse> call, Throwable t) {
                status.setValue(false);
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
