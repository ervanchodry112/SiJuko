package com.example.sijuko.API;

import com.example.sijuko.Article.ArticleResponse;
import com.example.sijuko.Model.PresensiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @GET("wp-json/wp/v2/posts")
    Call<List<ArticleResponse>> getPost();

    @FormUrlEncoded
    @POST("administrasi/api/presensi.php")
    Call<PresensiResponse> presensi(
            @Field("npm") String npm,
            @Field("kode_kegiatan") int kode
    );
}
