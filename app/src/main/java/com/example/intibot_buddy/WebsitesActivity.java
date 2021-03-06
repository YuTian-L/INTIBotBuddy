package com.example.intibot_buddy;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WebsitesActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Info2> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);

        String category = getString(R.string.button_academicINTI);
        setTitle(category.toUpperCase());

        ProgressBar progressBar = findViewById(R.id.progressBarWebsites);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        listView = findViewById(R.id.websitesListView);
        getJSON();
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, Object> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Object doInBackground(Void... voids) {
                try {
                    String link = "http://pkunite2.000webhostapp.com/getID22.php";

                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }

                    return sb.toString();

                } catch (Exception e) {
                    Log.e("WebsitesActivityError", e.getLocalizedMessage());
                    return new String("Exception: " + e.getMessage());
                }
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                try {
                    loadIntoListView((String)o);
                    ProgressBar progressBar = findViewById(R.id.progressBarWebsites);
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void loadIntoListView(String line) throws JSONException {
        items = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(line);
        String[] websites = new String[jsonObject.length()];
        Map<String, String> details = new HashMap<>();

        for (int i=0; jsonObject.has(String.valueOf(i+1)); i++){
            websites[i] = jsonObject.getString(String.valueOf(i+1));
            for (int j=1; jsonObject.has(String.valueOf(i+1)+"info"+String.valueOf(j)); j++) {
                details.put(String.valueOf(i+1)+"info"+String.valueOf(j),jsonObject.getString(String.valueOf(i+1)+"info"+String.valueOf(j)));
            }
        }

        for (int i=1; jsonObject.has(String.valueOf(i)); i++) {
            Info2 item = new Info2(jsonObject.getString(String.valueOf(i)), details.get(String.valueOf(i)+"info"+String.valueOf(1)));
            items.add(item);
        }

        ListViewAdapter2 adapter = new ListViewAdapter2(this, items);
        listView.setAdapter(adapter);
    }
}
