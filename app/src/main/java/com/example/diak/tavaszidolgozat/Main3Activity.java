package com.example.diak.tavaszidolgozat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Main3Activity extends AppCompatActivity {

    private TextView ip_address;
    private Button Button_ipaddress, Button_back;
    private WifiManager wifiManager;
    private WifiInfo wifiInfo;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();
        ip_address.setText("IP Addres: ");

        Button_ipaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setIPAddress();
                Toast.makeText(Main3Activity.this,"IP elmentve!",Toast.LENGTH_SHORT).show();
            }
        });

        Button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent vissza = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });
    }

    private void getIPAdress() {

        int ip = wifiInfo.getIpAddress();
        String convertedIp = Formatter.formatIpAddress(ip);

        sharedPreferences = getSharedPreferences("Informacio", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("IP", convertedIp);
        editor.apply();
    }

    private void setIPAddress(){

        getIPAdress();

        String ip = sharedPreferences.getString("IP", "");
        ip_address.setText("IP ADDRESS: " + ip);
    }

    public void init()
    {
        ip_address = (TextView) findViewById(R.id.ip_address);
        Button_ipaddress = (Button) findViewById(R.id.Button_ipaddress);
        Button_back = (Button) findViewById(R.id.Button_back);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        wifiInfo = wifiManager.getConnectionInfo();
    }

}
