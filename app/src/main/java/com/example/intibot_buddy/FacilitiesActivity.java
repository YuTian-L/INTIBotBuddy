package com.example.intibot_buddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FacilitiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities);
    }

    public void general(View view){
        Intent intent = new Intent(this, InjuredActivity.class); //TODO
        startActivity(intent);
    }

    public void academicBlock(View view){
        Intent intent = new Intent(this, InjuredActivity.class); //TODO
        startActivity(intent);
    }

    public void hostelArea(View view){
        Intent intent = new Intent(this, InjuredActivity.class); //TODO
        startActivity(intent);
    }

    public void sportsRecreational(View view){
        Intent intent = new Intent(this, InjuredActivity.class); //TODO
        startActivity(intent);
    }
}
