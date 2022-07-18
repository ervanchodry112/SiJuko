package com.kopmaul.sijuko.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kopmaul.sijuko.databinding.FragmentNotificationBinding;

import java.util.ArrayList;


public class NotificationFragment extends Fragment {

    private FragmentNotificationBinding binding;
    private RecyclerView recyclerView;
    private ArrayList<Notification> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(getLayoutInflater(), container, false);
        View view = binding.getRoot();
//        list = new ArrayList<>();
//        list.addAll(NotificationData.getListNotification());
//        recyclerView = binding.recyclerNotification;
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        CardViewNotificationAdapter cardViewNotificationAdapter = new CardViewNotificationAdapter(view.getContext());
//        cardViewNotificationAdapter.setNotificationList(list);
//        recyclerView.setAdapter(cardViewNotificationAdapter);
        return view;
    }
}