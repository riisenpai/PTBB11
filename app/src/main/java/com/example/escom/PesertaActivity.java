package com.example.escom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PesertaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peserta);
    }
    public void back(View view) {
        Intent intent = new Intent(PesertaActivity.this,DetailActivity.class);
        startActivity(intent);
    }
}
