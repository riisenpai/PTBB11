package com.example.escom;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class PermintaanActivity extends AppCompatActivity implements ListPermintaanAdapter.ItempermintaanClick{
       BottomNavigationView bottomNavigationView;
       private RecyclerView rvHeroes;
       private ArrayList<Mahasiswa> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listpermintaan);

        rvHeroes = findViewById(R.id.rv_listpermintaan);
        rvHeroes.setHasFixedSize(true);

        list.addAll(getlistPermintaan());
        showRecyclerList();
    }

    public ArrayList<Mahasiswa> getlistPermintaan() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setName(dataName[i]);
            mahasiswa.setPhoto(dataPhoto.getResourceId(i, -1));
            listMahasiswa.add(mahasiswa);
        }
        return listMahasiswa;
    }

    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListMahasiswaAdapter listMahasiswaAdapter = new ListMahasiswaAdapter(list);
        rvHeroes.setAdapter(listMahasiswaAdapter);
    }

    public void back(View view) {
        Intent intent = new Intent(PermintaanActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    public void pembimbing(View view) {
        Intent intent = new Intent(PermintaanActivity.this,PembimbingActivity.class);
        startActivity(intent);
    }

//    public void pembimbing(View view) {
//        Intent intent = new Intent(PermintaanActivity.this,PembimbingActivity.class);
//        intent.putExtra("nama_mhs", view.getName());
//        startActivity(intent);
//    }

    @Override
    public void onItemPermintaanClick(Permintaan permintaan) {
        Intent permintaanIntent = new Intent(this, PembimbingActivity.class);
        startActivity(permintaanIntent);
    }
}
