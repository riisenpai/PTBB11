package com.example.escom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SidangActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidang);
    }

    public void back(View view) {
        Intent intent = new Intent(SidangActivity.this,SemdangActivity.class);
        startActivity(intent);
    }
}