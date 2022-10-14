package com.example.escom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    public void back(View view) {
        Intent intent = new Intent(DetailActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    public void mahasiswa(View view) {
        Intent intent = new Intent(DetailActivity.this,MahasiswaActivity.class);
        startActivity(intent);
    }

    public void peserta(View view) {
        Intent intent = new Intent(DetailActivity.this,PesertaActivity.class);
        startActivity(intent);
    }

    public void logbook(View view) {
        Intent intent = new Intent(DetailActivity.this,LogbookActivity.class);
        startActivity(intent);
    }
}
