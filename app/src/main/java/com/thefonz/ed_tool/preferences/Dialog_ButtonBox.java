package com.thefonz.ed_tool.preferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.utils.Utils;

/**
 * Created by the_FONZ on 12/04/2015.
 */
public class Dialog_ButtonBox extends FragmentActivity {

    TextView TextViewProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String str = intent.getStringExtra("key"); //if it's a string you stored.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_buttonbox);

        TextViewProgress = (TextView ) this.findViewById(R.id.textView1);
        TextViewProgress.setText(" " + str + " Configuration");

        final Button buttonInfo = (Button) this.findViewById(R.id.button_info);
        buttonInfo.setOnClickListener(onClickListener);

        final Button goBack = (Button) this.findViewById(R.id.goBack);
        goBack.setOnClickListener(onClickListener);

        final Button button1 = (Button) this.findViewById(R.id.button1);
        button1.setOnClickListener(onClickListener);
        final Button button2 = (Button) this.findViewById(R.id.button2);
        button2.setOnClickListener(onClickListener);
        final Button button3 = (Button) this.findViewById(R.id.button3);
        button3.setOnClickListener(onClickListener);
        final Button button4 = (Button) this.findViewById(R.id.button4);
        button4.setOnClickListener(onClickListener);
        final Button button5 = (Button) this.findViewById(R.id.button5);
        button5.setOnClickListener(onClickListener);
        final Button button6 = (Button) this.findViewById(R.id.button6);
        button6.setOnClickListener(onClickListener);



    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_info:
                    showDialogInfo();
                    break;
                case R.id.goBack:
                    finish();
                    break;
                case R.id.button1:
                    // TODO - check for preferences, as user may have changed button commands
                    Intent myIntent = new Intent(Dialog_ButtonBox.this, Preferences_ListView.class);
//                    myIntent.putExtra("key", str); //Optional parameters
                    Dialog_ButtonBox.this.startActivity(myIntent);
                    Utils.m("" + " button 1 pressed ");
//                    Preferences_ListView();
                    break;
                case R.id.button2:
                    //DO something
                    break;
                case R.id.button3:
                    //DO something
                    break;
                case R.id.button4:
                    //DO something
                    break;
                case R.id.button5:
                    //DO something
                    break;
                case R.id.button6:
                    //DO something
                    break;
            }
        }
    };

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
    }

    @Override
    public void onBackPressed() {
        // Leave blank if you do not want anything to happen
    }
}
