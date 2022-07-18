package com.kopmaul.sijuko.View;

import static androidx.core.content.ContextCompat.getDrawable;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kopmaul.sijuko.API.APIConfig;
import com.kopmaul.sijuko.Adapter.ArticleAdapter;
import com.kopmaul.sijuko.Article.ArticleResponse;
import com.kopmaul.sijuko.R;
import com.kopmaul.sijuko.SessionManager;
import com.kopmaul.sijuko.ViewModel.HomeViewModel;
import com.kopmaul.sijuko.databinding.BarcodeDialogBinding;
import com.kopmaul.sijuko.databinding.FragmentHomeBinding;

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
    private String name, npm, nomor_anggota;
    private HomeViewModel viewModel;
    private Dialog dialog;
    private BarcodeDialogBinding dialogBinding;

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

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.retrieveData(sessionManager.getUserDetail().get(SessionManager.NPM));

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
//                Toast.makeText(getActivity(), "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        binding.schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ScheduleActivity.class);
                startActivity(i);
//                Toast.makeText(getActivity(), "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        binding.catalogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), CatalogueActivity.class);
                startActivity(i);
//                Toast.makeText(getActivity(), "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        binding.laporanKeuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), KeuanganActivity.class);
                startActivity(i);
//                Toast.makeText(getActivity(), "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        binding.viewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "https://kopmaunila.com/blog/";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(i);
            }
        });

//        binding.barcode.setOnClickListener(view12 -> {
//            nomor_anggota = sessionManager.getUserDetail().get(SessionManager.NOMOR_ANGGOTA);
//            try {
//                barcode(nomor_anggota);
//                dialog.show();
//            } catch (WriterException e) {
//                Log.e("HomeFragment", e.toString());
//            }
//        });

        binding.addTransaction.setOnClickListener(view12 -> {
//            Intent i = new Intent(getActivity(), PayTransactionActivity.class);
//            startActivity(i);
            Toast.makeText(getActivity(), "Coming Soon", Toast.LENGTH_SHORT).show();
        });

        viewModel.getStatus().observe(getActivity(), status -> {
            try{
                if(status){
                    viewModel.getData().observe(getActivity(), dataItem -> {
                        binding.totalSimpanan.setText("Rp"+dataItem.getSimpananWajib());
                        binding.totalPoin.setText(dataItem.getPoin());
                    });
                    Log.d("HomeFragment", "Status Berhasil");
                }else{
                    Log.d("HomeFragment", "Gagal mendapatkan item");
                }
            }catch(Exception e){
                Log.e("HomeFragment", e.toString());
                Log.e("StatusHomeFragment", status.toString());
            }

        });

        dialogBinding = BarcodeDialogBinding.inflate(getLayoutInflater());
        dialog = new Dialog(getActivity());
        dialog.setContentView(dialogBinding.getRoot());

        dialog.getWindow().setBackgroundDrawable(getDrawable(getActivity(),R.drawable.background_dialog));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);

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
                adData = new ArticleAdapter(getActivity(),response.body());
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

//    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

//    public void barcode(String nomor_anggota) throws WriterException {
//        BitMatrix bitMatrix = multiFormatWriter.encode(nomor_anggota, BarcodeFormat.CODE_39, 500, 150);
//        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
//        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
//        dialogBinding.barcodeImage.setImageBitmap(bitmap);
//        dialogBinding.nomorBarcode.setText(nomor_anggota);
//    }
}

