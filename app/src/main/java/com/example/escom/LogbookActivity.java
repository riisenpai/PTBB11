package com.example.escom;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LogbookActivity extends AppCompatActivity {
    private RecyclerView rvLogbook;
    private ArrayList<Logbook> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook);

        rvLogbook = findViewById(R.id.rv_logbook);
        rvLogbook.setHasFixedSize(true);

        list.addAll(getListLogbook());
        showRecyclerList();
    }

    public ArrayList<Logbook> getListLogbook() {
        String[] dataName = getResources().getStringArray(R.array.tanggalLogbook);
        String[] dataDescription = getResources().getStringArray(R.array.kegiatanLogbook);
        ArrayList<Logbook> listLogbook = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Logbook logbook = new Logbook();
            logbook.setTglLogbook(dataName[i]);
            logbook.setKegiatanLogbook(dataDescription[i]);
            listLogbook.add(logbook);
        }
        return listLogbook;
    }

    private void showRecyclerList(){
        rvLogbook.setLayoutManager(new LinearLayoutManager(this));
        ListLogbookAdapter listLogbookAdapter = new ListLogbookAdapter(list);
        rvLogbook.setAdapter(listLogbookAdapter);
    }

    public void back(View view) {
        Intent intent = new Intent(LogbookActivity.this,MahasiswaActivity.class);
        startActivity(intent);
    }
}
