package com.example.intibot_buddy;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by TIAN☺ on 28/02/2018.
 */

public class SettingsBgActivity extends AsyncTask {

    private Context context;

    public SettingsBgActivity(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Object[] objects) {
        try {
            String username = (String) objects[0];
            String currentPassword = (String) objects[1];
            String newPassword = (String) objects[2];
            String confirmNewPassword = (String) objects[3];
            String link = "http://pkunite2.000webhostapp.com/changepassword.php";

            if (!currentPassword.equals("") && !newPassword.equals("") && !confirmNewPassword.equals("")) {
                if (newPassword.equals(confirmNewPassword)) {
                    String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
                    data += "&" + URLEncoder.encode("currentPassword", "UTF-8") + "=" + URLEncoder.encode(currentPassword, "UTF-8");
                    data += "&" + URLEncoder.encode("newPassword", "UTF-8") + "=" + URLEncoder.encode(newPassword, "UTF-8");

                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write(data);
                    wr.flush();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }

                    return sb.toString();
                } else {
                    return "{\"status\":\"Please check new password fields\",\"message\":\"New passwords do not match\"}";
                }
            }
            else {
                return "{\"status\":\"Invalid\",\"message\":\"All fields are required\"}";
            }

        } catch (Exception e) {
            Log.e("SettingsBgActivityError", e.getLocalizedMessage());
            return  new String("Exception: " + e.getMessage());
        }
    }

    private void parseJSON(String line) throws JSONException {
        String title, message;
        JSONObject jsonObject = new JSONObject(line);
        title = jsonObject.getString("status");
        message = jsonObject.getString("message");

        if (title.equals("Password has been changed successfully")) {
            Toast.makeText(context, title + "\n" + message, Toast.LENGTH_SHORT).show();
            // TODO clear edit text fields or refresh the page
            ((Activity)context).finish();
            Intent intent = new Intent(context, SettingsActivity.class);
            context.startActivity(intent);
        }

        else {
            AlertDialog alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(message);
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
            okButton.setTextColor(context.getResources().getColor(R.color.dark_blue_text));
            LinearLayout.LayoutParams buttonLayout = (LinearLayout.LayoutParams) okButton.getLayoutParams();
            buttonLayout.width = ViewGroup.LayoutParams.MATCH_PARENT;
            buttonLayout.gravity = Gravity.CENTER;
            okButton.setLayoutParams(buttonLayout);
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        try {
            parseJSON((String)o);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
