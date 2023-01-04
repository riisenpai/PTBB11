package com.example.escom;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escom.datamodels.ListPermintaanTAResponse;
import com.example.escom.datamodels.PermintaanItem;
import com.example.escom.retrofit.TugasClient;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PermintaanActivity extends AppCompatActivity{
    private RecyclerView rvPermintaan;
    private static final String CHANNEL_ID = "test_kanal";
    private NotificationManagerCompat notificationPermintaan;
    private Button buttonShow2;
    private ArrayList<Permintaan> listPermintaan = new ArrayList<>();
    private ListPermintaanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listpermintaan);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");

        rvPermintaan = findViewById(R.id.rv_listpermintaan);
        rvPermintaan.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ListPermintaanAdapter();
        rvPermintaan.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ptb-api.husnilkamil.my.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        TugasClient client = retrofit.create(TugasClient.class);

        Call<ListPermintaanTAResponse> call = client.listPermintaan("Bearer " + token);

        call.enqueue(new Callback<ListPermintaanTAResponse>() {


                         @Override
                         public void onResponse(Call<ListPermintaanTAResponse> call, Response<ListPermintaanTAResponse> response) {

                             Log.d("debug-act", response.toString());

                             ListPermintaanTAResponse PermintaanTAResponse = response.body();
                             if (PermintaanTAResponse != null) {
                                 List<PermintaanItem> thesis = PermintaanTAResponse.getThesis();
                                 adapter.setListPermintaan(thesis);
                             }
                         }
                         @Override
                         public void onFailure(Call<ListPermintaanTAResponse> call, Throwable t) {

                         }
                     });

        buttonShow2 = findViewById(R.id.tambah_permintaan);
        buttonShow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PermintaanActivity.this,PembimbingActivity.class);
                startActivity(intent);


                Intent resultIntent = new Intent(PermintaanActivity.this, PermintaanActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(PermintaanActivity.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(PermintaanActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.mahasiswa)
                        .setContentTitle("Info Mahasiswa (Permintaan Pembimbing)")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("Terdapat penambahan mahasiswa yang mengajukan permintaan Pembimbing"))
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.mahasiswa, "Lihat", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationPermintaan.notify(112, builder.build());
            }
        });

        notificationPermintaan = NotificationManagerCompat.from(this);
        createNotificationChannel2();

    }

    private void createNotificationChannel2() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notifikasi";
            String description = "Notifikasi Permintaan Pembimbing";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel2 = new NotificationChannel(CHANNEL_ID, name, importance);
            channel2.setDescription(description);
            notificationPermintaan.createNotificationChannel(channel2);
        }
    }

    public List<Permintaan> getListPermintaan() {
        TextInputEditText data_name;
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_nim);
        String[] dataJudul = getResources().getStringArray(R.array.judul);
        String[] dataDosen = getResources().getStringArray(R.array.dosen);
        String[] dataTanggal = getResources().getStringArray(R.array.tgluji);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        List<Permintaan> listPermintaan = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Permintaan permintaan = new Permintaan();
            permintaan.setName(dataName[i]);
            permintaan.setDescription(dataDescription[i]);
            permintaan.setJudul(dataJudul[i]);
            permintaan.setDosen(dataDosen[i]);
            permintaan.setTanggal(dataTanggal[i]);
            permintaan.setPhoto(dataPhoto.getResourceId(i, -1));
            listPermintaan.add(permintaan);
        }
        return listPermintaan;
    }

//    private void showRecyclerList(){
//        rvPermintaan.setLayoutManager(new LinearLayoutManager(this));
//        ListPermintaanAdapter listPermintaanAdapter = new ListPermintaanAdapter(listPermintaan);
//        rvPermintaan.setAdapter(listPermintaanAdapter);
//
//        listPermintaanAdapter.setOnItemClickCallback(data -> showSelectedPermintaan(data));
//    }

    public void back(View view) {
        Intent intent = new Intent(PermintaanActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    private void showSelectedPermintaan(PermintaanItem permintaan) {
        Intent detailIntent = new Intent(this, PembimbingActivity.class);
//        detailIntent.putExtra("NAMA_AGENDA", permintaan.getStudent().getName());
//        detailIntent.putExtra("JUDUL", permintaan.getJudul());
//        detailIntent.putExtra("TANGGAL", permintaan.getTanggal());
//        detailIntent.putExtra("DOSEN", permintaan.getDosen());
//        detailIntent.putExtra("NIM", permintaan.getDescription());
        startActivity(detailIntent);
    }

}
