package com.example.escom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PembimbingActivity  extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    String nama, nim, judul, dosen, tanggal;
    TextView textNamaMahasiswaDetail, textNIM, textJudul, textDosen, textTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembimbing);

        Intent detailIntent = getIntent();
        if (detailIntent != null){
            nama = detailIntent.getStringExtra( "NAMA_AGENDA");
            textNamaMahasiswaDetail = findViewById(R.id.textNamaMahasiswaDetail);
            textNamaMahasiswaDetail.setText(nama);

            nim = detailIntent.getStringExtra( "NIM");
            textNIM = findViewById(R.id.textNIM);
            textNIM.setText(nim);

            judul = detailIntent.getStringExtra( "JUDUL");
            textJudul = findViewById(R.id.textJudul);
            textJudul.setText(judul);

            tanggal = detailIntent.getStringExtra( "TANGGAL");
            textTanggal = findViewById(R.id.textTanggalMulai);
            textTanggal.setText(tanggal);

            dosen = detailIntent.getStringExtra( "DOSEN");
            textDosen = findViewById(R.id.textDosen);
            textDosen.setText(dosen);
        }
    }

    public void back(View view) {
        Intent intent = new Intent(PembimbingActivity.this,PermintaanActivity.class);
        startActivity(intent);
    }
}
