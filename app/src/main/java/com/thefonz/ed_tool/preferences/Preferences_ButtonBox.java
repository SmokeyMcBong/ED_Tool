package com.thefonz.ed_tool.preferences;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.thefonz.ed_tool.R;

/**
 * Created by thefonz on 09/04/15.
 */
public class Preferences_ButtonBox extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferences_buttonbox);
                
        final Button goBack = (Button) this.findViewById(R.id.goBack);
        goBack.setOnClickListener(onClickListener);

        // initialize all buttons and set onclicklisteners for all
        final Button buttonB_1 = (Button) this.findViewById(R.id.buttonB_1);
        buttonB_1.setOnClickListener(onClickListener);
        final Button buttonB_2 = (Button) this.findViewById(R.id.buttonB_2);
        buttonB_2.setOnClickListener(onClickListener);
        final Button buttonB_3 = (Button) this.findViewById(R.id.buttonB_3);
        buttonB_3.setOnClickListener(onClickListener);
        final Button buttonB_4 = (Button) this.findViewById(R.id.buttonB_4);
        buttonB_4.setOnClickListener(onClickListener);
        final Button buttonB_5 = (Button) this.findViewById(R.id.buttonB_5);
        buttonB_5.setOnClickListener(onClickListener);
        final Button buttonB_6 = (Button) this.findViewById(R.id.buttonB_6);
        buttonB_6.setOnClickListener(onClickListener);
        final Button buttonB_7 = (Button) this.findViewById(R.id.buttonB_7);
        buttonB_7.setOnClickListener(onClickListener);
        final Button buttonB_8 = (Button) this.findViewById(R.id.buttonB_8);
        buttonB_8.setOnClickListener(onClickListener);
        final Button buttonB_9 = (Button) this.findViewById(R.id.buttonB_9);
        buttonB_9.setOnClickListener(onClickListener);
        final Button buttonB_10 = (Button) this.findViewById(R.id.buttonB_10);
        buttonB_10.setOnClickListener(onClickListener);
        final Button buttonB_11 = (Button) this.findViewById(R.id.buttonB_11);
        buttonB_11.setOnClickListener(onClickListener);
        final Button buttonB_12 = (Button) this.findViewById(R.id.buttonB_12);
        buttonB_12.setOnClickListener(onClickListener);
        final Button buttonB_13 = (Button) this.findViewById(R.id.buttonB_13);
        buttonB_13.setOnClickListener(onClickListener);
        final Button buttonB_14 = (Button) this.findViewById(R.id.buttonB_14);
        buttonB_14.setOnClickListener(onClickListener);
        final Button buttonB_15 = (Button) this.findViewById(R.id.buttonB_15);
        buttonB_15.setOnClickListener(onClickListener);
        final Button buttonB_16 = (Button) this.findViewById(R.id.buttonB_16);
        buttonB_16.setOnClickListener(onClickListener);
        final Button buttonB_17 = (Button) this.findViewById(R.id.buttonB_17);
        buttonB_17.setOnClickListener(onClickListener);
        final Button buttonB_18 = (Button) this.findViewById(R.id.buttonB_18);
        buttonB_18.setOnClickListener(onClickListener);
        final Button buttonB_19 = (Button) this.findViewById(R.id.buttonB_19);
        buttonB_19.setOnClickListener(onClickListener);
        final Button buttonB_20 = (Button) this.findViewById(R.id.buttonB_20);
        buttonB_20.setOnClickListener(onClickListener);
        final Button buttonB_21 = (Button) this.findViewById(R.id.buttonB_21);
        buttonB_21.setOnClickListener(onClickListener);
        final Button buttonB_22 = (Button) this.findViewById(R.id.buttonB_22);
        buttonB_22.setOnClickListener(onClickListener);
        final Button buttonB_23 = (Button) this.findViewById(R.id.buttonB_23);
        buttonB_23.setOnClickListener(onClickListener);
        final Button buttonB_24 = (Button) this.findViewById(R.id.buttonB_24);
        buttonB_24.setOnClickListener(onClickListener);

    }

    // do stuff
    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.goBack:
                    finish();
//                    System.exit(0);
                    break;
                case R.id.buttonB_1:
                    // TODO - check for preferences, as user may have changed button commands
//                    String buttonNumber = "";
                    showDialog("Button 1");
                    break;
                case R.id.buttonB_2:
                    //DO something
                    showDialog("Button 2");
                    break;
                case R.id.buttonB_3:
                    //DO something
                    showDialog("Button 3");
                    break;
                case R.id.buttonB_4:
                    //DO something
                    showDialog("Button 4");
                    break;
                case R.id.buttonB_5:
                    //DO something
                    showDialog("Button 5");
                    break;
                case R.id.buttonB_6:
                    //DO something
                    showDialog("Button 6");
                    break;
                case R.id.buttonB_7:
                    //DO something
                    showDialog("Button 7");
                    break;
                case R.id.buttonB_8:
                    //DO something
                    showDialog("Button 8");
                    break;
                case R.id.buttonB_9:
                    //DO something
                    showDialog("Button 9");
                    break;
                case R.id.buttonB_10:
                    //DO something
                    showDialog("Button 10");
                    break;
                case R.id.buttonB_11:
                    //DO something
                    showDialog("Button 11");
                    break;
                case R.id.buttonB_12:
                    //DO something
                    showDialog("Button 12");
                    break;
                case R.id.buttonB_13:
                    //DO something
                    showDialog("Button 13");
                    break;
                case R.id.buttonB_14:
                    //DO something
                    showDialog("Button 14");
                    break;
                case R.id.buttonB_15:
                    //DO something
                    showDialog("Button 15");
                    break;
                case R.id.buttonB_16:
                    //DO something
                    showDialog("Button 16");
                    break;
                case R.id.buttonB_17:
                    //DO something
                    showDialog("Button 17");
                    break;
                case R.id.buttonB_18:
                    //DO something
                    showDialog("Button 18");
                    break;
                case R.id.buttonB_19:
                    //DO something
                    showDialog("Button 19");
                    break;
                case R.id.buttonB_20:
                    //DO something
                    showDialog("Button 20");
                    break;
                case R.id.buttonB_21:
                    //DO something
                    showDialog("Button 21");
                    break;
                case R.id.buttonB_22:
                    //DO something
                    showDialog("Button 22");
                    break;
                case R.id.buttonB_23:
                    //DO something
                    showDialog("Button 23");
                    break;
                case R.id.buttonB_24:
                    //DO something
                    showDialog("Button 24");
                    break;
            }
            }
        };

    public void checkKeys() {
        // TODO - show arraylist keymap with single selectable entry then pass relavant keypress to a preferences arraylist to be saved and then read on every startup/oncreate method

    }

    public void showDialog(String str) {
        Intent myIntent = new Intent(Preferences_ButtonBox.this, Dialog_ButtonBox.class);
        myIntent.putExtra("key", str); //Optional parameters
        Preferences_ButtonBox.this.startActivity(myIntent);
    }
}

