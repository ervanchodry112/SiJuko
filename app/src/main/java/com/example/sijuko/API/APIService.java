package com.example.sijuko.API;

import com.example.sijuko.Article.ArticleResponse;
import com.example.sijuko.Model.LoginResponse;
import com.example.sijuko.Model.PresensiResponse;
import com.example.sijuko.Model.RegisterResponse;
import com.example.sijuko.Model.SimpananResponse;

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

    @FormUrlEncoded
    @POST("administrasi/api/login.php")
    Call<LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("administrasi/api/register.php")
    Call<RegisterResponse> registrasi(
            @Field("username") String username,
            @Field("password") String password,
            @Field("npm") String npm
    );

    @FormUrlEncoded
    @POST("administrasi/api/get_user.php")
    Call<SimpananResponse> getSimpanan(
            @Field("npm") String npm
    );
}
