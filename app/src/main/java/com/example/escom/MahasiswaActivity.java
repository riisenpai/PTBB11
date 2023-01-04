package com.example.escom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escom.datamodels.DetailResponse;
import com.example.escom.datamodels.ThesesItem;
import com.example.escom.datamodels.ThesesResponse;
import com.example.escom.retrofit.TugasClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MahasiswaActivity<MahasiswaActivityAdapter> extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    private RecyclerView rvMahasiswa;
    private ArrayList<Mahasiswa> list = new ArrayList<>();
    SharedPreferences sharedPref;
    private ListMahasiswaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswata);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        //Toast.makeText(MahasiswaActivity.this, token, Toast.LENGTH_SHORT).show();

        rvMahasiswa = findViewById(R.id.rv_mhsTA);
        rvMahasiswa.setHasFixedSize(true);

        list.addAll(getlistMahasiswa());
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ListMahasiswaAdapter();
        rvMahasiswa.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ptb-api.husnilkamil.my.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        TugasClient client = retrofit.create(TugasClient.class);

        Call<ThesesResponse> call = client.getTheses("Bearer " + token);

        call.enqueue(new Callback<ThesesResponse>() {
            @Override
            public void onResponse(Call<ThesesResponse> call, Response<ThesesResponse> response) {
                Log.d("MahasiswaDebug", response.toString());

                ThesesResponse thesesResponse = response.body();
                if(thesesResponse!= null){
                        List<ThesesItem> theses = thesesResponse.getTheses();
                        Log.d("MahasiswaDebug2", String.valueOf(theses.size()));
                        adapter.setItemList(theses);

                }
            }

            @Override
            public void onFailure(Call<ThesesResponse> call, Throwable t) {

            }
        });

    }

    public ArrayList<Mahasiswa> getlistMahasiswa() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_nim);
        String[] dataJudul = getResources().getStringArray(R.array.judul);
        String[] dataDosen = getResources().getStringArray(R.array.dosen);
        String[] dataTanggal = getResources().getStringArray(R.array.tglmulai);
        String[] dataStatus = getResources().getStringArray(R.array.status);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setName(dataName[i]);
            mahasiswa.setDescription(dataDescription[i]);
            mahasiswa.setJudul(dataJudul[i]);
            mahasiswa.setDosen(dataDosen[i]);
            mahasiswa.setTanggal(dataTanggal[i]);
            mahasiswa.setStatus(dataStatus[i]);
            mahasiswa.setPhoto(dataPhoto.getResourceId(i, -1));
            listMahasiswa.add(mahasiswa);
        }
        return listMahasiswa;
    }

    public void back(View view) {
        Intent intent = new Intent(MahasiswaActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    private void showSelectedMahasiswa(Mahasiswa mahasiswa) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra("NAMA_AGENDA", mahasiswa.getName());
        detailIntent.putExtra("NIM", mahasiswa.getDescription());
        detailIntent.putExtra("JUDUL", mahasiswa.getJudul());
        detailIntent.putExtra("DOSEN", mahasiswa.getDosen());
        detailIntent.putExtra("TANGGALMULAI", mahasiswa.getTanggal());
        detailIntent.putExtra("STATUS", mahasiswa.getStatus());
        startActivity(detailIntent);
    }
}

