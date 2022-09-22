package com.example.escom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SeminarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar);
    }

    public void back(View view) {
        Intent intent = new Intent(SeminarActivity.this,SemdangActivity.class);
        startActivity(intent);
    }

    public void seminarpenguji(View view) {
        Intent intent = new Intent(SeminarActivity.this,SeminarpengujiActivity.class);
        startActivity(intent);
    }
}
