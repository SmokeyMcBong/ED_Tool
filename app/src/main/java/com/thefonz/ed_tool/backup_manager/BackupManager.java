/**
 * Created by theFONZ on 02/08/2015.
 */

package com.thefonz.ed_tool.backup_manager;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import com.thefonz.ed_tool.utils.Constants;

import java.io.*;
import java.util.Map;

public class BackupManager extends Application {

    public static void showDialogBackupManager(Context context, String line1, String line2, String line3, String line4) {
        String str = "\n\n" +
                line1 + "\n\n" +
                line2 + "\n" +
                "\n" +
                line3 + "\n\n" +
                line4 + "\n\n";
        Intent myIntent = new Intent(context, Dialog_BackupRestore.class);
        myIntent.putExtra("key", str); //Optional parameters
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(myIntent);
    }

    public static boolean backupFileCheck() {
        // Check folder structure and manipulate if needed
        File dir = new File(Environment.getExternalStorageDirectory() + "/"
                + Constants.BackupDir);
        File file = new File(dir, Constants.BackupName);
        return file.exists();
    }

    public static boolean backupButtonPrefs(final Context context, File backup) {
        boolean res = false;
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(backup));
            SharedPreferences pref = context.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
            output.writeObject(pref.getAll());
            res = true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (output != null) {
                    output.flush();
                    output.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Dialog_BackupRestore.closeMe();
        return res;
    }

    @SuppressWarnings({ "unchecked" })
    public static boolean restoreButtonPrefs(final Context context, File restore) {
        boolean res = false;
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(restore));
            SharedPreferences.Editor prefEdit = context.getSharedPreferences("myPrefs", MODE_PRIVATE).edit();
            prefEdit.clear();
            Map<String, ?> entries = (Map<String, ?>) input.readObject();
            for (Map.Entry<String, ?> entry : entries.entrySet()) {
                Object v = entry.getValue();
                String key = entry.getKey();
                if (v instanceof Boolean)
                    prefEdit.putBoolean(key, (Boolean) v);
                else if (v instanceof Float)
                    prefEdit.putFloat(key, (Float) v);
                else if (v instanceof Integer)
                    prefEdit.putInt(key, (Integer) v);
                else if (v instanceof Long)
                    prefEdit.putLong(key, (Long) v);
                else if (v instanceof String)
                    prefEdit.putString(key, ((String) v));
            }
            prefEdit.commit();
            res = true;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Dialog_BackupRestore.closeMe();
        return res;
    }
}