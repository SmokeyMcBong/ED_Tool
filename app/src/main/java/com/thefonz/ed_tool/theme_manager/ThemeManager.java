/**
 * Created by theFONZ on 03/08/2015.
 */

package com.thefonz.ed_tool.theme_manager;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import com.thefonz.ed_tool.R;

public class ThemeManager extends Application {

    private static int cTheme;

    private final static int DefaultTheme = 1;
    private final static int BlueTheme = 2;
    // Add Additional Themes Here ..
//    private final static int GreenTheme = 3;
//    private final static int RedTheme = 4;
//    private final static int BrownTheme = 5;
//    private final static int YellowTheme = 6;

    // Check the Preference setting and set cTheme int accordingly
    public static void checkThemePreference(Activity activity) {

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
        String selectTheme = SP.getString("selectTheme", "1");

        boolean isDefaultTheme = selectTheme.equalsIgnoreCase("1");
        boolean isBlueTheme = selectTheme.equalsIgnoreCase("2");
        // Add Additional Themes Here ..
//        boolean isGreenTheme = selectTheme.equalsIgnoreCase("3");
//        boolean isRedTheme = selectTheme.equalsIgnoreCase("4");
//        boolean isBrownTheme = selectTheme.equalsIgnoreCase("5");
//        boolean isYellowTheme = selectTheme.equalsIgnoreCase("6");

        if (isDefaultTheme) {
            cTheme = DefaultTheme;
        }
        if (isBlueTheme) {
            cTheme = BlueTheme;
        }
        // Add Additional Themes Here ..
//        if (isGreenTheme) {
//            cTheme = GreenTheme;
//        }
//        if (isRedTheme) {
//            cTheme = RedTheme;
//        }
//        if (isBrownTheme) {
//            cTheme = BrownTheme;
//        }
//        if (isYellowTheme) {
//            cTheme = YellowTheme;
//        }
    }

    // Method to be called when app is first created, this will invoke checkThemePreference() to set cTheme int and then
    // set the application theme according to which theme was selected
    public static void onActivityCreateSetTheme(Activity activity) {

        checkThemePreference(activity);

        switch (cTheme)
        {
            default:

            case DefaultTheme:
                activity.setTheme(R.style.AppThemeDark);
                setKeepScreenOn(activity);
                setImmersive(activity);
                break;

            case BlueTheme:
                activity.setTheme(R.style.AppThemeBlue);
                setKeepScreenOn(activity);
                setImmersive(activity);
                break;

            // Add Additional Themes Here ..
//            case GreenTheme:
//                activity.setTheme(R.style.AppThemeGreen);
//                setKeepScreenOn(activity);
//                setImmersive(activity);
//                break;
//
//            case RedTheme:
//                activity.setTheme(R.style.AppThemeRed);
//                setKeepScreenOn(activity);
//                setImmersive(activity);
//                break;
//            case BrownTheme:
//                activity.setTheme(R.style.AppThemeBrown);
//                setKeepScreenOn(activity);
//                setImmersive(activity);
//                break;
//
//            case YellowTheme:
//                activity.setTheme(R.style.AppThemeYellow);
//                setKeepScreenOn(activity);
//                setImmersive(activity);
//                break;
        }
    }

    // Keep Screen from turning off while running the app to avoid conflicts and to help the overall UX
    public static void setKeepScreenOn(Activity activity){
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    // Set Orientation to Portrait, ONLY for certain circumstances
    public static void setPortrait(Activity activity) {
        if(activity != null) activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    // Set Immersive Fullscreen mode
    public static void setImmersive(Activity activity) {
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
        boolean immersiveMode = SP.getBoolean("immersiveMode", true);
        final View decorView = activity.getWindow().getDecorView();

        if (immersiveMode) {
            // Set immersive mode
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE);

            // Register UI change listener to re-set immersive mode if refocused
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                        @Override
                        public void onSystemUiVisibilityChange(int visibility) {
                            // Note that system bars will only be "visible" if none of the
                            // LOW_PROFILE, HIDE_NAVIGATION, or FULLSCREEN flags are set.
                            if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                                // The system bars are visible. Make any desired changes
                                decorView.setSystemUiVisibility(
                                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                                | View.SYSTEM_UI_FLAG_IMMERSIVE);
                                // adjustments to your UI, such as showing the action bar or
                                // other navigational controls.
                            }
                        }
            });
        }
    }
}