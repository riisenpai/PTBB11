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

public class MahasiswaActivity extends AppCompatActivity implements ListMahasiswaAdapter.ItemmahasiswaClick{
    BottomNavigationView bottomNavigationView;
    private RecyclerView rvHeroes;
    private ArrayList<Mahasiswa> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswata);

        rvHeroes = findViewById(R.id.rv_mhsTA);
        rvHeroes.setHasFixedSize(true);

        ListMahasiswaAdapter adapter = new ListMahasiswaAdapter(getlistMahasiswa());
        adapter.setListMahasiswa(this);

        list.addAll(getlistMahasiswa());
        showRecyclerList();
    }

    public ArrayList<Mahasiswa> getlistMahasiswa() {
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
        Intent intent = new Intent(MahasiswaActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    public void detail(View view) {
        Intent intent = new Intent(MahasiswaActivity.this,DetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemMahasiswaClick(Mahasiswa mahasiswa) {
        Intent mahasiswaIntent = new Intent(this, DetailActivity.class);
        startActivity(mahasiswaIntent);
    }
}

