package com.example.escom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escom.datamodels.AudiencesItem;
import com.example.escom.datamodels.PesertaResponse;
import com.example.escom.retrofit.TugasClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PesertaActivity extends AppCompatActivity {
    private RecyclerView rvPeserta;
    private ArrayList<Peserta> list = new ArrayList<>();
    SharedPreferences sharedPref;
    private ListPesertaAdapter adapter;
    private int idTheses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peserta);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");

        Intent intent = getIntent();
        if (intent != null) {
            idTheses = intent.getIntExtra("ID",0);
        }
        
        rvPeserta = findViewById(R.id.rv_peserta);
        rvPeserta.setHasFixedSize(true);

        list.addAll(getListPeserta());
        rvPeserta.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ListPesertaAdapter();
        rvPeserta.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ptb-api.husnilkamil.my.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        TugasClient client = retrofit.create(TugasClient.class);

        Call<PesertaResponse> call = client.getPeserta(idTheses, "Bearer " + token);

        call.enqueue(new Callback<PesertaResponse>() {
            @Override
            public void onResponse(Call<PesertaResponse> call, Response<PesertaResponse> response) {
                Log.d("PesertaDebug", response.toString());

                PesertaResponse pesertaResponse = response.body();
                if(pesertaResponse!= null){
                    List<AudiencesItem> peserta = pesertaResponse.getAudiences();
                    adapter.setItemList(peserta);
                }
            }

            @Override
            public void onFailure(Call<PesertaResponse> call, Throwable t) {

            }
        });
    }

    public ArrayList<Peserta> getListPeserta() {
        String[] dataName = getResources().getStringArray(R.array.peserta);
        ArrayList<Peserta> listPeserta = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Peserta peserta = new Peserta();
            peserta.setPeserta(dataName[i]);
            listPeserta.add(peserta);
        }
        return listPeserta;
    }

    public void back(View view) {
        Intent intent = new Intent(PesertaActivity.this,DetailActivity.class);
        startActivity(intent);
    }
}
