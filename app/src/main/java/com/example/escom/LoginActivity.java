package com.example.escom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import com.example.escom.databinding.ActivityLoginBinding;
import com.example.escom.datamodels.Authorisation;
import com.example.escom.datamodels.LoginResponse;
import com.example.escom.retrofit.APIClient;
import com.example.escom.retrofit.TugasClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.messaging.FirebaseMessaging;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText editUsername, editPassword;
    private ActivityLoginBinding binding;
    Button buttonLogin;
    SharedPreferences sharedPref;
    private static final String TAG = "LoginActivity-Debug";
    private NotificationManagerCompat notifMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.login);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editUsername.getText().toString() )|| TextUtils.isEmpty(editPassword.getText().toString())){
                    Toast.makeText(LoginActivity.this,"Isi username dan password", Toast.LENGTH_SHORT).show();
                }
                else{
                    cekLogin();
                }
            }
        });

        String token = sharedPref.getString("Token", null);{
            if(token!=null){
                startActivity( new Intent(this, HomeActivity.class));
            }
        }

//        FirebaseMessaging.getInstance().getToken()
//                .addOnCompleteListener(new OnCompleteListener<String>() {
//                    @Override
//                    public void onComplete(@NonNull Task<String> task) {
//                        if (!task.isSuccessful()) {
//                            Log.w("TAG", "Fetching FCM registration token failed", task.getException());
//                            return;
//                        }
//
//                        // Get new FCM registration token
//                        String tokenn = task.getResult();
//
//                        Log.d("TAG", tokenn);
//                        Toast.makeText(LoginActivity.this, tokenn, Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//        notifMan = NotificationManagerCompat.from(this);
    }

    public void cekLogin(){
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                Log.d("LoginAct-Debug", username + ": " + password);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://ptb-api.husnilkamil.my.id/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient.Builder().build())
                        .build();

                TugasClient client = retrofit.create(TugasClient.class);

                Call<LoginResponse> call = client.login(username,password);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        LoginResponse loginResponse = response.body();
                        if(loginResponse != null ) {
                            Toast.makeText(LoginActivity.this,"Berhasil login", Toast.LENGTH_SHORT).show();

                            String token = loginResponse.getAuthorisation().getToken();
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("TOKEN",token);
                            editor.putString("USERNAME",editUsername.getText().toString());
                            editor.putString("PASSWORD",editPassword.getText().toString());
                            editor.putString("NAME", response.body().getUser().getName());
                            editor.putString("EMAIL", response.body().getUser().getEmail());
                            editor.commit();

                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this,"Waduh, username dan password anda salah", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this,"Gagal menghubungi server", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void forgetPassword(View view){
        //Implisit Intent
        Intent callIntent = new Intent();
        callIntent.setAction(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:62812345"));
        startActivity(callIntent);
    }
}
