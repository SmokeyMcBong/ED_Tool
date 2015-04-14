package com.thefonz.ed_tool.preferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.utils.U;

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
        title.setText(" Select Desired KeyPress for " + buttonFunction + " ... " );

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                String value = (String) adapter.getItemAtPosition(position);

                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row

                String buttonName = myPrefs.getString("buttonNumber", "");
                String buttonFunction = myPrefs.getString("buttonFunction", "");
                final String completeOutput = buttonName + buttonFunction;

                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putString(completeOutput, value);
                U.m(" INPUT RESULTS  " + completeOutput + "" + value);
                editor.commit();
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", str); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
//                    finish();
                String msg = "Following keypress was saved...\n\n" +
                        value;
                U.showToast_Long(getApplicationContext(), msg);
                finish();
            }
        });

        Button goBack = (Button) findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);

                finish();
            }
        });
    }
}