package com.example.escom;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SidangscheduleActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Sidang> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidangschedule);

        rvHeroes = findViewById(R.id.rv_sidang);
        rvHeroes.setHasFixedSize(true);

        list.addAll(getlistSidang());
        showRecyclerList();
    }

    public ArrayList<Sidang> getlistSidang() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Sidang> listSidang = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Sidang sidang = new Sidang();
            sidang.setName(dataName[i]);
            sidang.setDescription(dataDescription[i]);
            sidang.setPhoto(dataPhoto.getResourceId(i, -1));
            listSidang.add(sidang);
        }
        return listSidang;
    }

    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListSidangAdapter listSidangAdapter = new ListSidangAdapter(list);
        rvHeroes.setAdapter(listSidangAdapter);
    }

    public void back(View view) {
        Intent intent = new Intent(SidangscheduleActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}
