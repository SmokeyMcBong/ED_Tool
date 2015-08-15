/**
 * Created by theFONZ on 01/08/2015.
 */

package com.thefonz.ed_tool.update_manager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.theme_manager.ThemeManager;

public class Dialog_Updater extends FragmentActivity {

    private static Activity activity = null;
    private static LinearLayout progressLayout;
    private static ProgressBar progressBar;
    private static Button downInstall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        String str = intent.getStringExtra("key"); //if it's a string you stored.

        // Set theme according to Preference setting
        ThemeManager.setKeepScreenOn(this);
        ThemeManager.setImmersive(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_updater);

        activity = this;

        TextView textViewInfo = (TextView) this.findViewById(R.id.textViewInfo);
        textViewInfo.setText(str);

        progressLayout = (LinearLayout) this.findViewById(R.id.progressLayout);
        progressBar = (ProgressBar) this.findViewById(R.id.progressBar);
        downInstall = (Button) this.findViewById(R.id.downInstall);

        downInstall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Show user what we are doing, then call the downloadUpdate() method ...
                showProgress(activity);
                UpdateManager.downloadUpdate(activity);
            }
        });

        Button goBack = (Button) this.findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                closeMe();
            }
        });
    }

    private static void showProgress(Activity activity) {
        String message = activity.getResources().getString(R.string.downloading_update);
        downInstall.setText(message);
        downInstall.setEnabled(false);
        progressLayout.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    public static void closeMe() {
        activity.finish();
    }

    @Override
    public void onBackPressed() {
        // Leave blank to do nothing
    }
}