package com.example.intibot_buddy;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

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

        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.pass_username), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.pass_username), username);
        editor.commit();

        SharedPreferences sharedPref2 = this.getSharedPreferences(getString(R.string.pass_connection), MODE_PRIVATE);
        String connection = sharedPref2.getString(getString(R.string.pass_connection), "defaultValue:connection");

        if (connection=="false") {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("No internet connection");
            alertDialog.setMessage("Please connect to an active internet to login and use the app");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            alertDialog.show();
            // TODO center alertTitle OR remove below code that center alertMessage
            //TextView alertMessage = alertDialog.findViewById(android.R.id.message);
            //alertMessage.setGravity(Gravity.CENTER);
            Button okButton = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
            okButton.setTextColor(this.getResources().getColor(R.color.dark_blue_text));
            LinearLayout.LayoutParams buttonLayout = (LinearLayout.LayoutParams) okButton.getLayoutParams();
            buttonLayout.width = ViewGroup.LayoutParams.MATCH_PARENT;
            buttonLayout.gravity = Gravity.CENTER;
            okButton.setLayoutParams(buttonLayout);
        }

        //Log.e("passValue", username);
    }
}
