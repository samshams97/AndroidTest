package com.example.myapplication.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class SharePreference extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preference);

        final EditText edtName = findViewById(R.id.edtName);
        final EditText edtFamily = findViewById(R.id.edtFamily);
        final EditText edtPhone = findViewById(R.id.edtPhone);
        String  name = PreferenceManager.getDefaultSharedPreferences(SharePreference.this).getString("Name","nothing");
        edtName.setText(name);
        String family = PreferenceManager.getDefaultSharedPreferences(SharePreference.this).getString("Family","nothing");
        edtFamily.setText(family);
        String phone = PreferenceManager.getDefaultSharedPreferences(SharePreference.this).getString("Phone","nothing");
        edtPhone.setText(phone);

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(SharePreference.this)
                        .setTitle("Attention")
                        .setMessage("do you want to save message")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String name = edtName.getText().toString();
                                PreferenceManager.getDefaultSharedPreferences(SharePreference.this).edit().putString("Name",name).apply();
                                String family = edtFamily.getText().toString();
                                PreferenceManager.getDefaultSharedPreferences(SharePreference.this).edit().putString("Family",family).apply();
                                String phone = edtPhone.getText().toString();
                                PreferenceManager.getDefaultSharedPreferences(SharePreference.this).edit().putString("Phone",phone).apply();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SharePreference.this,"no clicked",Toast.LENGTH_LONG).show();
                            }
                        }).setNeutralButton("Later", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SharePreference.this,"remind me later",Toast.LENGTH_LONG).show();
                            }
                        }).create();
                dialog.show();

            }
        });
    }
}
