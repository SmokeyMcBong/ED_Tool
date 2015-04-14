package com.thefonz.ed_tool.preferences;

/**
 * Created by thefonz on 04/04/15.
 */
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import com.thefonz.ed_tool.R;

public class AppPreferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
//        boolean immersiveMode = SP.getBoolean("immersiveMode",false);
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
    }

    @Override
    public void onBackPressed() {
        // Leave blank if you do not want anything to happen
    }

}