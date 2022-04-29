package com.example.sijuko;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sijuko.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private ArrayList<Article> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        View view = binding.getRoot();
        list = new ArrayList<>();
        list.addAll(ArticleData.getListData());
        recyclerView = binding.recyclerView;
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        CardViewArticleAdapter cardViewArticleAdapter = new CardViewArticleAdapter(view.getContext());
        cardViewArticleAdapter.setArticleList(list);
        recyclerView.setAdapter(cardViewArticleAdapter);
        return view;
    }
}