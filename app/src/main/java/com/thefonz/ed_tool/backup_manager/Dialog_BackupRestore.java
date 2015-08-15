/**
 * Created by theFONZ on 01/08/2015.
 */

package com.thefonz.ed_tool.backup_manager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.theme_manager.ThemeManager;
import com.thefonz.ed_tool.utils.Constants;
import com.thefonz.ed_tool.utils.Helper;

import java.io.File;

public class Dialog_BackupRestore extends FragmentActivity {

    private static Activity activity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        String str = intent.getStringExtra("key"); //if it's a string you stored.

        // Set theme according to Preference setting
        ThemeManager.setKeepScreenOn(this);
        ThemeManager.setImmersive(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_backuprestore);

        activity = this;

        // Call existCheck() method to check for previous backups
        existCheck();

        // Set textViewInfo using stored 'str' intent key
        TextView textViewInfo = (TextView) this.findViewById(R.id.textViewInfo);
        textViewInfo.setText(str);

        Button backupNow = (Button) this.findViewById(R.id.backupNow);
        backupNow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final File dir = new File(Environment.getExternalStorageDirectory() + "/"
                        + Constants.BackupDir);
                final File file = new File(dir, Constants.BackupName);
                Boolean precheck = existCheck();
                if (!dir.exists()) {
                    dir.mkdir();
                }
                if (precheck) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle(R.string.overwrite);
                    builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Helper.DeleteRecursive(file);
                            String message = getResources().getString(R.string.backing_up);
                            Helper.showToast_Short(activity, message);
                            Boolean postcheck = BackupManager.backupButtonPrefs(activity, file);
                            if (postcheck) {
                                String message_ok = getResources().getString(R.string.backup_complete);
                                Helper.showToast_Short(activity, message_ok);
                            }
                            dialog.dismiss();
                        }
                    });
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    String message = getResources().getString(R.string.backing_up);
                    Helper.showToast_Short(activity, message);
                    Boolean postcheck = BackupManager.backupButtonPrefs(activity, file);
                    if (postcheck) {
                        String message_ok = getResources().getString(R.string.backup_complete);
                        Helper.showToast_Short(activity, message_ok);
                    }
                }
            }
        });

        Button restoreNow = (Button) this.findViewById(R.id.restoreNow);
        restoreNow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle(" Restore Previous Backup ? ");
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Add calls for restore method here ...
                        Helper.showToast_Short(activity," Restoring Button's .. ");
                        File dir = new File(Environment.getExternalStorageDirectory() + "/"
                                + Constants.BackupDir);
                        File file = new File(dir, Constants.BackupName);
                        Boolean bool = BackupManager.restoreButtonPrefs(activity, file);
                        if (bool) {
                            Helper.showToast_Short(activity," Restore Completed ");
                        }
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        Button goBack = (Button) this.findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    private static boolean existCheck() {
        if (BackupManager.backupFileCheck()){
            Button restoreNow = (Button) activity.findViewById(R.id.restoreNow);
            restoreNow.setEnabled(true);
            return true;
        } else {
            return false;
        }
    }

    public static void closeMe() {
        activity.finish();
    }

    @Override
    public void onBackPressed() {
        // Leave blank to do nothing
    }
}