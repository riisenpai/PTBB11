package com.example.escom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escom.datamodels.ListPermintaanTAResponse;
import com.example.escom.datamodels.LogbookResponse;
import com.example.escom.datamodels.LogbooksItem;
import com.example.escom.datamodels.PermintaanItem;
import com.example.escom.retrofit.TugasClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LogbookActivity extends AppCompatActivity {
    private RecyclerView rvLogbook;
    private List<LogbooksItem> logbook = new ArrayList<>();
    private ListLogbookAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");

        rvLogbook = findViewById(R.id.rv_logbook);
        rvLogbook.setLayoutManager(new LinearLayoutManager(this));

        adapter2 = new ListLogbookAdapter();
        rvLogbook.setAdapter(adapter2);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ptb-api.husnilkamil.my.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        TugasClient client = retrofit.create(TugasClient.class);

        Call<LogbookResponse> call = client.logbook("Bearer " + token);

        call.enqueue(new Callback<LogbookResponse>() {
            @Override
            public void onResponse(Call<LogbookResponse> call, Response<LogbookResponse> response) {
                Log.d("debug-log", response.toString());
                LogbookResponse logbookResponse = response.body();
                if (logbookResponse != null) {
                    List<LogbooksItem> Listlogbook = logbookResponse.getLogbooks();
                    adapter2.setListLogbook(Listlogbook);
                }
            }

            @Override
            public void onFailure(Call<LogbookResponse> call, Throwable t) {

            }
        });

    }
//
//    public ArrayList<Logbook> getListLogbook() {
//        String[] dataName = getResources().getStringArray(R.array.tanggalLogbook);
//        String[] dataDescription = getResources().getStringArray(R.array.kegiatanLogbook);
//        ArrayList<Logbook> listLogbook = new ArrayList<>();
//        for (int i = 0; i < dataName.length; i++) {
//            Logbook logbook = new Logbook();
//            logbook.setTglLogbook(dataName[i]);
//            logbook.setKegiatanLogbook(dataDescription[i]);
//            listLogbook.add(logbook);
//        }
//        return listLogbook;
//    }

//    private void showRecyclerList(){
//        rvLogbook.setLayoutManager(new LinearLayoutManager(this));
//        ListLogbookAdapter listLogbookAdapter = new ListLogbookAdapter(logbook);
//        rvLogbook.setAdapter(listLogbookAdapter);
//    }

    public void back(View view) {
        Intent intent = new Intent(LogbookActivity.this,MahasiswaActivity.class);
        startActivity(intent);
    }
}
