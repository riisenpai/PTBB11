package com.example.escom;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SidangscheduleActivity extends AppCompatActivity {
    private RecyclerView rvSidschedule;
    private ArrayList<Sidang> list = new ArrayList<>();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidangschedule);

        rvSidschedule = findViewById(R.id.rv_sidang);
        rvSidschedule.setHasFixedSize(true);

        list.addAll(getlistSidang());
        showRecyclerList();
    }

    public ArrayList<Sidang> getlistSidang() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        String[] dataWaktu = getResources().getStringArray(R.array.waktu);
        String[] dataTempat = getResources().getStringArray(R.array.tempat);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Sidang> listSidang = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Sidang sidang = new Sidang();
            sidang.setName(dataName[i]);
            sidang.setWaktu(dataWaktu[i]);
            sidang.setTempat(dataTempat[i]);
            sidang.setDescription(dataDescription[i]);
            sidang.setPhoto(dataPhoto.getResourceId(i, -1));
            listSidang.add(sidang);
        }
        return listSidang;
    }

    private void showRecyclerList(){
        rvSidschedule.setLayoutManager(new LinearLayoutManager(this));
        ListSidangAdapter listSidangAdapter = new ListSidangAdapter(list);
        rvSidschedule.setAdapter(listSidangAdapter);
    }

    public void back(View view) {
        Intent intent = new Intent(SidangscheduleActivity.this,HomeActivity.class);
        startActivity(intent);
    }

}
