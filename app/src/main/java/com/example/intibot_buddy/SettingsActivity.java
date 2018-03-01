package com.example.intibot_buddy;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void save(View view){
        EditText editTextCurrentPassword = findViewById(R.id.currentPasswordInput);
        EditText editTextNewPassword = findViewById(R.id.newPasswordInput);
        EditText editTextConfirmNewPassword = findViewById(R.id.confirmNewPasswordInput);
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.pass_username), MODE_PRIVATE);
        String username = sharedPref.getString(getString(R.string.pass_username), "defaultValue:username");
        String currentPassword = editTextCurrentPassword.getText().toString();
        String newPassword = editTextNewPassword.getText().toString();
        String confirmNewPassword = editTextConfirmNewPassword.getText().toString();
        new SettingsBgActivity(this).execute(username, currentPassword, newPassword, confirmNewPassword);

        //Log.e("getValue", username);
    }
}
