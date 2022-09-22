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

public class PermintaanActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    private RecyclerView rvHeroes;
    private ArrayList<Permintaan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permintaan);

        rvHeroes = findViewById(R.id.rv_permintaan);
        rvHeroes.setHasFixedSize(true);

        list.addAll(getlistPermintaan());
        showRecyclerList();
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
}
