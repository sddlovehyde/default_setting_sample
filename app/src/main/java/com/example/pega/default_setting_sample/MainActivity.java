package com.example.pega.default_setting_sample;

import android.content.Context;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private WifiManager mWifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        TextView textView1 = (TextView)findViewById(R.id.Wifi_scan_always_text1);





        if (mWifiManager.isScanAlwaysAvailable()) {
            System.out.print(" Scan always available is always on");
            textView1.setBackgroundColor(Color.GREEN);


        }
        else if (!mWifiManager.isScanAlwaysAvailable()) {
            textView1.setBackgroundColor(Color.RED);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
