/**
 * Created by theFONZ on 12/04/2015.
 */

package com.thefonz.ed_tool.preferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.theme_manager.ThemeManager;

public class Dialog_Info extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        String str = intent.getStringExtra("key"); //if it's a string you stored.

        // Set theme according to Preference setting
        ThemeManager.setKeepScreenOn(this);
        ThemeManager.setImmersive(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_info);

        TextView textViewInfo = (TextView) this.findViewById(R.id.textViewInfo);
        textViewInfo.setText(str);

        Button goBack = (Button) this.findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Leave blank to do nothing
    }
}