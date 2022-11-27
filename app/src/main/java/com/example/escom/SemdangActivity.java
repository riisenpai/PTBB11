package com.example.escom;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escom.databinding.ActivityLoginBinding;
import com.example.escom.databinding.ActivitySemdangBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SemdangActivity extends AppCompatActivity{
    private ActivitySemdangBinding binding;
    BottomNavigationView bottomNavigationView;
    private RecyclerView rvSemdang;
    private ArrayList<Semdang> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySemdangBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        rvSemdang = findViewById(R.id.rv_semdang);
        rvSemdang.setHasFixedSize(true);

        list.addAll(getlistSemdang());
        showRecyclerList();
    }

    public ArrayList<Semdang> getlistSemdang() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_nim);
        String[] dataJudul = getResources().getStringArray(R.array.judul);
        String[] dataDosen = getResources().getStringArray(R.array.dosen);
        String[] dataTempat = getResources().getStringArray(R.array.tempat);
        String[] dataTanggal = getResources().getStringArray(R.array.tgluji);
        String[] dataPilihan = getResources().getStringArray(R.array.pilihan);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Semdang> listSemdang = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Semdang semdang = new Semdang();
            semdang.setName(dataName[i]);
            semdang.setDescription(dataDescription[i]);
            semdang.setJudul(dataJudul[i]);
            semdang.setDosen(dataDosen[i]);
            semdang.setTanggaluji(dataTanggal[i]);
            semdang.setTempat(dataTempat[i]);
            semdang.setPilihan(dataPilihan[i]);
            semdang.setPhoto(dataPhoto.getResourceId(i, -1));
            listSemdang.add(semdang);
        }
        return listSemdang;
    }

    private void showRecyclerList(){
        rvSemdang.setLayoutManager(new LinearLayoutManager(this));
        ListSemdangAdapter listSemdangAdapter = new ListSemdangAdapter(list);
        rvSemdang.setAdapter(listSemdangAdapter);

        listSemdangAdapter.setOnItemClickCallback(data -> showSelectedSemdang(data));
    }

    private void showSelectedSemdang(Semdang semdang) {
        String pilih="1";

            if (pilih.equals("1")) {
                Intent detailIntent = new Intent(this, SidangActivity.class);
                detailIntent.putExtra("NAMA_AGENDA", semdang.getName());
                detailIntent.putExtra("NIM", semdang.getDescription());
                detailIntent.putExtra("JUDUL", semdang.getJudul());
                detailIntent.putExtra("DOSEN", semdang.getDosen());
                detailIntent.putExtra("TEMPAT", semdang.getTempat());
                detailIntent.putExtra("TANGGAL", semdang.getTanggaluji());
                startActivity(detailIntent);
            } else {
                Intent detailIntent = new Intent(this, SeminarActivity.class);
                detailIntent.putExtra("NAMA_AGENDA", semdang.getName());
                detailIntent.putExtra("NIM", semdang.getDescription());
                detailIntent.putExtra("JUDUL", semdang.getJudul());
                detailIntent.putExtra("DOSEN", semdang.getDosen());
                detailIntent.putExtra("TEMPAT", semdang.getTempat());
                detailIntent.putExtra("TANGGAL", semdang.getTanggaluji());
                startActivity(detailIntent);
            }

        //Toast.makeText(this, "Kamu memilih " + semdang.getName(), Toast.LENGTH_SHORT).show();
    }

    public void back(View view) {
        Intent intent = new Intent(SemdangActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}

