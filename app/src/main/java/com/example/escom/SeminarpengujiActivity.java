package com.example.escom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SeminarpengujiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminarpenguji);
    }

    public void back(View view) {
        Intent intent = new Intent(SeminarpengujiActivity.this,SeminarActivity.class);
        startActivity(intent);
    }
}
