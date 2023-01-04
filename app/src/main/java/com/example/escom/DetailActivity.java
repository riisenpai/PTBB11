package com.example.escom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.escom.databinding.ActivityDetailBinding;
import com.example.escom.datamodels.DetailResponse;
import com.example.escom.datamodels.SeminarsItem;
import com.example.escom.retrofit.TugasClient;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    String nama,nim,judul,tanggal,dosen,status;
    TextView textNamaMahasiswaDetail,textNIM, textJudul, textDosen, textTanggal, textStatus;
    SharedPreferences sharedPref;
    private ActivityDetailBinding binding;
    private int idTheses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if (intent != null) {
            idTheses = intent.getIntExtra("ID",0);
        }

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ptb-api.husnilkamil.my.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        TugasClient client = retrofit.create(TugasClient.class);

        Call<DetailResponse> call = client.getDetail(idTheses, "Bearer " + token);
        call.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {

                DetailResponse detailResponse = response.body();
                if(response.code()==200) {
                    binding.textNamaMahasiswaDetail.setText(detailResponse.getStudent().getName());
                    binding.textNIM.setText(detailResponse.getStudent().getNim());
                    binding.textTanggalMulai.setText(detailResponse.getStartAt());
                    binding.textJudul.setText(detailResponse.getTitle());
                    }
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {

            }
        });
    }

    public void back(View view) {
        Intent intent = new Intent(DetailActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    public void mahasiswa(View view) {
        Intent intent = new Intent(DetailActivity.this,MahasiswaActivity.class);
        startActivity(intent);
    }

    public void peserta(View view) {
        Intent intent = new Intent(DetailActivity.this,PesertaActivity.class);
        startActivity(intent);
    }

    public void logbook(View view) {
        Intent intent = new Intent(DetailActivity.this,LogbookActivity.class);
        startActivity(intent);
    }
}
