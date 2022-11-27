package com.example.escom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PesertaActivity extends AppCompatActivity {
    private RecyclerView rvPeserta;
    private ArrayList<Peserta> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peserta);

        rvPeserta = findViewById(R.id.rv_peserta);
        rvPeserta.setHasFixedSize(true);

        list.addAll(getListPeserta());
        showRecyclerList();
    }

    public ArrayList<Peserta> getListPeserta() {
        String[] dataName = getResources().getStringArray(R.array.peserta);
        ArrayList<Peserta> listPeserta = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Peserta peserta = new Peserta();
            peserta.setPeserta(dataName[i]);
            listPeserta.add(peserta);
        }
        return listPeserta;
    }

    private void showRecyclerList(){
        rvPeserta.setLayoutManager(new LinearLayoutManager(this));
        ListPesertaAdapter listPesertaAdapter = new ListPesertaAdapter(list);
        rvPeserta.setAdapter(listPesertaAdapter);
    }

    public void back(View view) {
        Intent intent = new Intent(PesertaActivity.this,MahasiswaActivity.class);
        startActivity(intent);
    }
}
