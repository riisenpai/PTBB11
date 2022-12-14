package com.example.escom;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.escom.databinding.ActivityHomeBinding;
import com.example.escom.datamodels.LoginResponse;
import com.example.escom.datamodels.LogoutResponse;
import com.example.escom.retrofit.TugasClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "test_kanal";
    BottomNavigationView bottomNavigationView;
    private ActivityHomeBinding binding;
    private NotificationManagerCompat notificationManagerMhsTA, notificationToken;
    Button buttonShow, buttonShow2;
    ImageView buttonLogout;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        buttonLogout = findViewById(R.id.logout);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        String username = sharedPref.getString("USERNAME", "");
        String password = sharedPref.getString("PASSWORD", "");
        String name = sharedPref.getString("NAME", "");

        Intent intent = getIntent();
        binding.textGreeting.setText("Hello " + name);

        buttonShow = findViewById(R.id.tambah_mahasiswata);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(HomeActivity.this, MahasiswaActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(HomeActivity.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(HomeActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.mahasiswa)
                        .setContentTitle("Info Mahasiswa")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("Terjadi penambahan mahasiswa yang melaksanakan Tugas Akhir (TA)"))
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.mahasiswa, "Lihat", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationManagerMhsTA.notify(111, builder.build());
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LoginAct-Debug", username + ": " + password);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://ptb-api.husnilkamil.my.id/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient.Builder().build())
                        .build();

                TugasClient client = retrofit.create(TugasClient.class);

                Call<LogoutResponse> call = client.logout("Bearer " + token);

                call.enqueue(new Callback<LogoutResponse>() {
                    @Override
                    public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                        LogoutResponse logoutResponse = response.body();
                        SharedPreferences sharedPref = getSharedPreferences("prefs",Context. MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("TOKEN",null);
                        editor.clear();
                        editor.apply();

                        Toast.makeText(HomeActivity.this,"Successfully Log Out", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<LogoutResponse> call, Throwable t) {

                    }
                });
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.hlmhome);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.hlmprofile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.hlmmahasiswa:
                        startActivity(new Intent(getApplicationContext(),MahasiswaActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.hlmsemdang:
                        startActivity(new Intent(getApplicationContext(),SemdangActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.hlmtugasakhir:
                        startActivity(new Intent(getApplicationContext(),PermintaanActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.hlmhome:
                        return true;

                }
                return false;
            }


        });

        //Ambil notifikasi manager
        notificationManagerMhsTA = NotificationManagerCompat.from(this);
        //Buat channel notifikasi
        createNotificationChannel();

        buttonShow = findViewById(R.id.tambah_mahasiswata);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(HomeActivity.this, MahasiswaActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(HomeActivity.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                //Builder untuk notifikasi
                NotificationCompat.Builder builder = new NotificationCompat.Builder(HomeActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.mahasiswa)
                        .setContentTitle("Info Mahasiswa (Mahasiswa TA Bertambah)")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("Terdapat penambahan mahasiswa yang melakukan TA"))
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.mahasiswa, "Lihat", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                //Objek dan nampilkan notifikasi
                notificationManagerMhsTA.notify(111, builder.build());
            }
        });
    }
    //Channel Notifikasi Manual Untuk Mahasiswa TA
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notifikasi";
            String description = "Notifikasi Mahasiswa TA Bertambah";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManagerMhsTA.createNotificationChannel(channel);
        }
    }

    public void sidang(View view) {
        Intent intent = new Intent(HomeActivity.this,SidangscheduleActivity.class);
        startActivity(intent);
    }

    public void seminar(View view) {
        Intent intent = new Intent(HomeActivity.this,SeminarscheduleActivity.class);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    public void semdang(View view) {
        Intent intent = new Intent(HomeActivity.this,SemdangActivity.class);
        startActivity(intent);
    }

    public void detail(View view) {
        Intent intent = new Intent(HomeActivity.this,DetailActivity.class);
        startActivity(intent);
    }
}

