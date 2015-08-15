/**
 * Created by theFONZ on 18/03/15.
 */

package com.thefonz.ed_tool;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.thefonz.ed_tool.tcp_client.TCPClient;
import com.thefonz.ed_tool.tcp_keymap.KeyMap;
import com.thefonz.ed_tool.theme_manager.ThemeManager;
import com.thefonz.ed_tool.utils.Helper;

import java.util.Arrays;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Tab_ButtonBox extends Fragment {

    private static TCPClient mTcpClient;
    private Handler mHandler = new Handler();
    private static SharedPreferences myPrefs;
    private static Timer timer;

    private LinearLayout progressLayout;
    private ProgressBar progressBar;
    private TextView textViewProgress;
    private TextView textViewBatLevel;
    private static Button buttonB_1;
    private static Button buttonB_2;
    private static Button buttonB_3;
    private static Button buttonB_4;
    private static Button buttonB_5;
    private static Button buttonB_6;
    private static Button buttonB_7;
    private static Button buttonB_8;
    private static Button buttonB_9;
    private static Button buttonB_10;
    private static Button buttonB_11;
    private static Button buttonB_12;
    private static Button buttonB_13;
    private static Button buttonB_14;
    private static Button buttonB_15;
    private static Button buttonB_16;
    private static Button buttonB_17;
    private static Button buttonB_18;
    private static Button buttonB_19;
    private static Button buttonB_20;
    private static Button buttonB_21;
    private static Button buttonB_22;
    private static Button buttonB_23;
    private static Button buttonB_24;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View myFragmentView = inflater.inflate(R.layout.tab_buttonbox, container, false);

        progressLayout = (LinearLayout) myFragmentView.findViewById(R.id.progressLayout);
        progressBar = (ProgressBar) myFragmentView.findViewById(R.id.progressBar);
        textViewProgress = (TextView ) myFragmentView.findViewById(R.id.textViewProgress);
        textViewBatLevel = (TextView ) myFragmentView.findViewById(R.id.batLevel);

        // Get SharedPreferences - 'myPrefs'
        myPrefs = this.getActivity().getSharedPreferences("myPrefs", Context.MODE_WORLD_READABLE);

        buttonB_1 = (Button)myFragmentView.findViewById(R.id.buttonB_1); buttonB_1.setOnClickListener(onClickListener);
        buttonB_2 = (Button)myFragmentView.findViewById(R.id.buttonB_2); buttonB_2.setOnClickListener(onClickListener);
        buttonB_3 = (Button)myFragmentView.findViewById(R.id.buttonB_3); buttonB_3.setOnClickListener(onClickListener);
        buttonB_4 = (Button)myFragmentView.findViewById(R.id.buttonB_4); buttonB_4.setOnClickListener(onClickListener);
        buttonB_5 = (Button)myFragmentView.findViewById(R.id.buttonB_5); buttonB_5.setOnClickListener(onClickListener);
        buttonB_6 = (Button)myFragmentView.findViewById(R.id.buttonB_6); buttonB_6.setOnClickListener(onClickListener);
        buttonB_7 = (Button)myFragmentView.findViewById(R.id.buttonB_7); buttonB_7.setOnClickListener(onClickListener);
        buttonB_8 = (Button)myFragmentView.findViewById(R.id.buttonB_8); buttonB_8.setOnClickListener(onClickListener);
        buttonB_9 = (Button)myFragmentView.findViewById(R.id.buttonB_9); buttonB_9.setOnClickListener(onClickListener);
        buttonB_10 = (Button)myFragmentView.findViewById(R.id.buttonB_10); buttonB_10.setOnClickListener(onClickListener);
        buttonB_11 = (Button)myFragmentView.findViewById(R.id.buttonB_11); buttonB_11.setOnClickListener(onClickListener);
        buttonB_12 = (Button)myFragmentView.findViewById(R.id.buttonB_12); buttonB_12.setOnClickListener(onClickListener);
        buttonB_13 = (Button)myFragmentView.findViewById(R.id.buttonB_13); buttonB_13.setOnClickListener(onClickListener);
        buttonB_14 = (Button)myFragmentView.findViewById(R.id.buttonB_14); buttonB_14.setOnClickListener(onClickListener);
        buttonB_15 = (Button)myFragmentView.findViewById(R.id.buttonB_15); buttonB_15.setOnClickListener(onClickListener);
        buttonB_16 = (Button)myFragmentView.findViewById(R.id.buttonB_16); buttonB_16.setOnClickListener(onClickListener);
        buttonB_17 = (Button)myFragmentView.findViewById(R.id.buttonB_17); buttonB_17.setOnClickListener(onClickListener);
        buttonB_18 = (Button)myFragmentView.findViewById(R.id.buttonB_18); buttonB_18.setOnClickListener(onClickListener);
        buttonB_19 = (Button)myFragmentView.findViewById(R.id.buttonB_19); buttonB_19.setOnClickListener(onClickListener);
        buttonB_20 = (Button)myFragmentView.findViewById(R.id.buttonB_20); buttonB_20.setOnClickListener(onClickListener);
        buttonB_21 = (Button)myFragmentView.findViewById(R.id.buttonB_21); buttonB_21.setOnClickListener(onClickListener);
        buttonB_22 = (Button)myFragmentView.findViewById(R.id.buttonB_22); buttonB_22.setOnClickListener(onClickListener);
        buttonB_23 = (Button)myFragmentView.findViewById(R.id.buttonB_23); buttonB_23.setOnClickListener(onClickListener);
        buttonB_24 = (Button)myFragmentView.findViewById(R.id.buttonB_24); buttonB_24.setOnClickListener(onClickListener);

        // Call doButtonSetup() method to set all 24 buttons
        doButtonSetup();

        // Check for saved ED_Tool Server IP address to connect to
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String storedIPAddress = SP.getString("ipAddress", "");
        if (Objects.equals(storedIPAddress, "")) {
            String line1 = getString(R.string.no_server_line1);
            String line2 = getString(R.string.no_server_line2);
            String msg = "   " + line1 + "\n\n" + line2;
            Helper.showToast_Short_Default(getActivity(), msg);
        }
        else
        {
            showBar();
            mHandler.postDelayed(new Runnable() {
                public void run() {
                    hideBar();
                    new connectTask().execute("");
                }
            }, 1500);
        }

        // Start the battery level check timer
        MyTimerTask mytask = new MyTimerTask();
        timer = new Timer();
        timer.schedule(mytask, 0, 60000); // default: 60000 (60seconds)

        return myFragmentView;
    }

    // Update Battery Level
    private class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    textViewBatLevel.setText("(Bat : " + String.valueOf(Helper.getBatteryPercent(getActivity()))+ "%) ");
                }
            });
        }
    }

    // Attempt to set screen orientation to Portrait only
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            ThemeManager.setPortrait(getActivity());
        }
    }

    // Show and Hide the progressBar layout methods
    private void showBar() {
        progressLayout.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        textViewProgress.setVisibility(View.VISIBLE);
    }
    private void hideBar() {
        progressLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        textViewProgress.setVisibility(View.GONE);
    }

    private static void doButtonSetup(){
        // Set each button text relevant to their sharedpreferences
        String passName = myPrefs.getString("Button1name", "");
        if (!Objects.equals(passName, "")) {
            buttonB_1.setText(passName);
        }
        String passName2 = myPrefs.getString("Button2name", "");
        if (!Objects.equals(passName2, "")) {
            buttonB_2.setText(passName2);
        }
        String passName3 = myPrefs.getString("Button3name", "");
        if (!Objects.equals(passName3, "")) {
            buttonB_3.setText(passName3);
        }
        String passName4 = myPrefs.getString("Button4name", "");
        if (!Objects.equals(passName4, "")) {
            buttonB_4.setText(passName4);
        }
        String passName5 = myPrefs.getString("Button5name", "");
        if (!Objects.equals(passName5, "")) {
            buttonB_5.setText(passName5);
        }
        String passName6 = myPrefs.getString("Button6name", "");
        if (!Objects.equals(passName6, "")) {
            buttonB_6.setText(passName6);
        }
        String passName7 = myPrefs.getString("Button7name", "");
        if (!Objects.equals(passName7, "")) {
            buttonB_7.setText(passName7);
        }
        String passName8 = myPrefs.getString("Button8name", "");
        if (!Objects.equals(passName8, "")) {
            buttonB_8.setText(passName8);
        }
        String passName9 = myPrefs.getString("Button9name", "");
        if (!Objects.equals(passName9, "")) {
            buttonB_9.setText(passName9);
        }
        String passName10 = myPrefs.getString("Button10name", "");
        if (!Objects.equals(passName10, "")) {
            buttonB_10.setText(passName10);
        }
        String passName11 = myPrefs.getString("Button11name", "");
        if (!Objects.equals(passName11, "")) {
            buttonB_11.setText(passName11);
        }
        String passName12 = myPrefs.getString("Button12name", "");
        if (!Objects.equals(passName12, "")) {
            buttonB_12.setText(passName12);
        }
        String passName13 = myPrefs.getString("Button13name", "");
        if (!Objects.equals(passName13, "")) {
            buttonB_13.setText(passName13);
        }
        String passName14 = myPrefs.getString("Button14name", "");
        if (!Objects.equals(passName14, "")) {
            buttonB_14.setText(passName14);
        }
        String passName15 = myPrefs.getString("Button15name", "");
        if (!Objects.equals(passName15, "")) {
            buttonB_15.setText(passName15);
        }
        String passName16 = myPrefs.getString("Button16name", "");
        if (!Objects.equals(passName16, "")) {
            buttonB_16.setText(passName16);
        }
        String passName17 = myPrefs.getString("Button17name", "");
        if (!Objects.equals(passName17, "")) {
            buttonB_17.setText(passName17);
        }
        String passName18 = myPrefs.getString("Button18name", "");
        if (!Objects.equals(passName18, "")) {
            buttonB_18.setText(passName18);
        }
        String passName19 = myPrefs.getString("Button19name", "");
        if (!Objects.equals(passName19, "")) {
            buttonB_19.setText(passName19);
        }
        String passName20 = myPrefs.getString("Button20name", "");
        if (!Objects.equals(passName20, "")) {
            buttonB_20.setText(passName20);
        }
        String passName21 = myPrefs.getString("Button21name", "");
        if (!Objects.equals(passName21, "")) {
            buttonB_21.setText(passName21);
        }
        String passName22 = myPrefs.getString("Button22name", "");
        if (!Objects.equals(passName22, "")) {
            buttonB_22.setText(passName22);
        }
        String passName23 = myPrefs.getString("Button23name", "");
        if (!Objects.equals(passName23, "")) {
            buttonB_23.setText(passName23);
        }
        String passName24 = myPrefs.getString("Button24name", "");
        if (!Objects.equals(passName24, "")) {
            buttonB_24.setText(passName24);
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Get all buttonList string-array's
            final String[] buttonList1 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList1)));
            final String[] buttonList2 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList2)));
            final String[] buttonList3 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList3)));
            final String[] buttonList4 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList4)));
            final String[] buttonList5 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList5)));
            final String[] buttonList6 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList6)));
            final String[] buttonList7 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList7)));
            final String[] buttonList8 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList8)));
            final String[] buttonList9 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList9)));
            final String[] buttonList10 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList10)));
            final String[] buttonList11 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList11)));
            final String[] buttonList12 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList12)));
            final String[] buttonList13 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList13)));
            final String[] buttonList14 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList14)));
            final String[] buttonList15 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList15)));
            final String[] buttonList16 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList16)));
            final String[] buttonList17 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList17)));
            final String[] buttonList18 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList18)));
            final String[] buttonList19 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList19)));
            final String[] buttonList20 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList20)));
            final String[] buttonList21 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList21)));
            final String[] buttonList22 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList22)));
            final String[] buttonList23 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList23)));
            final String[] buttonList24 = getActivity().getResources().getStringArray(Integer.parseInt(String.valueOf(R.array.buttonList24)));

            switch(v.getId()){
                case R.id.buttonB_1:
                    for( String functions : buttonList1 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_2:
                    for( String functions : buttonList2 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_3:
                    for( String functions : buttonList3 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_4:
                    for( String functions : buttonList4 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_5:
                    for( String functions : buttonList5 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_6:
                    for( String functions : buttonList6 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_7:
                    for( String functions : buttonList7 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_8:
                    for( String functions : buttonList8 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_9:
                    for( String functions : buttonList9 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_10:
                    for( String functions : buttonList10 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_11:
                    for( String functions : buttonList11 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_12:
                    for( String functions : buttonList12 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_13:
                    for( String functions : buttonList13 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_14:
                    for( String functions : buttonList14 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_15:
                    for( String functions : buttonList15 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_16:
                    for( String functions : buttonList16 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_17:
                    for( String functions : buttonList17 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_18:
                    for( String functions : buttonList18 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_19:
                    for( String functions : buttonList19 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_20:
                    for( String functions : buttonList20 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_21:
                    for( String functions : buttonList21 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_22:
                    for( String functions : buttonList22 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_23:
                    for( String functions : buttonList23 ) {
                        sendKeyForProcess(functions);
                    }
                break;
                case R.id.buttonB_24:
                    for( String functions : buttonList24 ) {
                        sendKeyForProcess(functions);
                    }
                break;
            }
        }
    };

    private void sendKeyForProcess(String key){
        KeyMap.preProcessKeyCode(key, getActivity());
    }

    public static void sendKey(String finalCode){
        // Send the processed 'finalCode' to the server for the KeyEvent
        if (mTcpClient != null) {
            mTcpClient.sendMessage(finalCode);
        }
    }

    public class connectTask extends AsyncTask<String,String,TCPClient> {
        @Override
        protected TCPClient doInBackground(String... key) {
            //we create a TCPClient object and
            mTcpClient = new TCPClient(new TCPClient.OnMessageReceived() {
                @Override
                //here the messageReceived method is implemented
                public void messageReceived(String message) {
                    //this method calls the onProgressUpdate
                    publishProgress(message);
                    if (mTcpClient != null) {
                        mTcpClient.sendMessage("OK");
                    }
                }
            });
            mTcpClient.run();
            return null;
        }

        @Override
        protected void onProgressUpdate(String... message) {
            super.onProgressUpdate(message);
            if (Objects.equals(Arrays.toString(message), "[handshakeAccepted]")) {
                showBar();
                progressBar.setVisibility(View.GONE);
                textViewProgress.setText(R.string.handshake_ok);
                mHandler.postDelayed(new Runnable() {
                    public void run() {
                        hideBar();
                    }
                }, 2000);
            }
        }
    }

    @Override
    public void onDestroyView() {
        // when this fragment/view is destroyed we will send a message to the server to
        // close the socket and set the server to start again and await reconnection.
        sendKey("SERVER_RESTART");
        TCPClient.closeSocket();
        timer.cancel();
        super.onDestroyView();
    }
}