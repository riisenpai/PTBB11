package com.example.escom.retrofit;

import com.example.escom.datamodels.DetailResponse;
import com.example.escom.datamodels.LoginResponse;
import com.example.escom.datamodels.LogoutResponse;
import com.example.escom.datamodels.PesertaResponse;
import com.example.escom.datamodels.ProfilResponse;
import com.example.escom.datamodels.ThesesResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TugasClient {

    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);

    @POST("api/logout")
    Call<LogoutResponse> logout(@Header("token") String token);

    @GET("api/me")
    Call<ProfilResponse> profil(@Header("token") String token);

    @GET("/api/admin/theses")
    Call<ThesesResponse> getTheses(@Header("Authorization") String token);

    @GET("/api/thesis/seminars/{id}/audiences")
    Call<PesertaResponse> getPeserta(
            @Path("id") Integer idTheses,
            @Header("Authorization") String token);

    @GET("/api/theses/{id}")
    Call<DetailResponse> getDetail(
            @Path("id") Integer idTheses,
            @Header("Authorization") String token);
}
