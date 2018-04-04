package com.example.intibot_buddy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContactsGeneralActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Info4> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_general);

        String category = getString(R.string.button_contacts);
        setTitle(category.toUpperCase());

        ProgressBar progressBar = findViewById(R.id.progressBarContactsGeneral);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        listView = findViewById(R.id.contactsGeneralListView);
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
                    String link = "http://pkunite2.000webhostapp.com/getID51.php";

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
                    Log.e("ContGenActivityError", e.getLocalizedMessage());
                    return new String("Exception: " + e.getMessage());
                }
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                try {
                    loadIntoListView((String)o);
                    ProgressBar progressBar = findViewById(R.id.progressBarContactsGeneral);
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
        String[] contGeneral = new String[jsonObject.length()];
        Map<String, String> details = new HashMap<>();

        for (int i=0; jsonObject.has(String.valueOf(i+1)); i++){
            contGeneral[i] = jsonObject.getString(String.valueOf(i+1));
            for (int j=1; jsonObject.has(String.valueOf(i+1)+"info"+String.valueOf(j)); j++) {
                details.put(String.valueOf(i+1)+"info"+String.valueOf(j),jsonObject.getString(String.valueOf(i+1)+"info"+String.valueOf(j)));
            }
        }

        for (int i=1; jsonObject.has(String.valueOf(i)); i++) {
            Info4 item = new Info4(jsonObject.getString(String.valueOf(i)), details.get(String.valueOf(i)+"info"+String.valueOf(1)), details.get(String.valueOf(i)+"info"+String.valueOf(2)));
            items.add(item);
        }

        ListViewAdapter4 adapter = new ListViewAdapter4(this, items);
        listView.setAdapter(adapter);
    }
}
