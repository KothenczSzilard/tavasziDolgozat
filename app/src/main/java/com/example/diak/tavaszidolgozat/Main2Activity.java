package com.example.diak.tavaszidolgozat;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.wifi_on:
                        Toast.makeText(Main2Activity.this, "Wifi bekapcsolva", Toast.LENGTH_SHORT).show();
                        wifiManager.setWifiEnabled(true);
                        break;

                    case R.id.back:
                        Intent vissza = new Intent(Main2Activity.this, MainActivity.class);
                        startActivity(vissza);
                        finish();
                        break;

                    case R.id.wifi_off:
                        Toast.makeText(Main2Activity.this,"Wifi kikapcsolva", Toast.LENGTH_SHORT).show();
                        wifiManager.setWifiEnabled(false);
                }
                return true;
            }
        });


    }
    public void init()
    {
      bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
      wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }
}
