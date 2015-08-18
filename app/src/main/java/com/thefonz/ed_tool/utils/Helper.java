/**
 * Created by theFONZ on 26/03/15.
 */

package com.thefonz.ed_tool.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import java.io.File;

public class Helper extends Application {

    // Battery Level checker method ..
    public static int getBatteryPercent(Context context){
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);
        assert batteryStatus != null;
        return batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
    }

    // Toast methods ..
    public static void showToast_Short(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
    public static void showToast_Long(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
    public static void showToast_Short_Default(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.show();
    }

    // General webView Error handler ..
    public static void webView_ErrorHandler(String tabName, int errorCode, String description, String failingUrl) {
        String LOGMETHOD = " webView";
        String LOGBODY = "| " + "error originator:> " + tabName + " | " + "error code:> " + errorCode + " " + " | " +
                "error description:> " + description + " " + " | " + "failed url:> " + failingUrl;
        LogError(Constants.TAG, LOGMETHOD, LOGBODY);
    }

    // Method for deleting a folder and contents ..
    public static void DeleteRecursive(File fileOrDirectory) {
        boolean bool;
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
            {
                bool = child.delete();
                System.out.println(" deleted folder contents > result : " + bool);
                DeleteRecursive(child);
            }
        bool = fileOrDirectory.delete();
        System.out.println(" deleted folder > result : " + bool);
    }

    // General Error Logging ..
    public static void LogSuccess(String TAG, String LOGMETHOD, String LOGBODY) {
        Log.i(TAG, LOGMETHOD + " Success ! " + LOGBODY);
    }
    public static void LogError(String TAG, String LOGMETHOD, String LOGBODY) {
        Log.e(TAG, LOGMETHOD + " Error ! " + LOGBODY);
    }
    public static void LogWarning(String TAG, String LOGMETHOD, String LOGBODY) {
        Log.e(TAG, LOGMETHOD + " Warning ! " + LOGBODY);
    }
}