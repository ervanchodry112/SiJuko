package com.example.sijuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.rxjava3.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava3.RxDataStore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.sijuko.databinding.ActivityLoginBinding;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.net.PasswordAuthentication;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private String username, password;
    private String nama, npm, nomor_anggota, referal;
    private RxDataStore<Preferences> dataStore;
    private Preferences.Key<String> KEY_NPM = PreferencesKeys.stringKey("npm");
    private Preferences.Key<String> KEY_NAMA = PreferencesKeys.stringKey("nama");
    private Preferences.Key<String> KEY_NOMOR = PreferencesKeys.stringKey("no_anggota");
    private Preferences.Key<String> KEY_REFERAL = PreferencesKeys.stringKey("referal");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        nama = "Fulan";
        npm = "2017051001";
        nomor_anggota = "2083/KOPMA_UL/20";
        referal = nomor_anggota.substring(0,3)+nomor_anggota.substring(14);

        try {
            dataStore.data().map(preferences -> preferences.get(KEY_NPM))
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(new Subscriber<String>() {
                        @Override
                        public void onSubscribe(Subscription s) {
                            s.request(1);
                        }

                        @Override
                        public void onNext(String s) {
                            if (s != null) {
                                Intent i = new Intent(getApplication(), MainActivity.class);
                            }
                        }

                        @Override
                        public void onError(Throwable t) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }catch (Exception e){
            Log.d("TAG", e.toString());
        }

        dataStore = new RxPreferenceDataStoreBuilder(getApplicationContext(), "data_anggota").build();

        binding.btnLogin.setOnClickListener(view -> {
            username = binding.username.getText().toString();
            password = binding.password.getText().toString();

            if(username == "dummy" && password == "test"){
                Single<Preferences> update = dataStore.updateDataAsync(new Function<Preferences, Single<Preferences>>() {
                    @Override
                    public Single<Preferences> apply(Preferences preferences) throws Throwable {
                        MutablePreferences mutablePreferences = preferences.toMutablePreferences();
                        mutablePreferences.set(KEY_NPM, npm);
                        mutablePreferences.set(KEY_NAMA, nama);
                        mutablePreferences.set(KEY_NOMOR, nomor_anggota);
                        mutablePreferences.set(KEY_REFERAL, referal);
                        return Single.just(mutablePreferences);
                    }
                });
            }else{
                binding.alert.setVisibility(View.VISIBLE);
            }
        });
    }
}