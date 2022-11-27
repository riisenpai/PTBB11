package com.example.escom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SidangActivity extends AppCompatActivity {
    String nama,nim,judul,tanggal,dosen,tempat;
    TextView textNamaMahasiswaDetail,textNIM, textJudul, textDosen, textTanggal, textTempat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidang);

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
            textTanggal = findViewById(R.id.textStatus);
            textTanggal.setText(tanggal);

            dosen = detailIntent.getStringExtra( "DOSEN");
            textDosen = findViewById(R.id.textDosen);
            textDosen.setText(dosen);

            tempat = detailIntent.getStringExtra( "TEMPAT");
            textTempat = findViewById(R.id.textTanggalMulai);
            textTempat.setText(tempat);
        }
    }

    public void back(View view) {
        Intent intent = new Intent(SidangActivity.this,SemdangActivity.class);
        startActivity(intent);
    }

    public void sidangpenguji(View view) {
        Intent intent = new Intent(SidangActivity.this,SidangpengujiActivity.class);
        startActivity(intent);
    }
}
