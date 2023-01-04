package com.example.escom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.escom.datamodels.LoginResponse;
import com.example.escom.datamodels.PembimbingResponse;
import com.example.escom.retrofit.TugasClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PembimbingActivity  extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private Spinner spinnerName4;
    String nama, nim, judul, dosen, tanggal;
    TextView textNamaMahasiswaDetail, textNIM, textJudul, textDosen, textTanggal;
    EditText id_lecturer, posisi;
    SharedPreferences sharedPref;
    private Button Submit;
    String token;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembimbing);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        id_lecturer = findViewById(R.id.textNamaMahasiswaDetail);
        posisi = findViewById(R.id.textJudul);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String token = sharedPref.getString("Token", null);

//        String lecturer_id = id_lecturer.getText().toString();
//        String position = posisi.getText().toString();

        Submit = findViewById(R.id.submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PembimbingTA();
            }
        });
    }

        private void PembimbingTA() {

                String lecturer_id = id_lecturer.getText().toString();
                String position = posisi.getText().toString();

                if (lecturer_id.isEmpty()) {
                    id_lecturer.setError("fill this field");
                    id_lecturer.requestFocus();
                    return;
                }
                if (position.isEmpty()) {
                    posisi.setError("fill this field");
                    posisi.requestFocus();
                    return;
        }


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ptb-api.husnilkamil.my.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        TugasClient client = retrofit.create(TugasClient.class);

        Call<PembimbingResponse> call = client.pembimbing("Bearer " + token, lecturer_id, position);

        call.enqueue(new Callback<PembimbingResponse>() {


                         @Override
                         public void onResponse(Call<PembimbingResponse> call, Response<PembimbingResponse> response) {
                             if (response.isSuccessful()) {
                             PembimbingResponse pembimbingResponse = response.body();
                             if (pembimbingResponse != null) {
//                             SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
//                             Log.d("debug-act2", response.toString());
//                             SharedPreferences.Editor editor = sharedPref.edit();
//                             editor.putString("TOKEN",token);
//                             editor.putString("LECTURER_ID",id_lecturer.getText().toString());
//                             editor.putString("POSITION",posisi.getText().toString());
//                             editor.apply();

                             Toast.makeText(PembimbingActivity.this, pembimbingResponse.getMessage(), Toast.LENGTH_SHORT).show();

                         }

                         }  else {
                Toast.makeText(PembimbingActivity.this, "Gagal Menambahkan Pembimbing", Toast.LENGTH_SHORT).show();
            }
        }

                         @Override
                         public void onFailure(Call<PembimbingResponse> call, Throwable t) {

                         }
                     });



//        Intent detailIntent = getIntent();
//        if (detailIntent != null){
//            nama = detailIntent.getStringExtra( "NAMA_AGENDA");
//            textNamaMahasiswaDetail = findViewById(R.id.textNamaMahasiswaDetail);
//            textNamaMahasiswaDetail.setText(nama);
//
//            nim = detailIntent.getStringExtra( "NIM");
//            textNIM = findViewById(R.id.textNIM);
//            textNIM.setText(nim);
//
//            judul = detailIntent.getStringExtra( "JUDUL");
//            textJudul = findViewById(R.id.textJudul);
//            textJudul.setText(judul);
//
//            tanggal = detailIntent.getStringExtra( "TANGGAL");
//            textTanggal = findViewById(R.id.textTanggalMulai);
//            textTanggal.setText(tanggal);
//
//            dosen = detailIntent.getStringExtra( "DOSEN");
//            textDosen = findViewById(R.id.textDosen);
//            textDosen.setText(dosen);
//        }

        spinnerName4 = (Spinner) findViewById(R.id.spinner4);
        spinnerName4.setOnItemSelectedListener(new ItemSelectedListener4());
    }




    public void back(View view) {
        Intent intent = new Intent(PembimbingActivity.this,PermintaanActivity.class);
        startActivity(intent);
    }

    public class ItemSelectedListener4 implements AdapterView.OnItemSelectedListener{
        String Item4 = String.valueOf(spinnerName4.getSelectedItem());

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (Item4.equals(String.valueOf(spinnerName4.getSelectedItem()))) {

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {


        }

    }
    public void submit(View view) {
        Intent intent = new Intent(PembimbingActivity.this, PermintaanActivity.class);
        startActivity(intent);
    }
}