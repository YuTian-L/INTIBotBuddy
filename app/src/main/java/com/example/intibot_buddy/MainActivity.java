package com.example.intibot_buddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){
        EditText editTextStudentID = findViewById(R.id.studentIDInput);
        EditText editTextPassword = findViewById(R.id.passwordInput);
        String username = editTextStudentID.getText().toString();
        String password = editTextPassword.getText().toString();
        new LoginActivity(this).execute(username, password);
    }
}
