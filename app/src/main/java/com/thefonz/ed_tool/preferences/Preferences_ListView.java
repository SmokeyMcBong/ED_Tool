/**
 * Created by theFONZ on 12/04/2015.
 */

package com.thefonz.ed_tool.preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.*;
import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.theme_manager.ThemeManager;
import com.thefonz.ed_tool.utils.Helper;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Preferences_ListView extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        // Set theme according to Preference setting
        ThemeManager.setKeepScreenOn(this);
        ThemeManager.setImmersive(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences_listviews);

        // Get array's and store for use
        String[] keys = getResources().getStringArray(R.array.keyValues);
        String[] modifiers = getResources().getStringArray(R.array.modifierValues);

        // Create Adapter's and define which array's they use
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.preferences_listview_row, R.id.TextItem, keys);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.preferences_listview2_row, R.id.TextItem2, modifiers);

        // Set Adapter 1
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(arrayAdapter);

        // Set Adapter 2
        final ListView listView2 = (ListView) findViewById(R.id.list2);
        listView2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView2.setAdapter(arrayAdapter2);

        // Get needed Preference's and store them for use here
        final SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
        final String buttonName = myPrefs.getString("buttonNumber", "");
        final String buttonFunction = myPrefs.getString("buttonFunction", "");
        final String checkKeyValue = buttonName + buttonFunction;
        final String checkModifierValue = buttonName + buttonFunction + "ModifierDownValue";

        // Store Strings of the values found at these array items
        String keyTest = myPrefs.getString(checkKeyValue, "");
        String modifierTest = myPrefs.getString(checkModifierValue, "");

        // Create new lists for use
        List<String> myKeys;
        List<String> myModifiers;

        // Set lists to xml String-Array
        myKeys = Arrays.asList((getResources().getStringArray(R.array.keyValues)));
        myModifiers = Arrays.asList((getResources().getStringArray(R.array.modifierValues)));

        // Set int for both indexOf objects
        final int keyValue = myKeys.indexOf(keyTest);
        final int modifierValue = myModifiers.indexOf(modifierTest);

        // Set listView's setSelection based on the indexOf return value above
        listView.post(new Runnable() {
            @Override
            public void run() {
                listView.smoothScrollToPosition(keyValue);
            }
        });
        listView2.post(new Runnable() {
            @Override
            public void run() {
                listView2.smoothScrollToPosition(modifierValue);
            }
        });

        // Set TextView Title
        TextView title = (TextView) this.findViewById(R.id.title);
        title.setText(getString(R.string.select_keypress) + " " + buttonFunction + " ... ");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                String kValue = (String) adapter.getItemAtPosition(position);

                if (Objects.equals(kValue, "Click here to set to default")) {
                    kValue = "";
                }

                String buttonName = myPrefs.getString("buttonNumber", "");
                String buttonFunction = myPrefs.getString("buttonFunction", "");
                final String completeOutput = buttonName + buttonFunction;

                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putString(completeOutput, kValue);
                editor.commit();

                String msg = "KeyPress Saved";
                Helper.showToast_Short(getApplicationContext(), msg);
            }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter2, View v, int position2,
                                    long arg3) {
                String mValue = (String) adapter2.getItemAtPosition(position2);

                if (Objects.equals(mValue, "Click here to set to default")) {
                    mValue = "";
                }

                String buttonName = myPrefs.getString("buttonNumber", "");
                String buttonFunction = myPrefs.getString("buttonFunction", "");
                final String completeOutput1 = buttonName + buttonFunction + "ModifierDownValue";
                final String completeOutput2 = buttonName + buttonFunction + "ModifierUpValue";

                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putString(completeOutput1, mValue);
                editor.commit();

                editor.putString(completeOutput2, mValue);
                editor.commit();

                String msg = "Modifier Saved";
                Helper.showToast_Short(getApplicationContext(), msg);
            }
        });

        Button goBack = (Button) findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}