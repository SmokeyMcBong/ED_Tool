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
import com.thefonz.ed_tool.Tab_ButtonBox;
import com.thefonz.ed_tool.utils.U;

import java.util.Objects;

/**
 * Created by the_FONZ on 12/04/2015.
 */
public class Dialog_ButtonBox extends FragmentActivity {

    TextView TextViewProgress;
    EditText enterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        final String str = intent.getStringExtra("key"); //if it's a string you stored.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_buttonbox);

        TextViewProgress = (TextView) this.findViewById(R.id.textView1);
        TextViewProgress.setText(" " + str + " Configuration");

        final Button buttonInfo = (Button) this.findViewById(R.id.button_info);

        final Button goBack = (Button) this.findViewById(R.id.goBack);

        final Button saveName = (Button) this.findViewById(R.id.saveName);

        final Button button1 = (Button) this.findViewById(R.id.button1);

        final Button button2 = (Button) this.findViewById(R.id.button2);

        final Button button3 = (Button) this.findViewById(R.id.button3);

        final Button button4 = (Button) this.findViewById(R.id.button4);

        final Button button5 = (Button) this.findViewById(R.id.button5);

        final Button button6 = (Button) this.findViewById(R.id.button6);


        // Initiate SharedPreferences - 'myPrefs'
        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);

        enterName = (EditText) this.findViewById(R.id.enterName);
        enterName.setSingleLine(true);

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
            button1.setText(pass);
        } else {
            button1.setText("Function1");
        }

        String buttonFunction2 = "Function2";
        final String completeOutput2 = str + buttonFunction2;
        String pass2 = myPrefs.getString(completeOutput2, "");
        if (!Objects.equals(pass2, "")) {
            button2.setText(pass2);
        } else {
            button2.setText("Function2");
        }

        String buttonFunction3 = "Function3";
        final String completeOutput3 = str + buttonFunction3;
        String pass3 = myPrefs.getString(completeOutput3, "");
        if (!Objects.equals(pass3, "")) {
            button3.setText(pass3);
        } else {
            button3.setText("Function3");
        }

        String buttonFunction4 = "Function4";
        final String completeOutput4 = str + buttonFunction4;
        String pass4 = myPrefs.getString(completeOutput4, "");
        if (!Objects.equals(pass4, "")) {
            button4.setText(pass4);
        } else {
            button4.setText("Function4");
        }

        String buttonFunction5 = "Function5";
        final String completeOutput5 = str + buttonFunction5;
        String pass5 = myPrefs.getString(completeOutput5, "");
        if (!Objects.equals(pass5, "")) {
            button5.setText(pass5);
        } else {
            button5.setText("Function5");
        }

        String buttonFunction6 = "Function6";
        final String completeOutput6 = str + buttonFunction6;
        String pass6 = myPrefs.getString(completeOutput6, "");
        if (!Objects.equals(pass6, "")) {
            button6.setText(pass6);
        } else {
            button6.setText("Function6");
        }

        saveName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String processName = String.valueOf(enterName.getText());
                saveName(str, processName);
            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showDialogInfo();
//                finish();
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Dialog_ButtonBox.this, Preferences_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Dialog_ButtonBox.this.startActivity(myIntent);
                finish();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showList("Function1");
//                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showList("Function2");
//                finish();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showList("Function3");
//                finish();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showList("Function4");
//                finish();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showList("Function5");
//                finish();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showList("Function6");
//                finish();
            }
        });

    }

    public void showDialogInfo() {
        String str = "\n\n" +
                "This is where we will set the Keypress function up to a 6 keypress macro ...\n\n" +
                "If you wish to set just a single Keypress then press 'Function 1' and select the kepress you wish to use\n" +
                "\n" +
                "To add more than one Keypress select each function in numerical order from 1 - 6\n\n" +
                "Once you have finished configuring this button's functions, press 'Go Back' to return to the previous menu\n\n";
        Intent myIntent = new Intent(Dialog_ButtonBox.this, Dialog_Info.class);
        myIntent.putExtra("key", str); //Optional parameters
        Dialog_ButtonBox.this.startActivity(myIntent);
//        onPause();
//        finish();
    }

    public void saveName(String str, String newButtonName) {
        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
        SharedPreferences.Editor editor = myPrefs.edit();
        String completeString = str + "name";
        editor.putString(completeString, newButtonName);
        editor.commit();
        if (!Objects.equals(newButtonName, "")) {
            String msg = "Following button name was saved...\n\n" +
                    newButtonName;
            U.showToast_Long(getApplicationContext(), msg);
        }
    }

    public void showList(String str2) {
        Intent myIntent = new Intent(Dialog_ButtonBox.this, Preferences_ListView.class);

        Dialog_ButtonBox.this.startActivity(myIntent);
        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putString("buttonFunction", str2);
        editor.commit();
//        finish();
    }

    @Override
    public void onBackPressed() {
//        Intent myIntent = new Intent(Dialog_ButtonBox.this, Preferences_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//        Dialog_ButtonBox.this.startActivity(myIntent);
        finish();
    }

    @Override
    public void onResume() {
        super.onResume();

        Intent intent = getIntent();
        final String str = intent.getStringExtra("key"); //if it's a string you stored.
        setContentView(R.layout.dialog_buttonbox);

        TextViewProgress = (TextView) this.findViewById(R.id.textView1);
        TextViewProgress.setText(" " + str + " Configuration");

        final Button buttonInfo = (Button) this.findViewById(R.id.button_info);

        final Button goBack = (Button) this.findViewById(R.id.goBack);

        final Button saveName = (Button) this.findViewById(R.id.saveName);

        final Button button1 = (Button) this.findViewById(R.id.button1);

        final Button button2 = (Button) this.findViewById(R.id.button2);

        final Button button3 = (Button) this.findViewById(R.id.button3);

        final Button button4 = (Button) this.findViewById(R.id.button4);

        final Button button5 = (Button) this.findViewById(R.id.button5);

        final Button button6 = (Button) this.findViewById(R.id.button6);

        // Initiate SharedPreferences - 'myPrefs'
        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", MODE_WORLD_READABLE);

        enterName = (EditText) this.findViewById(R.id.enterName);
        enterName.setSingleLine(true);

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
            button1.setText(pass);
        } else {
            button1.setText("Function1");
        }

        String buttonFunction2 = "Function2";
        final String completeOutput2 = str + buttonFunction2;
        String pass2 = myPrefs.getString(completeOutput2, "");
        if (!Objects.equals(pass2, "")) {
            button2.setText(pass2);
        } else {
            button2.setText("Function2");
        }

        String buttonFunction3 = "Function3";
        final String completeOutput3 = str + buttonFunction3;
        String pass3 = myPrefs.getString(completeOutput3, "");
        if (!Objects.equals(pass3, "")) {
            button3.setText(pass3);
        } else {
            button3.setText("Function3");
        }

        String buttonFunction4 = "Function4";
        final String completeOutput4 = str + buttonFunction4;
        String pass4 = myPrefs.getString(completeOutput4, "");
        if (!Objects.equals(pass4, "")) {
            button4.setText(pass4);
        } else {
            button4.setText("Function4");
        }

        String buttonFunction5 = "Function5";
        final String completeOutput5 = str + buttonFunction5;
        String pass5 = myPrefs.getString(completeOutput5, "");
        if (!Objects.equals(pass5, "")) {
            button5.setText(pass5);
        } else {
            button5.setText("Function5");
        }

        String buttonFunction6 = "Function6";
        final String completeOutput6 = str + buttonFunction6;
        String pass6 = myPrefs.getString(completeOutput6, "");
        if (!Objects.equals(pass6, "")) {
            button6.setText(pass6);
        } else {
            button6.setText("Function6");
        }

        saveName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String processName = String.valueOf(enterName.getText());
                saveName(str, processName);
            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showDialogInfo();
//                finish();
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Dialog_ButtonBox.this, Preferences_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Dialog_ButtonBox.this.startActivity(myIntent);
                finish();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showList("Function1");
//                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showList("Function2");
//                finish();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showList("Function3");
//                finish();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showList("Function4");
//                finish();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showList("Function5");
//                finish();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent myIntent = new Intent(Preferences_ListView.this, Dialog_ButtonBox.class);
//                    myIntent.putExtra("key", buttonFunction); //Optional parameters
//                Preferences_ListView.this.startActivity(myIntent);
                showList("Function6");
//                finish();
            }
        });

    }

}



