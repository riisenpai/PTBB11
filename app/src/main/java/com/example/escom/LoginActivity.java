package com.example.escom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.escom.databinding.ActivityLoginBinding;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
 //   TextInputEditText editUsername, editPassword;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//        setContentView(R.layout.activity_login);

//        editUsername = findViewById(R.id.editUsername);
//        editPassword = findViewById(R.id.editPassword);
    }

    public void login(View view) {
        //Explicit Intent
        String username = binding.editUsername.getText().toString();
        String password = binding.editPassword.getText().toString();

//        String username = editUsername.getText().toString();
//        String password = editPassword.getText().toString();

        if( username.equals("Husnil Kamil") && password.equals("12345")) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.putExtra("Username", username);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Opss, username dan password anda salah", Toast.LENGTH_SHORT).show();
        }
    }

    public void forgetPassword(View view){
        //Implisit Intent
        Intent callIntent = new Intent();
        callIntent.setAction(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:62812345"));
        startActivity(callIntent);
    }
}
