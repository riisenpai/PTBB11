package com.example.escom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SidangscheduleActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Sidang> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidangschedule);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        list.addAll(getListSidang());
        showRecyclerList();
    }

    public ArrayList<SIdang> getListHeroes() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Sidang> listSidang = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Sidang sidang = new Sidang();
            sidang.setName(dataName[i]);
            sidang.setDescription(dataDescription[i]);
            sidang.setPhoto(dataPhoto.getResourceId(i, -1));
            listSidang.add(sidang);
        }
        return listSidang;
    }

    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListSidangAdapter listSidangAdapter = new ListSidangAdapter(list);
        rvHeroes.setAdapter(listSidangAdapter);
    }
}
