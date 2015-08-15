/**
 * Created by theFONZ on 12/04/2015.
 */

package com.thefonz.ed_tool.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.theme_manager.ThemeManager;
import com.thefonz.ed_tool.utils.Helper;

import java.util.Objects;

public class Dialog_ButtonBox extends FragmentActivity {

    private TextView TextViewProgress;
    private static EditText enterName;
    private static String str;
    private static SharedPreferences myPrefs;
    private static Button function1;
    private static Button function2;
    private static Button function3;
    private static Button function4;
    private static Button function5;
    private static Button function6;
    private static TextView modifier1;
    private static TextView modifier2;
    private static TextView modifier3;
    private static TextView modifier4;
    private static TextView modifier5;
    private static TextView modifier6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        str = intent.getStringExtra("key"); //if it's a string you stored.

        // Set theme according to Preference setting
        ThemeManager.setKeepScreenOn(this);
        ThemeManager.setImmersive(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_buttonbox);

        TextViewProgress = (TextView) this.findViewById(R.id.textView1);
        TextViewProgress.setText(R.string.buttonbox_dialog_header);

        final Button buttonInfo = (Button) this.findViewById(R.id.button_info);
        final Button goBack = (Button) this.findViewById(R.id.goBack);
        final Button saveName = (Button) this.findViewById(R.id.saveName);

        function1 = (Button) this.findViewById(R.id.button1);
        function2 = (Button) this.findViewById(R.id.button2);
        function3 = (Button) this.findViewById(R.id.button3);
        function4 = (Button) this.findViewById(R.id.button4);
        function5 = (Button) this.findViewById(R.id.button5);
        function6 = (Button) this.findViewById(R.id.button6);

        modifier1 = (TextView) this.findViewById(R.id.modifier1);
        modifier2 = (TextView) this.findViewById(R.id.modifier2);
        modifier3 = (TextView) this.findViewById(R.id.modifier3);
        modifier4 = (TextView) this.findViewById(R.id.modifier4);
        modifier5 = (TextView) this.findViewById(R.id.modifier5);
        modifier6 = (TextView) this.findViewById(R.id.modifier6);

        // Initiate SharedPreferences - 'myPrefs'
        myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);

        enterName = (EditText) this.findViewById(R.id.enterName);
        enterName.setSingleLine(true);

        // Call doButtonSetup() method to set all function buttons
        doFunctionSetup();
        // Call doModifierSetup() method to set all modifier textviews
        doModifierSetup();

        saveName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String processName = String.valueOf(enterName.getText());
                saveName(str, processName);
            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String line1 = getString(R.string.dialog_info_line1);
                String line2 = getString(R.string.dialog_info_line2);
                String line3 = getString(R.string.dialog_info_line3);
                String line4 = getString(R.string.dialog_info_line4);
                String str = "\n\n" +
                        line1 + "\n\n" +
                        line2 + "\n" +
                        "\n" +
                        line3 + "\n\n" +
                        line4 + "\n\n";
                Intent myIntent = new Intent(getApplicationContext(), Dialog_Info.class);
                myIntent.putExtra("key", str); //Optional parameters
                myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Dialog_ButtonBox.this.startActivity(myIntent);
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        function1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showList("Function1");
            }
        });
        function2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showList("Function2");
            }
        });
        function3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showList("Function3");
            }
        });
        function4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showList("Function4");
            }
        });
        function5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showList("Function5");
            }
        });
        function6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showList("Function6");
            }
        });
    }

    private static void doFunctionSetup(){
        // Set edittext button name/hint text according to the relevant SharedPreferences
        String buttonName = str + "name";
        String passName = myPrefs.getString(buttonName, "");
        if (!Objects.equals(passName, "")) {
            enterName.setText(passName);
        } else {
            enterName.setHint(str);
        }
        // Set each function button's text according to the relevant SharedPreferences
        String buttonFunction1 = "Function1";
        final String completeOutput = str + buttonFunction1;
        String pass = myPrefs.getString(completeOutput, "");
        if (!Objects.equals(pass, "")) {
            function1.setText(pass);
        } else {
            function1.setText("Function1");
        }
        String buttonFunction2 = "Function2";
        final String completeOutput2 = str + buttonFunction2;
        String pass2 = myPrefs.getString(completeOutput2, "");
        if (!Objects.equals(pass2, "")) {
            function2.setText(pass2);
        } else {
            function2.setText("Function2");
        }
        String buttonFunction3 = "Function3";
        final String completeOutput3 = str + buttonFunction3;
        String pass3 = myPrefs.getString(completeOutput3, "");
        if (!Objects.equals(pass3, "")) {
            function3.setText(pass3);
        } else {
            function3.setText("Function3");
        }
        String buttonFunction4 = "Function4";
        final String completeOutput4 = str + buttonFunction4;
        String pass4 = myPrefs.getString(completeOutput4, "");
        if (!Objects.equals(pass4, "")) {
            function4.setText(pass4);
        } else {
            function4.setText("Function4");
        }
        String buttonFunction5 = "Function5";
        final String completeOutput5 = str + buttonFunction5;
        String pass5 = myPrefs.getString(completeOutput5, "");
        if (!Objects.equals(pass5, "")) {
            function5.setText(pass5);
        } else {
            function5.setText("Function5");
        }
        String buttonFunction6 = "Function6";
        final String completeOutput6 = str + buttonFunction6;
        String pass6 = myPrefs.getString(completeOutput6, "");
        if (!Objects.equals(pass6, "")) {
            function6.setText(pass6);
        } else {
            function6.setText("Function6");
        }
    }

    private static void doModifierSetup() {
        // Set each function's modifier textview text according to the relevant SharedPreferences
        String buttonFunction1 = "Function1";
        String buttonFunction1Modifier = "ModifierDownValue";
        final String completeOutput = str + buttonFunction1 + buttonFunction1Modifier;
        String pass = myPrefs.getString(completeOutput, "");
        if (!Objects.equals(pass, "")) {
            modifier1.setText(pass + " +");
        } else {
            modifier1.setText("No Modifier");
        }
        String buttonFunction2 = "Function2";
        String buttonFunction2Modifier = "ModifierDownValue";
        final String completeOutput2 = str + buttonFunction2 + buttonFunction2Modifier;
        String pass2 = myPrefs.getString(completeOutput2, "");
        if (!Objects.equals(pass2, "")) {
            modifier2.setText(pass2 + " +");
        } else {
            modifier2.setText("No Modifier");
        }
        String buttonFunction3 = "Function3";
        String buttonFunction3Modifier = "ModifierDownValue";
        final String completeOutput3 = str + buttonFunction3 + buttonFunction3Modifier;
        String pass3 = myPrefs.getString(completeOutput3, "");
        if (!Objects.equals(pass3, "")) {
            modifier3.setText(pass3 + " +");
        } else {
            modifier3.setText("No Modifier");
        }
        String buttonFunction4 = "Function4";
        String buttonFunction4Modifier = "ModifierDownValue";
        final String completeOutput4 = str + buttonFunction4 + buttonFunction4Modifier;
        String pass4 = myPrefs.getString(completeOutput4, "");
        if (!Objects.equals(pass4, "")) {
            modifier4.setText(pass4 + " +");
        } else {
            modifier4.setText("No Modifier");
        }
        String buttonFunction5 = "Function5";
        String buttonFunction5Modifier = "ModifierDownValue";
        final String completeOutput5 = str + buttonFunction5 + buttonFunction5Modifier;
        String pass5 = myPrefs.getString(completeOutput5, "");
        if (!Objects.equals(pass5, "")) {
            modifier5.setText(pass5 + " +");
        } else {
            modifier5.setText("No Modifier");
        }
        String buttonFunction6 = "Function6";
        String buttonFunction6Modifier = "ModifierDownValue";
        final String completeOutput6 = str + buttonFunction6 + buttonFunction6Modifier;
        String pass6 = myPrefs.getString(completeOutput6, "");
        if (!Objects.equals(pass6, "")) {
            modifier6.setText(pass6 + " +");
        } else {
            modifier6.setText("No Modifier");
        }
    }

    private void saveName(String str, String newButtonName) {
        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
        SharedPreferences.Editor editor = myPrefs.edit();
        String completeString = str + "name";
        editor.putString(completeString, newButtonName);
        editor.commit();
        if (!Objects.equals(newButtonName, "")) {
            String msg = "Name Saved";
            Helper.showToast_Short(getApplicationContext(), msg);
        }
    }

    private void showList(String str2) {
        Intent myIntent = new Intent(Dialog_ButtonBox.this, Preferences_ListView.class);
        Dialog_ButtonBox.this.startActivity(myIntent);
        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putString("buttonFunction", str2);
        editor.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onResume() {
        super.onResume();

        Intent intent = getIntent();
        str = intent.getStringExtra("key"); //if it's a string you stored.
        setContentView(R.layout.dialog_buttonbox);

        TextViewProgress = (TextView) this.findViewById(R.id.textView1);
        TextViewProgress.setText(R.string.buttonbox_dialog_header);

        final Button buttonInfo = (Button) this.findViewById(R.id.button_info);
        final Button goBack = (Button) this.findViewById(R.id.goBack);
        final Button saveName = (Button) this.findViewById(R.id.saveName);
        function1 = (Button) this.findViewById(R.id.button1);
        function2 = (Button) this.findViewById(R.id.button2);
        function3 = (Button) this.findViewById(R.id.button3);
        function4 = (Button) this.findViewById(R.id.button4);
        function5 = (Button) this.findViewById(R.id.button5);
        function6 = (Button) this.findViewById(R.id.button6);

        modifier1 = (TextView) this.findViewById(R.id.modifier1);
        modifier2 = (TextView) this.findViewById(R.id.modifier2);
        modifier3 = (TextView) this.findViewById(R.id.modifier3);
        modifier4 = (TextView) this.findViewById(R.id.modifier4);
        modifier5 = (TextView) this.findViewById(R.id.modifier5);
        modifier6 = (TextView) this.findViewById(R.id.modifier6);

        // Initiate SharedPreferences - 'myPrefs'
        myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);

        enterName = (EditText) this.findViewById(R.id.enterName);
        enterName.setSingleLine(true);

        // Call doButtonSetup() and doModifierSetup() methods to set all buttons
        doFunctionSetup();
        doModifierSetup();

        saveName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String processName = String.valueOf(enterName.getText());
                saveName(str, processName);
            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String line1 = getString(R.string.dialog_info_line1);
                String line2 = getString(R.string.dialog_info_line2);
                String line3 = getString(R.string.dialog_info_line3);
                String line4 = getString(R.string.dialog_info_line4);
                String line5 = getString(R.string.dialog_info_line5);
                String str = "\n\n" +
                        line1 + "\n\n" +
                        line2 + "\n" +
                        "\n" +
                        line3 + "\n\n" +
                        line4 + "\n\n" +
                        line5 + "\n\n";
                Intent myIntent = new Intent(getApplicationContext(), Dialog_Info.class);
                myIntent.putExtra("key", str); //Optional parameters
                myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Dialog_ButtonBox.this.startActivity(myIntent);
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        function1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showList("Function1");
            }
        });
        function2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showList("Function2");
            }
        });
        function3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showList("Function3");
            }
        });
        function4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showList("Function4");
            }
        });
        function5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showList("Function5");
            }
        });
        function6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showList("Function6");
            }
        });
    }
}