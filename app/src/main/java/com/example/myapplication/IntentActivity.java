package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.jar.Attributes;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        TextView txtReciever = findViewById(R.id.recieveText);
        Intent intent =  getIntent();
        String dataComing = intent.getStringExtra("Name");
        txtReciever.setText(dataComing);

    }
}
