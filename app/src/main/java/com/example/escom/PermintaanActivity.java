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
       private ArrayList<Permintaan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listpermintaan);

        rvHeroes = findViewById(R.id.rv_listpermintaan);
        rvHeroes.setHasFixedSize(true);

        ListPermintaanAdapter adapter = new ListPermintaanAdapter(getlistPermintaan());
        adapter.setOnclick(this);

        list.addAll(getlistPermintaan());
        showRecyclerList();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);

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

                    case R.id.semdang:
                        startActivity(new Intent(getApplicationContext(),SemdangActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.tugasakhir:
                        return true;

                }
                return false;
            }
        });
    }

    public ArrayList<Permintaan> getlistPermintaan() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Permintaan> listPermintaan = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Permintaan permintaan = new Permintaan();
            permintaan.setName(dataName[i]);
            permintaan.setPhoto(dataPhoto.getResourceId(i, -1));
            listPermintaan.add(permintaan);
        }
        return listPermintaan;
    }

    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListPermintaanAdapter listPermintaanAdapter = new ListPermintaanAdapter(list);
        rvHeroes.setAdapter(listPermintaanAdapter);
    }

    public void back(View view) {
        Intent intent = new Intent(PermintaanActivity.this,HomeActivity.class);
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
