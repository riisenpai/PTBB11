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

public class MahasiswaActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    private RecyclerView rvMahasiswa;
    private ArrayList<Mahasiswa> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswata);

        rvMahasiswa = findViewById(R.id.rv_mhsTA);
        rvMahasiswa.setHasFixedSize(true);

        list.addAll(getlistMahasiswa());
        showRecyclerList();
    }

    public ArrayList<Mahasiswa> getlistMahasiswa() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_nim);
        String[] dataJudul = getResources().getStringArray(R.array.judul);
        String[] dataDosen = getResources().getStringArray(R.array.dosen);
        String[] dataTanggal = getResources().getStringArray(R.array.tglmulai);
        String[] dataStatus = getResources().getStringArray(R.array.status);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setName(dataName[i]);
            mahasiswa.setDescription(dataDescription[i]);
            mahasiswa.setJudul(dataJudul[i]);
            mahasiswa.setDosen(dataDosen[i]);
            mahasiswa.setTanggal(dataTanggal[i]);
            mahasiswa.setStatus(dataStatus[i]);
            mahasiswa.setPhoto(dataPhoto.getResourceId(i, -1));
            listMahasiswa.add(mahasiswa);
        }
        return listMahasiswa;
    }

    private void showRecyclerList(){
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(this));
        ListMahasiswaAdapter listMahasiswaAdapter = new ListMahasiswaAdapter(list);
        rvMahasiswa.setAdapter(listMahasiswaAdapter);
        listMahasiswaAdapter.setOnItemClickCallback(data -> showSelectedMahasiswa(data));
    }

    public void back(View view) {
        Intent intent = new Intent(MahasiswaActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    private void showSelectedMahasiswa(Mahasiswa mahasiswa) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra("NAMA_AGENDA", mahasiswa.getName());
        detailIntent.putExtra("NIM", mahasiswa.getDescription());
        detailIntent.putExtra("JUDUL", mahasiswa.getJudul());
        detailIntent.putExtra("DOSEN", mahasiswa.getDosen());
        detailIntent.putExtra("TANGGALMULAI", mahasiswa.getTanggal());
        detailIntent.putExtra("STATUS", mahasiswa.getStatus());
        startActivity(detailIntent);
    }
}

