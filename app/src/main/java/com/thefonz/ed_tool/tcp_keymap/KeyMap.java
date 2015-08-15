/**
 * Created by theFONZ on 19/07/2015.
 */

package com.thefonz.ed_tool.tcp_keymap;

import android.content.Context;
import android.content.SharedPreferences;
import com.thefonz.ed_tool.R;
import com.thefonz.ed_tool.Tab_ButtonBox;

import java.util.Arrays;
import java.util.Objects;

/**
 *  ANY ADDITIONS OR CHANGES MADE HERE MUST ALSO BE MADE TO 'array_keymap.xml' AS INDEX'S MUST MATCH
 *  - 'Click here to set to default' = index 0
 *  -  KeyPress's start at = index 1
 */

public class KeyMap {

    public static void preProcessKeyCode(String key, Context activity){

        // Return the preference item value relating to 'key' preference item to a usable string
        SharedPreferences myPrefs = activity.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String str2 = myPrefs.getString(key, "");

        // Check if that string was empty (no preference found)
        if (!Objects.equals(str2, "")) {
            // Check if key contains 'ModifierDownValue', then check for item value and send relevant sendKey to server
            if (key.contains("ModifierDownValue")) {
                if (Objects.equals(str2, "Control")) {
                    Tab_ButtonBox.sendKey("CD");
                }
                if (Objects.equals(str2, "Shift")) {
                    Tab_ButtonBox.sendKey("SD");
                }
                if (Objects.equals(str2, "Alt")) {
                    Tab_ButtonBox.sendKey("AD");
                }
            }
            // Check if key contains 'ModifierUpValue', then check for item value and send relevant sendKey to server
            if (key.contains("ModifierUpValue")) {
                if (Objects.equals(str2, "Control")) {
                    Tab_ButtonBox.sendKey("CU");
                }
                if (Objects.equals(str2, "Shift")) {
                    Tab_ButtonBox.sendKey("SU");
                }
                if (Objects.equals(str2, "Alt")) {
                    Tab_ButtonBox.sendKey("AU");
                }
            } else {
                // send str2 to processKeyCode() to get the relevant KeyCode to send
                processKeyCode(str2, activity);
            }
        }
    }

    private static void processKeyCode(String str2, Context activity) {
        String keycode = null;
        String[] keyValues = activity.getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.keyValues)));
        if (Arrays.asList(keyValues).contains(str2)) {
            int returnedKeyValue = Arrays.asList(keyValues).indexOf(str2);
            keycode = String.valueOf(returnedKeyValue);
        }
        // Send the relevant KeyCode to the 'sendKey' function
        String finalCode = keycode;
        Tab_ButtonBox.sendKey(finalCode);
    }
}