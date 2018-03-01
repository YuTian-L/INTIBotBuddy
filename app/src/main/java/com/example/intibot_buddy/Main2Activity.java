package com.example.intibot_buddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //setTitle("MAIN MENU");
    }

    public void safety(View view){
        Intent intent = new Intent(this, SafetyActivity.class);
        startActivity(intent);
    }

    public void academic(View view){
        Intent intent = new Intent(this, AcademicActivity.class);
        startActivity(intent);
    }

    public void transportation(View view){
        Intent intent = new Intent(this, TransportationActivity.class);
        startActivity(intent);
    }

    public void facilities(View view){
        Intent intent = new Intent(this, FacilitiesActivity.class);
        startActivity(intent);
    }

    public void contacts(View view){
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

    public void activities(View view){
        Intent intent = new Intent(this, ActivitiesActivity.class);
        startActivity(intent);
    }

    public void helpdesks(View view){
        Intent intent = new Intent(this, HelpdesksActivity.class);
        startActivity(intent);
    }

    public void wifi(View view){
        Intent intent = new Intent(this, WifiActivity.class);
        startActivity(intent);
    }

    public void extraInfo(View view){
        Intent intent = new Intent(this, ExtraInfoActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbuttons, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}
