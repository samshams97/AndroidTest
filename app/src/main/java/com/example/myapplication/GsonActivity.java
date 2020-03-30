package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.movie.com.example.myapplication.Movie;
import com.example.myapplication.movie.com.example.myapplication.Search;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class GsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        Intent intent = getIntent();
        String id = intent.getStringExtra("Movie");
        final  String address = "https://www.omdbapi.com/?s= "+id+" &apikey=70ad462a";

            final AsyncHttpClient client = new AsyncHttpClient();
            client.get(address, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    super.onSuccess(statusCode, headers, response);
                    Gson gson = new Gson();
                    Movie movie = gson.fromJson(response.toString(), Movie.class);
                    RecyclerView recyclerView = findViewById(R.id.recycler);
                    TestAdapter adapter = new TestAdapter(movie.getSearch());
                    recyclerView.setLayoutManager(new LinearLayoutManager(GsonActivity.this, RecyclerView.VERTICAL, false));
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                }
            });

    }
}
