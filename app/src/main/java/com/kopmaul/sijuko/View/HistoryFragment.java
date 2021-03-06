package com.kopmaul.sijuko.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kopmaul.sijuko.Transaction;
import com.kopmaul.sijuko.databinding.FragmentHistoryBinding;
import com.kopmaul.sijuko.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HistoryFragment extends Fragment {

    private FragmentHistoryBinding binding;
    private RecyclerView recyclerView;
    private ArrayList<Transaction> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(getLayoutInflater(), container, false);
        View view = binding.getRoot();
//        list = new ArrayList<>();
//        list.addAll(TransactionData.getListTransaction());
//        recyclerView = binding.recyclerHistory;
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        CardViewTransactionsAdapter cardViewTransactionsAdapter = new CardViewTransactionsAdapter(view.getContext());
//        cardViewTransactionsAdapter.setTransactionsList(list);
//        recyclerView.setAdapter(cardViewTransactionsAdapter);
        return view;
    }
}