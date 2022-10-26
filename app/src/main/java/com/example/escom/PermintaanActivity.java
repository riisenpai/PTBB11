package com.example.escom;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class PermintaanActivity extends AppCompatActivity{
       BottomNavigationView bottomNavigationView;
       private RecyclerView rvPermintaan;
       private ArrayList<Permintaan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listpermintaan);

        rvPermintaan = findViewById(R.id.rv_listpermintaan);
        rvPermintaan.setHasFixedSize(true);

        list.addAll(getListPermintaan());
        showRecyclerList();
    }

    public ArrayList<Permintaan> getListPermintaan() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_nim);
        String[] dataJudul = getResources().getStringArray(R.array.judul);
        String[] dataDosen = getResources().getStringArray(R.array.dosen);
        String[] dataTanggal = getResources().getStringArray(R.array.tgluji);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Permintaan> listPermintaan = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Permintaan permintaan = new Permintaan();
            permintaan.setName(dataName[i]);
            permintaan.setDescription(dataDescription[i]);
            permintaan.setJudul(dataJudul[i]);
            permintaan.setDosen(dataDosen[i]);
            permintaan.setTanggal(dataTanggal[i]);
            permintaan.setPhoto(dataPhoto.getResourceId(i, -1));
            listPermintaan.add(permintaan);
        }
        return listPermintaan;
    }

    private void showRecyclerList(){
        rvPermintaan.setLayoutManager(new LinearLayoutManager(this));
        ListPermintaanAdapter listPermintaanAdapter = new ListPermintaanAdapter(list);
        rvPermintaan.setAdapter(listPermintaanAdapter);

        listPermintaanAdapter.setOnItemClickCallback(data -> showSelectedPermintaan(data));
    }

    public void back(View view) {
        Intent intent = new Intent(PermintaanActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    private void showSelectedPermintaan(Permintaan permintaan) {
        Intent detailIntent = new Intent(this, PembimbingActivity.class);
        detailIntent.putExtra("NAMA_AGENDA", permintaan.getName());
        detailIntent.putExtra("JUDUL", permintaan.getJudul());
        detailIntent.putExtra("TANGGAL", permintaan.getTanggal());
        detailIntent.putExtra("DOSEN", permintaan.getDosen());
        detailIntent.putExtra("NIM", permintaan.getDescription());
        startActivity(detailIntent);

        //Toast.makeText(this, "Kamu memilih " + permintaan.getName(), Toast.LENGTH_SHORT).show();
    }
}
