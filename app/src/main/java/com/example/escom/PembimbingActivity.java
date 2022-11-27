package com.example.escom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class PembimbingActivity  extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private ArrayList<Mahasiswa> list = new ArrayList<>();
    private Spinner spinnerName4;
    String nama, nim, judul, dosen, tanggal;
    TextView textNamaMahasiswaDetail, textNIM, textJudul, textDosen, textTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembimbing);

//        Intent detailIntent = getIntent();
//        if (detailIntent != null){
//            nama = detailIntent.getStringExtra( "NAMA_AGENDA");
//            textNamaMahasiswaDetail = findViewById(R.id.textNamaMahasiswaDetail);
//            textNamaMahasiswaDetail.setText(nama);
//
//            nim = detailIntent.getStringExtra( "NIM");
//            textNIM = findViewById(R.id.textNIM);
//            textNIM.setText(nim);
//
//            judul = detailIntent.getStringExtra( "JUDUL");
//            textJudul = findViewById(R.id.textJudul);
//            textJudul.setText(judul);
//
//            tanggal = detailIntent.getStringExtra( "TANGGAL");
//            textTanggal = findViewById(R.id.textTanggalMulai);
//            textTanggal.setText(tanggal);
//
//            dosen = detailIntent.getStringExtra( "DOSEN");
//            textDosen = findViewById(R.id.textDosen);
//            textDosen.setText(dosen);
//        }

        spinnerName4 = (Spinner) findViewById(R.id.spinner4);
        spinnerName4.setOnItemSelectedListener(new ItemSelectedListener4());
    }

    public void back(View view) {
        Intent intent = new Intent(PembimbingActivity.this,PermintaanActivity.class);
        startActivity(intent);
    }

    public class ItemSelectedListener4 implements AdapterView.OnItemSelectedListener{
        String Item4 = String.valueOf(spinnerName4.getSelectedItem());

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (Item4.equals(String.valueOf(spinnerName4.getSelectedItem()))) {

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
