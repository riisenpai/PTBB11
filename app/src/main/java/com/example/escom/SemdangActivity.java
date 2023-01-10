package com.example.escom;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escom.databinding.ActivityLoginBinding;
import com.example.escom.databinding.ActivitySemdangBinding;
import com.example.escom.datamodels.ListPermintaanTAResponse;
import com.example.escom.datamodels.PermintaanItem;
import com.example.escom.datamodels.SemhasResponse;
import com.example.escom.datamodels.SeminarsItem;
import com.example.escom.retrofit.TugasClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SemdangActivity extends AppCompatActivity{
    private RecyclerView rvSemdang;
    private static final String CHANNEL_ID = "test_kanal";
    private ActivitySemdangBinding binding;
    private NotificationManagerCompat notificationSemdang;
    private Button buttonShow3;
    private ArrayList<Semdang> listSemdang = new ArrayList<>();
    private ListSemdangAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semdang);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");

        rvSemdang = findViewById(R.id.rv_semdang);
        rvSemdang.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ListSemdangAdapter();
        rvSemdang.setAdapter(adapter);
//        list.addAll(getlistSemdang());
//        showRecyclerList();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ptb-api.husnilkamil.my.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        TugasClient client = retrofit.create(TugasClient.class);

        Call<SemhasResponse> call = client.listSemhas("Bearer " + token);

        call.enqueue(new Callback<SemhasResponse>() {

            @Override
            public void onResponse(Call<SemhasResponse> call, Response<SemhasResponse> response) {
                Log.d("debug-act", response.toString());

                SemhasResponse SemResponse = response.body();
                if (SemResponse != null) {
                    List<SeminarsItem> seminars = SemResponse.getSeminars();
                    adapter.setListSemdang(seminars);
                }
            }

            @Override
            public void onFailure(Call<SemhasResponse> call, Throwable t) {

            }
        });

        notificationSemdang = NotificationManagerCompat.from(this);
        createNotificationChannel3();

        buttonShow3 = findViewById(R.id.tambah_mahasiswasemdang);
        buttonShow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(SemdangActivity.this, SemdangActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(SemdangActivity.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(SemdangActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.mahasiswa)
                        .setContentTitle("Info Mahasiswa (Permintaan Seminar)")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("Terdapat penambahan mahasiswa yang mengajukan seminar"))
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.mahasiswa, "Lihat", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationSemdang.notify(113, builder.build());
            }
        });

        notificationSemdang = NotificationManagerCompat.from(this);
        createNotificationChannel3();
    }

    private void createNotificationChannel3() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notifikasi";
            String description = "Notifikasi List Seminar Sidang";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel3 = new NotificationChannel(CHANNEL_ID, name, importance);
            channel3.setDescription(description);
            notificationSemdang.createNotificationChannel(channel3);
        }
    }

    public List<Semdang> getListSemdang() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_nim);
        String[] dataJudul = getResources().getStringArray(R.array.judul);
        String[] dataDosen = getResources().getStringArray(R.array.dosen);
        String[] dataTempat = getResources().getStringArray(R.array.tempat);
        String[] dataTanggal = getResources().getStringArray(R.array.tgluji);
//        String[] dataPilihan = getResources().getStringArray(R.array.pilihan);
//        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        List<Semdang> listSemdang = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Semdang semdang = new Semdang();
            semdang.setName(dataName[i]);
            semdang.setDescription(dataDescription[i]);
            semdang.setJudul(dataJudul[i]);
            semdang.setDosen(dataDosen[i]);
            semdang.setTanggaluji(dataTanggal[i]);
            semdang.setTempat(dataTempat[i]);
//            semdang.setPilihan(dataPilihan[i]);
//            semdang.setPhoto(dataPhoto.getResourceId(i, -1));
            listSemdang.add(semdang);
        }
        return listSemdang;
    }

//    private void showRecyclerList(){
//        rvSemdang.setLayoutManager(new LinearLayoutManager(this));
//        ListSemdangAdapter listSemdangAdapter = new ListSemdangAdapter(list);
//        rvSemdang.setAdapter(listSemdangAdapter);
//
//        listSemdangAdapter.setOnItemClickCallback(data -> showSelectedSemdang(data));
//    }

    private void showSelectedSemdang(Semdang semdang) {
//        String pilih="1";
//
//            if (pilih.equals("1")) {
//                Intent detailIntent = new Intent(this, SidangActivity.class);
//                detailIntent.putExtra("NAMA_AGENDA", semdang.getName());
//                detailIntent.putExtra("NIM", semdang.getDescription());
//                detailIntent.putExtra("JUDUL", semdang.getJudul());
//                detailIntent.putExtra("DOSEN", semdang.getDosen());
//                detailIntent.putExtra("TEMPAT", semdang.getTempat());
//                detailIntent.putExtra("TANGGAL", semdang.getTanggaluji());
//                startActivity(detailIntent);
//            } else {
                Intent detailIntent = new Intent(this, SeminarActivity.class);
                detailIntent.putExtra("NAMA_AGENDA", semdang.getName());
                detailIntent.putExtra("NIM", semdang.getDescription());
                detailIntent.putExtra("JUDUL", semdang.getJudul());
                detailIntent.putExtra("DOSEN", semdang.getDosen());
                detailIntent.putExtra("TEMPAT", semdang.getTempat());
                detailIntent.putExtra("TANGGAL", semdang.getTanggaluji());
                startActivity(detailIntent);
//            }

        //Toast.makeText(this, "Kamu memilih " + semdang.getName(), Toast.LENGTH_SHORT).show();
    }

    public void back(View view) {
        Intent intent = new Intent(SemdangActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}

