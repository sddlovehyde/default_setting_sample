package com.example.pega.default_setting_sample;


import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    public void showResultUI(boolean result, TextView mTextView)
    {


        if( result == true)
        {
            mTextView.setBackgroundColor(getResources().getColor(R.color.green));
            mTextView.setTextSize(20);

        }
        else
            mTextView.setBackgroundColor(getResources().getColor(R.color.red));
            mTextView.setTextSize(20);


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
        final TextView textView8 = (TextView) findViewById(R.id.backup);
        textView8.setTextSize(20);
        textView8.setBackgroundColor(getResources().getColor(R.color.primary_material_light));
        final TextView textView9 = (TextView) findViewById(R.id.Location);
        textView9.setTextSize(20);
        textView9.setBackgroundColor(getResources().getColor(R.color.primary_material_light));

        Button button_setting_backup = (Button) findViewById(R.id.button_setting_backup);
        Button button_backup_pass = (Button) findViewById(R.id.button_backup_pass);
        Button button_backup_fail = (Button) findViewById(R.id.button_backup_fail);

        Button button_setting_location = (Button) findViewById(R.id.button_setting_location);
        Button button_location_pass = (Button) findViewById(R.id.button_location_pass);
        Button button_location_fail = (Button) findViewById(R.id.button_location_fail);


        button_setting_backup.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {

                startActivity(new Intent(Settings.ACTION_PRIVACY_SETTINGS));

            }

        });

        button_backup_pass.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                showResultUI(true, textView8);

            }

        });

        button_backup_fail.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                showResultUI(false, textView8);

            }

        });


        button_setting_location.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));

            }

        });

        button_location_pass.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                showResultUI(true, textView9);

            }

        });

        button_location_fail.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                showResultUI(false, textView9);

            }

        });



        showResultUI(function.checkWifiAlwaysScanAvailable(this), textView1);
        showResultUI(function.checkAutoSync(),textView2);
        showResultUI(function.checkUnknownSource(this),textView3);
        showResultUI(function.checkDevelopmentOption(this),textView4);
        showResultUI(function.checkUSBDebugging(this), textView5);
        showResultUI(function.checkLegal(), textView6);
        showResultUI(function.checkVerifyApps(this), textView7);




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
