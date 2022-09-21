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

public class SemdangActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    private RecyclerView rvHeroes;
    private ArrayList<Semdang> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semdang);

        rvHeroes = findViewById(R.id.rv_semdang);
        rvHeroes.setHasFixedSize(true);

        list.addAll(getlistSemdang());
        showRecyclerList();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.semdang);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.mahasiswa:
                        startActivity(new Intent(getApplicationContext(),MahasiswaActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.tugasakhir:
                        startActivity(new Intent(getApplicationContext(),PermintaanActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.semdang:
                        return true;

                }
                return false;
            }
        });
    }

    public ArrayList<Semdang> getlistSemdang() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_nim);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Semdang> listSemdang = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Semdang semdang = new Semdang();
            semdang.setName(dataName[i]);
            semdang.setDescription(dataDescription[i]);
            semdang.setPhoto(dataPhoto.getResourceId(i, -1));
            listSemdang.add(semdang);
        }
        return listSemdang;
    }

    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListSemdangAdapter listSemdangAdapter = new ListSemdangAdapter(list);
        rvHeroes.setAdapter(listSemdangAdapter);
    }

    public void back(View view) {
        Intent intent = new Intent(SemdangActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}

