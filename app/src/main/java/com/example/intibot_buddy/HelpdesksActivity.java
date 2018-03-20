package com.example.intibot_buddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelpdesksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpdesks);
    }

    public void IThelpdesk(View view){
        Intent intent = new Intent(this, ItHelpdeskActivity.class);
        startActivity(intent);
    }

    public void AFMhelpdesk(View view){
        Intent intent = new Intent(this, AfmHelpdeskActivity.class);
        startActivity(intent);
    }

    public void onlineSuggestion(View view){
        Intent intent = new Intent(this, OnlineSuggestionActivity.class);
        startActivity(intent);
    }

    public void makeEnquiry(View view){
        Intent intent = new Intent(this, MakeEnquiryActivity.class);
        startActivity(intent);
    }
}
