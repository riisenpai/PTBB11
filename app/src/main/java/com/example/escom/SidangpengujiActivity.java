package com.example.escom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SidangpengujiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidangpenguji);
    }

    public void back(View view) {
        Intent intent = new Intent(SidangpengujiActivity.this,SidangActivity.class);
        startActivity(intent);
    }

    public void kesemdang(View view) {
        Intent intent = new Intent(SidangpengujiActivity.this,SemdangActivity.class);
        startActivity(intent);
    }
}
