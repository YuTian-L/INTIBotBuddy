package com.example.intibot_buddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WifiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
    }

    public void studentWifi(View view){
        Intent intent = new Intent(this, InjuredActivity.class); //TODO
        startActivity(intent);
    }

    public void hostelWifi(View view){
        Intent intent = new Intent(this, InjuredActivity.class); //TODO
        startActivity(intent);
    }
}
