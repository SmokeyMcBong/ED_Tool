package com.thefonz.ed_tool.preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.*;
import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.utils.U;

import java.util.Objects;

/**
 * Created by the_FONZ on 12/04/2015.
 */
public class Preferences_ListView extends FragmentActivity {
    ListView listView;
    TextView title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences_listview);

        String[] keys = getResources().getStringArray(R.array.keyValues);

        final ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.preferences_listview_row, R.id.TextItem, keys);

        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);

        final SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
        final String buttonFunction = myPrefs.getString("buttonFunction", "");

        title = (TextView) this.findViewById(R.id.title);
        title.setText(getString(R.string.select_keypress) + " " + buttonFunction + " ... " );

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                String value = (String) adapter.getItemAtPosition(position);

                if (Objects.equals(value, "Click here to set to default")) {
                    value = "";
                }

                String buttonName = myPrefs.getString("buttonNumber", "");
                String buttonFunction = myPrefs.getString("buttonFunction", "");
                final String completeOutput = buttonName + buttonFunction;

                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putString(completeOutput, value);
                editor.commit();

                String msg = getString(R.string.button_saved_keypress) + "\n\n" +
                        value;
                U.showToast_Long(getApplicationContext(), msg);
                finish();
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