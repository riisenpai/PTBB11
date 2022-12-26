package com.example.escom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.escom.databinding.ActivityHomeBinding;
import com.example.escom.databinding.ActivityProfileBinding;
import com.example.escom.datamodels.LogoutResponse;
import com.example.escom.datamodels.ProfilResponse;
import com.example.escom.retrofit.TugasClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    private ActivityProfileBinding binding;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        String username = sharedPref.getString("USERNAME", "");
        String name = sharedPref.getString("NAME", "");
        String email = sharedPref.getString("EMAIL", "");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ptb-api.husnilkamil.my.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        TugasClient client = retrofit.create(TugasClient.class);

        Call<ProfilResponse> call = client.profil("Bearer " + token);

        call.enqueue(new Callback<ProfilResponse>() {
            @Override
            public void onResponse(Call<ProfilResponse> call, Response<ProfilResponse> response) {
                Intent intent = getIntent();
                binding.profilName.setText(name);
                binding.profilUsername.setText(username);
                binding.profilEmail.setText(email);
            }

            @Override
            public void onFailure(Call<ProfilResponse> call, Throwable t) {

            }
        });

    }

    public void back(View view) {
        Intent intent = new Intent(ProfileActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}

