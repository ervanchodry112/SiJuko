package com.kopmaul.sijuko.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kopmaul.sijuko.R;
import com.kopmaul.sijuko.databinding.ActivityPayTransactionBinding;
import com.kopmaul.sijuko.databinding.FragmentNominalBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NominalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NominalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NominalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NominalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NominalFragment newInstance(String param1, String param2) {
        NominalFragment fragment = new NominalFragment();
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

    private FragmentNominalBinding binding;
    private ActivityPayTransactionBinding activityBinding;
    private PaymentFragment paymentFragment = new PaymentFragment();
    private String nominal, bulan;
    private Integer metode_pembayaran;
    private String TAG = "NominalFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNominalBinding.inflate(getLayoutInflater(), container, false);
        View view = binding.getRoot();

        activityBinding = ActivityPayTransactionBinding.inflate(getLayoutInflater());

        binding.metodeBayar.setOnCheckedChangeListener((radioGroup, i) -> {
            if(binding.tfBtn.isChecked()){
                metode_pembayaran = 1;
            }else if(binding.ovo.isChecked()){
                metode_pembayaran = 2;
            }else if(binding.gopay.isChecked()){
                metode_pembayaran = 3;
            }else if(binding.dana.isChecked()){
                metode_pembayaran = 4;
            }
            Log.d(TAG, metode_pembayaran.toString());
        });

        binding.btnBayar.setOnClickListener(view1 -> {
            getActivity().getSupportFragmentManager().beginTransaction().replace(activityBinding.frameLayout.getId(),paymentFragment).commit();
        });

        binding.btnCancel.setOnClickListener(view12 -> {
            getActivity().finish();
        });

        return view;
    }
}