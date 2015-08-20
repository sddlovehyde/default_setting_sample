package com.example.pega.default_setting_sample;


import android.content.Context;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public void showResultUI(boolean result, TextView mTextView)
    {


        if( result == true)
        {

            mTextView.setBackgroundColor(Color.GREEN);
        }
        else
            mTextView.setBackgroundColor(Color.RED);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = (TextView) findViewById(R.id.Wifi_scan_always_text1);
        TextView textView2 = (TextView) findViewById(R.id.auto_Sync);
        TextView textView3 = (TextView) findViewById(R.id.unknown_source);
        TextView textView4 = (TextView) findViewById(R.id.development_option);
        TextView textView5 = (TextView) findViewById(R.id.USB_debugging);
        TextView textView6 = (TextView) findViewById(R.id.Legal);
        TextView textView7 = (TextView) findViewById(R.id.verify_app);



        showResultUI(function.checkWifiAlwaysScanAvailable(this),textView1);
        showResultUI(function.checkAutoSync(),textView2);
        showResultUI(function.checkUnknownSource(this),textView3);
        showResultUI(function.checkDevelopmentOption(this),textView4);
        showResultUI(function.checkUSBDebugging(this),textView5);
        showResultUI(function.checkLegal(),textView6);
        showResultUI(function.checkVerifyApps(this),textView7);

        function.checkBackup(this);





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
