package com.example.escom.retrofit;

import com.example.escom.datamodels.ListPermintaanTAResponse;
import com.example.escom.datamodels.LogbookResponse;
import com.example.escom.datamodels.LoginResponse;
import com.example.escom.datamodels.LogoutResponse;
import com.example.escom.datamodels.PembimbingResponse;
import com.example.escom.datamodels.ProfilResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface TugasClient {


    @FormUrlEncoded
    @POST("api/login")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);

    @POST("api/logout")
    Call<LogoutResponse> logout(@Header("token") String token);

    @GET("api/me")
    Call<ProfilResponse> profil(@Header("token") String token);

    @GET("api/admin/thesis-submissions")
    Call<ListPermintaanTAResponse> listPermintaan(@Header("Authorization") String token);

    @GET("api/theses/309/logbooks")
    Call<LogbookResponse> logbook(@Header("Authorization") String token);

    @FormUrlEncoded
    @POST("api/admin/theses/369/supervisors")
    Call<PembimbingResponse> pembimbing(
            @Header("Authorization") String token,
            @Field("lecturer_id") String lecturer_id,
            @Field("position") String position);




}
