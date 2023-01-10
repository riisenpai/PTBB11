package com.example.escom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SidangpengujiActivity extends AppCompatActivity {
    private Spinner spinnerName1, spinnerName2, spinnerName3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidangpenguji);

        spinnerName1 = (Spinner) findViewById(R.id.spinner1);
        spinnerName1.setOnItemSelectedListener(new ItemSelectedListener1());

//        spinnerName2 = (Spinner) findViewById(R.id.spinner2);
//        spinnerName2.setOnItemSelectedListener(new ItemSelectedListener2());
//
//        spinnerName3 = (Spinner) findViewById(R.id.spinner3);
//        spinnerName3.setOnItemSelectedListener(new ItemSelectedListener3());
    }

    public void back(View view) {
        Intent intent = new Intent(SidangpengujiActivity.this,SemdangActivity.class);
        startActivity(intent);
    }

    public void kesemdang(View view) {
        Intent intent = new Intent(SidangpengujiActivity.this,SemdangActivity.class);
        startActivity(intent);
    }

    public class ItemSelectedListener1 implements AdapterView.OnItemSelectedListener {
        String Item1 = String.valueOf(spinnerName1.getSelectedItem());

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
            if (Item1.equals(String.valueOf(spinnerName1.getSelectedItem()))) {
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }
    }

    public class ItemSelectedListener2 implements AdapterView.OnItemSelectedListener {
        String Item2 = String.valueOf(spinnerName2.getSelectedItem());

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
            if (Item2.equals(String.valueOf(spinnerName2.getSelectedItem()))) {
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }
    }

    public class ItemSelectedListener3 implements AdapterView.OnItemSelectedListener {
        String Item3 = String.valueOf(spinnerName3.getSelectedItem());

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
            if (Item3.equals(String.valueOf(spinnerName3.getSelectedItem()))) {
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }
    }
}
