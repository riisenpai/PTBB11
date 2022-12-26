package com.example.escom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.escom.databinding.ActivityHomeBinding;
import com.example.escom.databinding.ActivityProfileBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    private ActivityProfileBinding binding;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
        String username = sharedPref.getString("USERNAME", "");
        String password = sharedPref.getString("PASSWORD", "");
        String name = sharedPref.getString("NAME", "");
        String email = sharedPref.getString("EMAIL", "");


        Intent intent = getIntent();
        binding.profilName.setText(name);
        binding.profilUsername.setText(username);
        binding.profilEmail.setText(email);
    }

    public void back(View view) {
        Intent intent = new Intent(ProfileActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}

