package com.thefonz.ed_tool.preferences;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.utils.Utils;

/**
 * Created by the_FONZ on 12/04/2015.
 */
public class Preferences_ListView extends Activity {
    //        implements AdapterView.OnItemClickListener {
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customlistview);

//        listView = (ListView) findViewById(R.id.list);

        String[] keys = getResources().getStringArray(R.array.keyValues);
        //Row layout defined by Android: android.R.layout.simple_list_item_1

        final ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, R.id.TextItem, keys);

        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                String value = (String) adapter.getItemAtPosition(position);
                Utils.m("" + "This was the value returned .... " + value);
                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row
            }
        });

    }
}





//    @Override
//    public void onItemClick(AdapterView<?> adapter, View view,
//                            int position, long id) {
//        Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
//                Toast.LENGTH_SHORT).show();
//    }




