package com.thefonz.ed_tool.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.thefonz.ed_tool.R;

import java.util.Objects;

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

        // Initialize SharedPreferences - 'myPrefs'
        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);

        // Set each button text relevant to their sharedpreferences
        String passName = myPrefs.getString("Button1name", "");
        if (!Objects.equals(passName, "")) {
            buttonB_1.setText(passName);
        }
        else {
            buttonB_1.setText("Button 1");
        }

        String passName2 = myPrefs.getString("Button2name", "");
        if (!Objects.equals(passName2, "")) {
            buttonB_2.setText(passName2);
        }
        else {
            buttonB_2.setText("Button 2");
        }

        String passName3 = myPrefs.getString("Button3name", "");
        if (!Objects.equals(passName3, "")) {
            buttonB_3.setText(passName3);
        }
        else {
            buttonB_3.setText("Button 3");
        }

        String passName4 = myPrefs.getString("Button4name", "");
        if (!Objects.equals(passName4, "")) {
            buttonB_4.setText(passName4);
        }
        else {
            buttonB_4.setText("Button 4");
        }

        String passName5 = myPrefs.getString("Button5name", "");
        if (!Objects.equals(passName5, "")) {
            buttonB_5.setText(passName5);
        }
        else {
            buttonB_5.setText("Button 5");
        }

        String passName6 = myPrefs.getString("Button6name", "");
        if (!Objects.equals(passName6, "")) {
            buttonB_6.setText(passName6);
        }
        else {
            buttonB_6.setText("Button 6");
        }

        String passName7 = myPrefs.getString("Button7name", "");
        if (!Objects.equals(passName7, "")) {
            buttonB_7.setText(passName7);
        }
        else {
            buttonB_7.setText("Button 7");
        }

        String passName8 = myPrefs.getString("Button8name", "");
        if (!Objects.equals(passName8, "")) {
            buttonB_8.setText(passName8);
        }
        else {
            buttonB_8.setText("Button 8");
        }

        String passName9 = myPrefs.getString("Button9name", "");
        if (!Objects.equals(passName9, "")) {
            buttonB_9.setText(passName9);
        }
        else {
            buttonB_9.setText("Button 9");
        }

        String passName10 = myPrefs.getString("Button10name", "");
        if (!Objects.equals(passName10, "")) {
            buttonB_10.setText(passName10);
        }
        else {
            buttonB_10.setText("Button 10");
        }

        String passName11 = myPrefs.getString("Button11name", "");
        if (!Objects.equals(passName11, "")) {
            buttonB_11.setText(passName11);
        }
        else {
            buttonB_11.setText("Button 11");
        }

        String passName12 = myPrefs.getString("Button12name", "");
        if (!Objects.equals(passName12, "")) {
            buttonB_12.setText(passName12);
        }
        else {
            buttonB_12.setText("Button 12");
        }

        String passName13 = myPrefs.getString("Button13name", "");
        if (!Objects.equals(passName13, "")) {
            buttonB_13.setText(passName13);
        }
        else {
            buttonB_13.setText("Button 13");
        }

        String passName14 = myPrefs.getString("Button14name", "");
        if (!Objects.equals(passName14, "")) {
            buttonB_14.setText(passName14);
        }
        else {
            buttonB_14.setText("Button 14");
        }

        String passName15 = myPrefs.getString("Button15name", "");
        if (!Objects.equals(passName15, "")) {
            buttonB_15.setText(passName15);
        }
        else {
            buttonB_15.setText("Button 15");
        }

        String passName16 = myPrefs.getString("Button16name", "");
        if (!Objects.equals(passName16, "")) {
            buttonB_16.setText(passName16);
        }
        else {
            buttonB_16.setText("Button 16");
        }

        String passName17 = myPrefs.getString("Button17name", "");
        if (!Objects.equals(passName17, "")) {
            buttonB_17.setText(passName17);
        }
        else {
            buttonB_17.setText("Button 17");
        }

        String passName18 = myPrefs.getString("Button18name", "");
        if (!Objects.equals(passName18, "")) {
            buttonB_18.setText(passName18);
        }
        else {
            buttonB_18.setText("Button 18");
        }

        String passName19 = myPrefs.getString("Button19name", "");
        if (!Objects.equals(passName19, "")) {
            buttonB_19.setText(passName19);
        }
        else {
            buttonB_19.setText("Button 19");
        }

        String passName20 = myPrefs.getString("Button20name", "");
        if (!Objects.equals(passName20, "")) {
            buttonB_20.setText(passName20);
        }
        else {
            buttonB_20.setText("Button 20");
        }

        String passName21 = myPrefs.getString("Button21name", "");
        if (!Objects.equals(passName21, "")) {
            buttonB_21.setText(passName21);
        }
        else {
            buttonB_21.setText("Button 21");
        }

        String passName22 = myPrefs.getString("Button22name", "");
        if (!Objects.equals(passName22, "")) {
            buttonB_22.setText(passName22);
        }
        else {
            buttonB_22.setText("Button 22");
        }

        String passName23 = myPrefs.getString("Button23name", "");
        if (!Objects.equals(passName23, "")) {
            buttonB_23.setText(passName23);
        }
        else {
            buttonB_23.setText("Button 23");
        }

        String passName24 = myPrefs.getString("Button24name", "");
        if (!Objects.equals(passName24, "")) {
            buttonB_24.setText(passName24);
        }
        else {
            buttonB_24.setText("Button 24");
        }
    }

    // do stuff
    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.goBack:
                    finish();
                    break;
                case R.id.buttonB_1:
                    showDialog("Button1");
                    break;
                case R.id.buttonB_2:
                    showDialog("Button2");
                    break;
                case R.id.buttonB_3:
                    showDialog("Button3");
                    break;
                case R.id.buttonB_4:
                    showDialog("Button4");
                    break;
                case R.id.buttonB_5:
                    showDialog("Button5");
                    break;
                case R.id.buttonB_6:
                    showDialog("Button6");
                    break;
                case R.id.buttonB_7:
                    showDialog("Button7");
                    break;
                case R.id.buttonB_8:
                    showDialog("Button8");
                    break;
                case R.id.buttonB_9:
                    showDialog("Button9");
                    break;
                case R.id.buttonB_10:
                    showDialog("Button10");
                    break;
                case R.id.buttonB_11:
                    showDialog("Button11");
                    break;
                case R.id.buttonB_12:
                    showDialog("Button12");
                    break;
                case R.id.buttonB_13:
                    showDialog("Button13");
                    break;
                case R.id.buttonB_14:
                    showDialog("Button14");
                    break;
                case R.id.buttonB_15:
                    showDialog("Button15");
                    break;
                case R.id.buttonB_16:
                    showDialog("Button16");
                    break;
                case R.id.buttonB_17:
                    showDialog("Button17");
                    break;
                case R.id.buttonB_18:
                    showDialog("Button18");
                    break;
                case R.id.buttonB_19:
                    showDialog("Button19");
                    break;
                case R.id.buttonB_20:
                    showDialog("Button20");
                    break;
                case R.id.buttonB_21:
                    showDialog("Button21");
                    break;
                case R.id.buttonB_22:
                    showDialog("Button22");
                    break;
                case R.id.buttonB_23:
                    showDialog("Button23");
                    break;
                case R.id.buttonB_24:
                    showDialog("Button24");
                    break;
            }
        }
    };

    public void showDialog(String str) {
        Intent myIntent = new Intent(Preferences_ButtonBox.this, Dialog_ButtonBox.class);
        myIntent.putExtra("key", str);
        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putString("buttonNumber", str);
        editor.commit();
        Preferences_ButtonBox.this.startActivity(myIntent);
    }

    @Override
    public void onResume() {
        super.onResume();

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

        // Initialize SharedPreferences - 'myPrefs'
        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);

        // Set each button text relevant to their sharedpreferences
        String passName = myPrefs.getString("Button1name", "");
        if (!Objects.equals(passName, "")) {
            buttonB_1.setText(passName);
        }
        else {
            buttonB_1.setText("Button 1");
        }

        String passName2 = myPrefs.getString("Button2name", "");
        if (!Objects.equals(passName2, "")) {
            buttonB_2.setText(passName2);
        }
        else {
            buttonB_2.setText("Button 2");
        }

        String passName3 = myPrefs.getString("Button3name", "");
        if (!Objects.equals(passName3, "")) {
            buttonB_3.setText(passName3);
        }
        else {
            buttonB_3.setText("Button 3");
        }

        String passName4 = myPrefs.getString("Button4name", "");
        if (!Objects.equals(passName4, "")) {
            buttonB_4.setText(passName4);
        }
        else {
            buttonB_4.setText("Button 4");
        }

        String passName5 = myPrefs.getString("Button5name", "");
        if (!Objects.equals(passName5, "")) {
            buttonB_5.setText(passName5);
        }
        else {
            buttonB_5.setText("Button 5");
        }

        String passName6 = myPrefs.getString("Button6name", "");
        if (!Objects.equals(passName6, "")) {
            buttonB_6.setText(passName6);
        }
        else {
            buttonB_6.setText("Button 6");
        }

        String passName7 = myPrefs.getString("Button7name", "");
        if (!Objects.equals(passName7, "")) {
            buttonB_7.setText(passName7);
        }
        else {
            buttonB_7.setText("Button 7");
        }

        String passName8 = myPrefs.getString("Button8name", "");
        if (!Objects.equals(passName8, "")) {
            buttonB_8.setText(passName8);
        }
        else {
            buttonB_8.setText("Button 8");
        }

        String passName9 = myPrefs.getString("Button9name", "");
        if (!Objects.equals(passName9, "")) {
            buttonB_9.setText(passName9);
        }
        else {
            buttonB_9.setText("Button 9");
        }

        String passName10 = myPrefs.getString("Button10name", "");
        if (!Objects.equals(passName10, "")) {
            buttonB_10.setText(passName10);
        }
        else {
            buttonB_10.setText("Button 10");
        }

        String passName11 = myPrefs.getString("Button11name", "");
        if (!Objects.equals(passName11, "")) {
            buttonB_11.setText(passName11);
        }
        else {
            buttonB_11.setText("Button 11");
        }

        String passName12 = myPrefs.getString("Button12name", "");
        if (!Objects.equals(passName12, "")) {
            buttonB_12.setText(passName12);
        }
        else {
            buttonB_12.setText("Button 12");
        }

        String passName13 = myPrefs.getString("Button13name", "");
        if (!Objects.equals(passName13, "")) {
            buttonB_13.setText(passName13);
        }
        else {
            buttonB_13.setText("Button 13");
        }

        String passName14 = myPrefs.getString("Button14name", "");
        if (!Objects.equals(passName14, "")) {
            buttonB_14.setText(passName14);
        }
        else {
            buttonB_14.setText("Button 14");
        }

        String passName15 = myPrefs.getString("Button15name", "");
        if (!Objects.equals(passName15, "")) {
            buttonB_15.setText(passName15);
        }
        else {
            buttonB_15.setText("Button 15");
        }

        String passName16 = myPrefs.getString("Button16name", "");
        if (!Objects.equals(passName16, "")) {
            buttonB_16.setText(passName16);
        }
        else {
            buttonB_16.setText("Button 16");
        }

        String passName17 = myPrefs.getString("Button17name", "");
        if (!Objects.equals(passName17, "")) {
            buttonB_17.setText(passName17);
        }
        else {
            buttonB_17.setText("Button 17");
        }

        String passName18 = myPrefs.getString("Button18name", "");
        if (!Objects.equals(passName18, "")) {
            buttonB_18.setText(passName18);
        }
        else {
            buttonB_18.setText("Button 18");
        }

        String passName19 = myPrefs.getString("Button19name", "");
        if (!Objects.equals(passName19, "")) {
            buttonB_19.setText(passName19);
        }
        else {
            buttonB_19.setText("Button 19");
        }

        String passName20 = myPrefs.getString("Button20name", "");
        if (!Objects.equals(passName20, "")) {
            buttonB_20.setText(passName20);
        }
        else {
            buttonB_20.setText("Button 20");
        }

        String passName21 = myPrefs.getString("Button21name", "");
        if (!Objects.equals(passName21, "")) {
            buttonB_21.setText(passName21);
        }
        else {
            buttonB_21.setText("Button 21");
        }

        String passName22 = myPrefs.getString("Button22name", "");
        if (!Objects.equals(passName22, "")) {
            buttonB_22.setText(passName22);
        }
        else {
            buttonB_22.setText("Button 22");
        }

        String passName23 = myPrefs.getString("Button23name", "");
        if (!Objects.equals(passName23, "")) {
            buttonB_23.setText(passName23);
        }
        else {
            buttonB_23.setText("Button 23");
        }

        String passName24 = myPrefs.getString("Button24name", "");
        if (!Objects.equals(passName24, "")) {
            buttonB_24.setText(passName24);
        }
        else {
            buttonB_24.setText("Button 24");
        }
    }
}