package com.example.intibot_buddy;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NonIntiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_inti);

        String category = getString(R.string.button_transportationServices);
        setTitle(category.toUpperCase());
    }

    public void localShuttle(View view){
        Intent intent = new Intent(this, LocalShuttleActivity.class);
        startActivity(intent);
    }

    public void taxiService(View view){
        Intent intent = new Intent(this, TaxiServiceActivity.class);
        startActivity(intent);
    }

    public void otherOptions(View view){
        Intent intent = new Intent(this, OtherOptionsActivity.class);
        startActivity(intent);
    }
}
