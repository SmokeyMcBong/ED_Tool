package com.thefonz.ed_tool.preferences;

/**
 * Created by thefonz on 04/04/15.
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import com.thefonz.ed_tool.ED_Tool;
import com.thefonz.ed_tool.R;

public class AppPreferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String selectTheme = SP.getString("selectTheme", "1");

        assert selectTheme != null;
        if (selectTheme.equalsIgnoreCase("1")) {
            setTheme(R.style.AppThemeDark);
        }
        else
        {
            setTheme(R.style.AppThemeLight);
        }

        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);

        // set goBack preference onclick
        Preference myPref = findPreference("saveGoBack");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                navigateUpTo(new Intent(getApplicationContext(), ED_Tool.class));
                return true;
            }
        });

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
    }

    @Override
    public void onBackPressed() {
        // Leave blank to do nothing
    }
}