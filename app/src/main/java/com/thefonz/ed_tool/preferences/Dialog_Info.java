package com.thefonz.ed_tool.preferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thefonz.ed_tool.R;

/**
 * Created by the_FONZ on 12/04/2015.
 */
public class Dialog_Info extends FragmentActivity {

    TextView TextViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String str = intent.getStringExtra("key"); //if it's a string you stored.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_info);

        TextViewInfo = (TextView) this.findViewById(R.id.textViewInfo);
        TextViewInfo.setText(str);

        Button goBack = (Button) this.findViewById(R.id.goBack);

        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);

                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        // Leave blank if you do not want anything to happen
    }
}
