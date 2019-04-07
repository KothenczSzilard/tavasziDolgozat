package com.example.diak.tavaszidolgozat;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Text_view_menü;
    private Button Button_wifi,Button_wifi_info,Button_qr_code;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        if(wifiManager.isWifiEnabled())
        {
            Button_wifi_info.setEnabled(true);
        }

        Button_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent masodik_activity = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(masodik_activity);
                finish();
            }
        });

        Button_wifi_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent harmadik_activity = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(harmadik_activity);
                finish();
            }
        });

        Button_qr_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent negyedik_activity = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(negyedik_activity);
                finish();
            }
        });

        }
        public void init()
        {
        Button_wifi = (Button) findViewById(R.id.Button_wifi);
        Button_wifi_info = (Button) findViewById(R.id.Button_wifi_info);
        Button_qr_code = (Button) findViewById(R.id.Button_qr_code);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

    }
}
