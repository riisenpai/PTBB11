package com.example.escom;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SeminarscheduleActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Seminar> list = new ArrayList<>();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminarschedule);

        rvHeroes = findViewById(R.id.rv_seminar);
        rvHeroes.setHasFixedSize(true);

        list.addAll(getlistSeminar());
        showRecyclerList();
    }

    public ArrayList<Seminar> getlistSeminar() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Seminar> listSeminar = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Seminar seminar = new Seminar();
            seminar.setName(dataName[i]);
            seminar.setDescription(dataDescription[i]);
            seminar.setPhoto(dataPhoto.getResourceId(i, -1));
            listSeminar.add(seminar);
        }
        return listSeminar;
    }

    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListSeminarAdapter listSeminarAdapter = new ListSeminarAdapter(list);
        rvHeroes.setAdapter(listSeminarAdapter);
    }

    public void back(View view) {
        Intent intent = new Intent(SeminarscheduleActivity.this,HomeActivity.class);
        startActivity(intent);
    }

}
