package com.example.escom;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String username = "Husnil Kamil";

        binding.nama.setText(username);
    }

    public void back(View view) {
        Intent intent = new Intent(ProfileActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}

