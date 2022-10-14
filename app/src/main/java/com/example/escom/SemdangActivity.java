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
    }

    public ArrayList<Semdang> getlistSemdang() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataNim = getResources().getStringArray(R.array.data_nim);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Semdang> listHero = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Semdang hero = new Semdang();
            hero.setName(dataName[i]);
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            listHero.add(hero);
        }
        return listHero;
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

    public void kepenguji(View view) {
        Intent intent = new Intent(SemdangActivity.this,SidangpengujiActivity.class);
        startActivity(intent);
    }
}

