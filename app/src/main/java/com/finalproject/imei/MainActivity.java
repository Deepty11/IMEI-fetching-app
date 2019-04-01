package com.finalproject.imei;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TelephonyManager tel;
    TextView imei;
    String im;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);

       tel = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
       int permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_PHONE_STATE);
        if(permission != PackageManager.PERMISSION_GRANTED) {
            // ask permission here
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE}, 101);
        } else {
            // do your work here
            imei = (TextView) findViewById(R.id.textView2);
            imei.setText(tel.getDeviceId().toString());
        }

       /* imei = (TextView) findViewById(R.id.textView2);
        imei.setText(tel.getDeviceId().toString());*/
    }
   /* public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == 101) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                imei = (TextView) findViewById(R.id.textView2);
                imei.setText(tel.getDeviceId().toString());

                // permission was granted, yay! Do the
                // IMEI Getting task here

            } else {
                Toast.makeText(this,"not valid",Toast.LENGTH_SHORT).show();
            }
        }
    }*/
}
