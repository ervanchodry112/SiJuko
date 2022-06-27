package com.example.sijuko;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sijuko.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(getLayoutInflater(), container, false);
        View view = binding.getRoot();

        binding.catalogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), CatalogueActivity.class);
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
        return view;
    }
}