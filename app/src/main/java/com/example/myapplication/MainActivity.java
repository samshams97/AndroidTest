
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ModelClass> folder = new ArrayList<>();
        folder.add(new ModelClass("gone girl",R.drawable.ic_launcher_background));
        folder.add(new ModelClass("fury",R.drawable.ic_launcher_background));
        folder.add(new ModelClass("fury",R.drawable.ic_launcher_background));
        folder.add(new ModelClass("fury",R.drawable.ic_launcher_background));
        folder.add(new ModelClass("fury",R.drawable.ic_launcher_background));
        folder.add(new ModelClass("fury",R.drawable.ic_launcher_background));
        folder.add(new ModelClass("fury",R.drawable.ic_launcher_background));
        folder.add(new ModelClass("fury",R.drawable.ic_launcher_background));
        folder.add(new ModelClass("fury",R.drawable.ic_launcher_background));
        folder.add(new ModelClass("fury",R.drawable.ic_launcher_background));
        folder.add(new ModelClass("fury",R.drawable.ic_launcher_background));

        RecyclerView recyclerView = findViewById(R.id.recycler);
        TestAdapter adapter = new TestAdapter(folder);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));

        final EditText edtIntent = findViewById(R.id.edtIntent);
        Button btnToast = findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edtN = edtIntent.getText().toString();
                Intent intent = new Intent(MainActivity.this,IntentActivity.class);
                intent.putExtra("Name",edtN);
                startActivity(intent);
            }
        });
        final Button inIntent = findViewById(R.id.imIntent);
        inIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"this my text");
                intent.setType("text/plain");
                startActivity(intent);

            }
        });





    }
}
