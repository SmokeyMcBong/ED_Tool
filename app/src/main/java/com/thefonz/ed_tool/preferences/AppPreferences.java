/**
 * Created by theFONZ on 04/04/15.
 */

package com.thefonz.ed_tool.preferences;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import com.thefonz.ed_tool.ED_Tool;
import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.backup_manager.BackupManager;
import com.thefonz.ed_tool.theme_manager.ThemeManager;
import com.thefonz.ed_tool.utils.Constants;

public class AppPreferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Set theme according to Preference setting
        ThemeManager.onActivityCreateSetTheme(this);

        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);

        // set resetAllPrefs preference onclick
        Preference myPrefReset = findPreference("resetAllPrefs");
        myPrefReset.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AppPreferences.this);
                builder.setTitle(R.string.reset_all_confirm);
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // reset all button preferences...
                        SharedPreferences myPrefs = getApplicationContext().getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
                        myPrefs.edit().clear().commit();
                        navigateUpTo(new Intent(getApplicationContext(), ED_Tool.class));
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
                return true;
            }
        });

        // set backupRestoreAllPrefs preference onclick
        Preference backupRestoreAllPrefs = findPreference("backupRestoreAllPrefs");
        backupRestoreAllPrefs.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                BackupManager.showDialogBackupManager(getApplicationContext(), " Backup and Restore Button Manager \n",
                        "Here we can backup and restore button configurations. \nIf a previous backup is found, the restore option will be available", "", " Make your selection below .. ");
            return true;
            }
        });

        // set aboutTool preference onclick
        Preference aboutTool = findPreference("aboutTool");
        aboutTool.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AppPreferences.this);
                builder.setTitle(R.string.open_github_confirm);
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String url = Constants.GithubURL;
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
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
                return true;
            }
        });

        // set saveGoBack preference onclick
        Preference saveGoBack = findPreference("saveGoBack");
        saveGoBack.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                navigateUpTo(new Intent(getApplicationContext(), ED_Tool.class));
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Leave blank to do nothing
    }
}