package com.example.intibot_buddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
    }

    public void generalContacts(View view){
        Intent intent = new Intent(this, InjuredActivity.class); //TODO
        startActivity(intent);
    }

    public void academicBlockContacts(View view){
        Intent intent = new Intent(this, InjuredActivity.class); //TODO
        startActivity(intent);
    }

    public void hostelAreaContacts(View view){
        Intent intent = new Intent(this, InjuredActivity.class); //TODO
        startActivity(intent);
    }

    public void others(View view){
        Intent intent = new Intent(this, InjuredActivity.class); //TODO
        startActivity(intent);
    }
}
