package com.example.pega.default_setting_sample;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import java.io.BufferedReader;
import java.io.InputStreamReader;



/**
 * Created by Wayne & Javier on 2015/8/18.
 */
public class function {




    public static boolean checkWifiAlwaysScanAvailable(Context context)
    {

        WifiManager mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        if (mWifiManager.isScanAlwaysAvailable()) {

            return true;

        } else {

            return false;
        }

    }

    public static boolean checkAutoSync()
    {
        return ContentResolver.getMasterSyncAutomatically();
    }

    public static boolean checkUnknownSource(Context context)
    {
        boolean unknownSource = false;

        try {
            unknownSource = Settings.Global.getInt(context.getContentResolver(), Settings.Global.INSTALL_NON_MARKET_APPS) == 0;


        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return unknownSource;
    }

    public static boolean checkDevelopmentOption(Context context)
    {

        boolean developmentOption = false;
        try {
            developmentOption = Settings.Global.getInt(context.getContentResolver(), Settings.Global.DEVELOPMENT_SETTINGS_ENABLED) == 0;

        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return developmentOption;



    }

    public static boolean checkUSBDebugging(Context context)
    {



        boolean USBDebug = false;
        try {
            USBDebug = Settings.Global.getInt(context.getContentResolver(), Settings.Global.ADB_ENABLED) == 0;

        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }


        return USBDebug;



    }

    public static boolean checkLegal()
    {
         boolean result=false;
        try {
            java.lang.Process proc = Runtime.getRuntime().exec(new String[]{"/system/bin/getprop", "ro.url.legal"});
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            if (reader.readLine() != null)
            {
                result = true;
            }
            else
                result = false;

        } catch (Exception e){

        }
        return  result;
    }

    public static boolean checkVerifyApps(Context context) {

        boolean result = Settings.Secure.getInt(context.getContentResolver(), "package_verifier_enable", 1) == 1;

        return result;


    }

    public  static void moveToBackup(Context context)
    {

        context.startActivity(new Intent(Settings.ACTION_PRIVACY_SETTINGS));

    }




}

