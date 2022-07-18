package com.kopmaul.sijuko.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kopmaul.sijuko.SessionManager;
import com.kopmaul.sijuko.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private SessionManager sessionManager;
    private String nama, nomor_anggota;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(getLayoutInflater(), container, false);
        View view = binding.getRoot();
        sessionManager = new SessionManager(getActivity());

        nama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        nomor_anggota = sessionManager.getUserDetail().get(SessionManager.NOMOR_ANGGOTA);

        binding.prflName.setText(nama);
        binding.prflNomor.setText(nomor_anggota);


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

        binding.menuReferal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ReferalActivity.class);
                startActivity(i);
            }
        });

        binding.logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutSession();
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}