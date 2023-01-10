package com.example.escom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.escom.databinding.ActivitySeminarBinding;
import com.example.escom.datamodels.SeminarResponse;
import com.example.escom.retrofit.TugasClient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SeminarActivity extends AppCompatActivity {
    String nama,nim,judul,tanggal,dosen,tempat;
    TextView textNamaMahasiswaDetail,textNIM, textJudul, textDosen, textTanggal, textTempat;
    SharedPreferences sharedPref;
    private ActivitySeminarBinding binding;
    private int idTheses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar);

        Intent detailIntent = getIntent();
        if (detailIntent != null){
            idTheses = detailIntent.getIntExtra("ID",0);
//            nama = detailIntent.getStringExtra( "NAMA_AGENDA");
//            textNamaMahasiswaDetail = findViewById(R.id.textNamaMahasiswaDetail);
//            textNamaMahasiswaDetail.setText(nama);
//
//            nim = detailIntent.getStringExtra( "NIM");
//            textNIM = findViewById(R.id.textNIM);
//            textNIM.setText(nim);
//
//            judul = detailIntent.getStringExtra( "JUDUL");
//            textJudul = findViewById(R.id.textJudul);
//            textJudul.setText(judul);
//
//            tanggal = detailIntent.getStringExtra( "TANGGAL");
//            textTanggal = findViewById(R.id.textStatus);
//            textTanggal.setText(tanggal);
//
//            dosen = detailIntent.getStringExtra( "DOSEN");
//            textDosen = findViewById(R.id.textDosen);
//            textDosen.setText(dosen);
//
//            tempat = detailIntent.getStringExtra( "TEMPAT");
//            textTempat = findViewById(R.id.textTanggalMulai);
//            textTempat.setText(tempat);
        }
    }

//    binding = ActivitySeminarBinding.inflate(getLayoutInflater());
//    View view = binding.getRoot();
//    setContentView(view);

//    SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
    String token = sharedPref.getString("TOKEN", "");

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://ptb-api.husnilkamil.my.id/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(new OkHttpClient.Builder().build())
            .build();

    TugasClient client = retrofit.create(TugasClient.class);

    Call<SeminarResponse> call = client.semDetail(idTheses, "Bearer " + token);
//    call.enqueue(new Callback<SeminarResponse>(){
//
//    }


    public void back(View view) {
        Intent intent = new Intent(SeminarActivity.this,SemdangActivity.class);
        startActivity(intent);
    }

    public void seminarpenguji(View view) {
        Intent intent = new Intent(SeminarActivity.this,SidangpengujiActivity.class);
        startActivity(intent);
    }
}
