package com.example.sijuko.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sijuko.API.APIConfig;
import com.example.sijuko.Adapter.ArticleAdapter;
import com.example.sijuko.Article.ArticleResponse;
import com.example.sijuko.SessionManager;
import com.example.sijuko.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<ArticleResponse> list = new ArrayList<>();
    private SessionManager sessionManager;
    private String name, npm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        View view = binding.getRoot();
        sessionManager = new SessionManager(getActivity());
        if(!sessionManager.isLoggedIn()){
            Intent i = new Intent(getActivity(), LoginActivity.class);
            startActivity(i);
        }

        name = sessionManager.getUserDetail().get(SessionManager.NAMA);
        npm = sessionManager.getUserDetail().get(SessionManager.NPM);
        binding.name.setText(name);



        lmData = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), layoutManager.getOrientation());
        binding.recyclerView.addItemDecoration(itemDecoration);

        binding.survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), SurveyActivity.class);
                startActivity(i);
            }
        });

        binding.schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ScheduleActivity.class);
                startActivity(i);
            }
        });

        binding.catalogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), CatalogueActivity.class);
                startActivity(i);
            }
        });

        binding.laporanKeuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), KeuanganActivity.class);
                startActivity(i);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveData();
    }

    public void retrieveData() {
        Call<List<ArticleResponse>> client = APIConfig.getApiService().getPost();
        client.enqueue(new Callback<List<ArticleResponse>>() {
            @Override
            public void onResponse(Call<List<ArticleResponse>> call, Response<List<ArticleResponse>> response) {

                recyclerView = binding.recyclerView;
                adData = new ArticleAdapter(response.body());
                recyclerView.setAdapter(adData);
                adData.notifyDataSetChanged();

//                Toast.makeText(getActivity(), "Koneksi Berhasil", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ArticleResponse>> call, Throwable t) {
                Toast.makeText(getActivity(), "Gagal menghubungi server" + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("HomeFragment", t.getMessage());
            }
        });
    }
}

