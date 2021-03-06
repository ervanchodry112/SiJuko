package com.kopmaul.sijuko.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.kopmaul.sijuko.API.APIConfig;
import com.kopmaul.sijuko.Model.PresensiResponse;
import com.kopmaul.sijuko.SessionManager;
import com.kopmaul.sijuko.databinding.FragmentScannerBinding;
import com.google.zxing.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScannerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScannerFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScannerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScannerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScannerFragment newInstance(String param1, String param2) {
        ScannerFragment fragment = new ScannerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private CodeScanner mCodeScanner;
    private FragmentScannerBinding binding;
    private SessionManager sessionManager;
    private String npm, nama;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final Activity activity = getActivity();
        binding = FragmentScannerBinding.inflate(getLayoutInflater(), container, false);
        View root = binding.getRoot();
        CodeScannerView scannerView = binding.scannerView;
        mCodeScanner = new CodeScanner(activity, scannerView);
        sessionManager = new SessionManager(getActivity());

        npm = sessionManager.getUserDetail().get(SessionManager.NPM);
        nama = sessionManager.getUserDetail().get(SessionManager.NAMA);

        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                activity.runOnUiThread(() -> {
                    presensi(result.getText());
                            Intent i = new Intent(getActivity(), SuccessPresensiActivity.class);
                    startActivity(i);
                });
            }
        });
        scannerView.setOnClickListener(view -> mCodeScanner.startPreview());

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    public void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }

    public void presensi(String result){
        Call<PresensiResponse> client = APIConfig.getApiService().presensi(npm, Integer.parseInt(result));

        client.enqueue(new Callback<PresensiResponse>() {
            @Override
            public void onResponse(Call<PresensiResponse> call, Response<PresensiResponse> response) {
                String status = response.body().getStatus();
                String message = response.body().getPesan();
            }

            @Override
            public void onFailure(Call<PresensiResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Error : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}