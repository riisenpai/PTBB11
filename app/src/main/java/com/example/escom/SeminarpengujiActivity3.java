//package com.example.escom;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.preference.PreferenceManager;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Spinner;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//
//import com.example.escom.datamodels.ReviewerResponse;
//import com.example.escom.retrofit.TugasClient;
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//import okhttp3.OkHttpClient;
//import retrofit2.Call;
//import retrofit2.Retrofit;
//import retrofit2.Callback;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class SeminarpengujiActivity extends AppCompatActivity {
//    BottomNavigationView bottomNavigationView;
//    private Spinner spinnerName1;
//    EditText reviewerId, posisi;
//    SharedPreferences sharedPref;
//    private Button Submit;
//    String token;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_seminarpenguji);
//
//        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
//        token = sharedPref.getString("TOKEN", "");
//
//        reviewerId = findViewById(R.id.textNamaMahasiswaDetail3);
//        posisi = findViewById(R.id.textJudul3);
//
//        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
//        String token = sharedPref.getString("Token", null);
//
//
//        spinnerName1 = (Spinner) findViewById(R.id.spinner1);
//        spinnerName1.setOnItemSelectedListener(new SeminarpengujiActivity.ItemSelectedListener1());
//
//        Submit = findViewById(R.id.button4);
//        Submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ReviewerS();
//            }
//        });
//
////        spinnerName2 = (Spinner) findViewById(R.id.spinner2);
////        spinnerName2.setOnItemSelectedListener(new SeminarpengujiActivity.ItemSelectedListener2());
////
////        spinnerName3 = (Spinner) findViewById(R.id.spinner3);
////        spinnerName3.setOnItemSelectedListener(new SeminarpengujiActivity.ItemSelectedListener3());
//    }
//
//    private void ReviewerS() {
//
//        String lecturer_id = reviewerId.getText().toString();
//        String position = posisi.getText().toString();
//
//        if (lecturer_id.isEmpty()) {
//            reviewerId.setError("fill this field");
//            reviewerId.requestFocus();
//            return;
//        }
//        if (position.isEmpty()) {
//            posisi.setError("fill this field");
//            posisi.requestFocus();
//            return;
//        }
//    }
//
//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("http://ptb-api.husnilkamil.my.id/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(new OkHttpClient.Builder().build())
//            .build();
//
//    TugasClient client = retrofit.create(TugasClient.class);
//
//    Call<ReviewerResponse> call = client.reviewer("Bearer " + token);
//
//    call.enqueue(new Callback<ReviewerResponse>()){
//
//
//    });
//
//
//    public void back(View view) {
//        Intent intent = new Intent(SeminarpengujiActivity.this,SemdangActivity.class);
//        startActivity(intent);
//    }
//
//    public void kesemdang(View view) {
//        Intent intent = new Intent(SeminarpengujiActivity.this,SemdangActivity.class);
//        startActivity(intent);
//    }
//
//    public class ItemSelectedListener1 implements AdapterView.OnItemSelectedListener {
//        String Item1 = String.valueOf(spinnerName1.getSelectedItem());
//
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
//            if (Item1.equals(String.valueOf(spinnerName1.getSelectedItem()))) {
//            }
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> arg) {
//
//        }
//    }
//
////    public class ItemSelectedListener2 implements AdapterView.OnItemSelectedListener {
////        String Item2 = String.valueOf(spinnerName2.getSelectedItem());
////
////        @Override
////        public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
////            if (Item2.equals(String.valueOf(spinnerName2.getSelectedItem()))) {
////            }
////        }
////
////        @Override
////        public void onNothingSelected(AdapterView<?> arg) {
////
////        }
////    }
//
////    public class ItemSelectedListener3 implements AdapterView.OnItemSelectedListener {
////        String Item3 = String.valueOf(spinnerName3.getSelectedItem());
////
////        @Override
////        public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
////            if (Item3.equals(String.valueOf(spinnerName3.getSelectedItem()))) {
////            }
////        }
////
////        @Override
////        public void onNothingSelected(AdapterView<?> arg) {
////
////        }
////    }
//}
