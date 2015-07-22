package com.thefonz.ed_tool;

/**
 * Created by thefonz on 18/03/15.
 */

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
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
import com.thefonz.ed_tool.utils.KeyMap;
import com.thefonz.ed_tool.utils.U;

import java.util.Arrays;
import java.util.Objects;

public class Tab_ButtonBox extends Fragment {

    private static TCPClient mTcpClient;
    LinearLayout progressLayout;
    ProgressBar progressBar;
    TextView TextViewProgress;
    private Handler mHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View myFragmentView = inflater.inflate(R.layout.tab_buttonbox, container, false);

        progressLayout = (LinearLayout) myFragmentView.findViewById(R.id.progressLayout);
        progressBar = (ProgressBar) myFragmentView.findViewById(R.id.progressBar);
        TextViewProgress = (TextView ) myFragmentView.findViewById(R.id.textViewProgress);

        // Initiate SharedPreferences - 'myPrefs'
        // this = this fragment !
        SharedPreferences myPrefs = this.getActivity().getSharedPreferences("myPrefs", Context.MODE_WORLD_READABLE);

        // initialize all buttons and set onclicklisteners for all
        final Button buttonB_1 = (Button)myFragmentView.findViewById(R.id.buttonB_1);
            buttonB_1.setOnClickListener(onClickListener);
        final Button buttonB_2 = (Button)myFragmentView.findViewById(R.id.buttonB_2);
            buttonB_2.setOnClickListener(onClickListener);
        final Button buttonB_3 = (Button)myFragmentView.findViewById(R.id.buttonB_3);
            buttonB_3.setOnClickListener(onClickListener);
        final Button buttonB_4 = (Button)myFragmentView.findViewById(R.id.buttonB_4);
            buttonB_4.setOnClickListener(onClickListener);
        final Button buttonB_5 = (Button)myFragmentView.findViewById(R.id.buttonB_5);
            buttonB_5.setOnClickListener(onClickListener);
        final Button buttonB_6 = (Button)myFragmentView.findViewById(R.id.buttonB_6);
            buttonB_6.setOnClickListener(onClickListener);
        final Button buttonB_7 = (Button)myFragmentView.findViewById(R.id.buttonB_7);
            buttonB_7.setOnClickListener(onClickListener);
        final Button buttonB_8 = (Button)myFragmentView.findViewById(R.id.buttonB_8);
            buttonB_8.setOnClickListener(onClickListener);
        final Button buttonB_9 = (Button)myFragmentView.findViewById(R.id.buttonB_9);
            buttonB_9.setOnClickListener(onClickListener);
        final Button buttonB_10 = (Button)myFragmentView.findViewById(R.id.buttonB_10);
            buttonB_10.setOnClickListener(onClickListener);
        final Button buttonB_11 = (Button)myFragmentView.findViewById(R.id.buttonB_11);
            buttonB_11.setOnClickListener(onClickListener);
        final Button buttonB_12 = (Button)myFragmentView.findViewById(R.id.buttonB_12);
            buttonB_12.setOnClickListener(onClickListener);
        final Button buttonB_13 = (Button)myFragmentView.findViewById(R.id.buttonB_13);
            buttonB_13.setOnClickListener(onClickListener);
        final Button buttonB_14 = (Button)myFragmentView.findViewById(R.id.buttonB_14);
            buttonB_14.setOnClickListener(onClickListener);
        final Button buttonB_15 = (Button)myFragmentView.findViewById(R.id.buttonB_15);
            buttonB_15.setOnClickListener(onClickListener);
        final Button buttonB_16 = (Button)myFragmentView.findViewById(R.id.buttonB_16);
            buttonB_16.setOnClickListener(onClickListener);
        final Button buttonB_17 = (Button)myFragmentView.findViewById(R.id.buttonB_17);
            buttonB_17.setOnClickListener(onClickListener);
        final Button buttonB_18 = (Button)myFragmentView.findViewById(R.id.buttonB_18);
            buttonB_18.setOnClickListener(onClickListener);
        final Button buttonB_19 = (Button)myFragmentView.findViewById(R.id.buttonB_19);
            buttonB_19.setOnClickListener(onClickListener);
        final Button buttonB_20 = (Button)myFragmentView.findViewById(R.id.buttonB_20);
            buttonB_20.setOnClickListener(onClickListener);
        final Button buttonB_21 = (Button)myFragmentView.findViewById(R.id.buttonB_21);
            buttonB_21.setOnClickListener(onClickListener);
        final Button buttonB_22 = (Button)myFragmentView.findViewById(R.id.buttonB_22);
            buttonB_22.setOnClickListener(onClickListener);
        final Button buttonB_23 = (Button)myFragmentView.findViewById(R.id.buttonB_23);
            buttonB_23.setOnClickListener(onClickListener);
        final Button buttonB_24 = (Button)myFragmentView.findViewById(R.id.buttonB_24);
            buttonB_24.setOnClickListener(onClickListener);

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

        // Check for saved ED_Tool Server IP address to connect to
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String storedIPAddress = SP.getString("ipAddress", " ");
        if (Objects.equals(storedIPAddress, " ")) {
            String line1 = getString(R.string.no_server_line1);
            String line2 = getString(R.string.no_server_line2);
            String msg = "   " + line1 + "\n\n" + line2;
            U.showToast_Long(getActivity(), msg);
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
        return myFragmentView;
    }

    // Attempt to set screen orientation to Portrait only
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            Activity a = getActivity();
            if(a != null) a.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    // Show and Hide the progressbar layout methods...
    public void showBar() {
        progressLayout.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        TextViewProgress.setVisibility(View.VISIBLE);
    }
    public void hideBar() {
        progressLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        TextViewProgress.setVisibility(View.GONE);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.buttonB_1:
                    sendKeyForProcess("Button1Function1");
                    sendKeyForProcess("Button1Function2");
                    sendKeyForProcess("Button1Function3");
                    sendKeyForProcess("Button1Function4");
                    sendKeyForProcess("Button1Function5");
                    sendKeyForProcess("Button1Function6");
                break;
                case R.id.buttonB_2:
                    sendKeyForProcess("Button2Function1");
                    sendKeyForProcess("Button2Function2");
                    sendKeyForProcess("Button2Function3");
                    sendKeyForProcess("Button2Function4");
                    sendKeyForProcess("Button2Function5");
                    sendKeyForProcess("Button2Function6");
                break;
                case R.id.buttonB_3:
                    sendKeyForProcess("Button3Function1");
                    sendKeyForProcess("Button3Function2");
                    sendKeyForProcess("Button3Function3");
                    sendKeyForProcess("Button3Function4");
                    sendKeyForProcess("Button3Function5");
                    sendKeyForProcess("Button3Function6");
                break;
                case R.id.buttonB_4:
                    sendKeyForProcess("Button4Function1");
                    sendKeyForProcess("Button4Function2");
                    sendKeyForProcess("Button4Function3");
                    sendKeyForProcess("Button4Function4");
                    sendKeyForProcess("Button4Function5");
                    sendKeyForProcess("Button4Function6");
                break;
                case R.id.buttonB_5:
                    sendKeyForProcess("Button5Function1");
                    sendKeyForProcess("Button5Function2");
                    sendKeyForProcess("Button5Function3");
                    sendKeyForProcess("Button5Function4");
                    sendKeyForProcess("Button5Function5");
                    sendKeyForProcess("Button5Function6");
                break;
                case R.id.buttonB_6:
                    sendKeyForProcess("Button6Function1");
                    sendKeyForProcess("Button6Function2");
                    sendKeyForProcess("Button6Function3");
                    sendKeyForProcess("Button6Function4");
                    sendKeyForProcess("Button6Function5");
                    sendKeyForProcess("Button6Function6");
                break;
                case R.id.buttonB_7:
                    sendKeyForProcess("Button7Function1");
                    sendKeyForProcess("Button7Function2");
                    sendKeyForProcess("Button7Function3");
                    sendKeyForProcess("Button7Function4");
                    sendKeyForProcess("Button7Function5");
                    sendKeyForProcess("Button7Function6");
                break;
                case R.id.buttonB_8:
                    sendKeyForProcess("Button8Function1");
                    sendKeyForProcess("Button8Function2");
                    sendKeyForProcess("Button8Function3");
                    sendKeyForProcess("Button8Function4");
                    sendKeyForProcess("Button8Function5");
                    sendKeyForProcess("Button8Function6");
                break;
                case R.id.buttonB_9:
                    sendKeyForProcess("Button9Function1");
                    sendKeyForProcess("Button9Function2");
                    sendKeyForProcess("Button9Function3");
                    sendKeyForProcess("Button9Function4");
                    sendKeyForProcess("Button9Function5");
                    sendKeyForProcess("Button9Function6");
                break;
                case R.id.buttonB_10:
                    sendKeyForProcess("Button10Function1");
                    sendKeyForProcess("Button10Function2");
                    sendKeyForProcess("Button10Function3");
                    sendKeyForProcess("Button10Function4");
                    sendKeyForProcess("Button10Function5");
                    sendKeyForProcess("Button10Function6");
                break;
                case R.id.buttonB_11:
                    sendKeyForProcess("Button11Function1");
                    sendKeyForProcess("Button11Function2");
                    sendKeyForProcess("Button11Function3");
                    sendKeyForProcess("Button11Function4");
                    sendKeyForProcess("Button11Function5");
                    sendKeyForProcess("Button11Function6");
                break;
                case R.id.buttonB_12:
                    sendKeyForProcess("Button12Function1");
                    sendKeyForProcess("Button12Function2");
                    sendKeyForProcess("Button12Function3");
                    sendKeyForProcess("Button12Function4");
                    sendKeyForProcess("Button12Function5");
                    sendKeyForProcess("Button12Function6");
                break;
                case R.id.buttonB_13:
                    sendKeyForProcess("Button13Function1");
                    sendKeyForProcess("Button13Function2");
                    sendKeyForProcess("Button13Function3");
                    sendKeyForProcess("Button13Function4");
                    sendKeyForProcess("Button13Function5");
                    sendKeyForProcess("Button13Function6");
                break;
                case R.id.buttonB_14:
                    sendKeyForProcess("Button14Function1");
                    sendKeyForProcess("Button14Function2");
                    sendKeyForProcess("Button14Function3");
                    sendKeyForProcess("Button14Function4");
                    sendKeyForProcess("Button14Function5");
                    sendKeyForProcess("Button14Function6");
                break;
                case R.id.buttonB_15:
                    sendKeyForProcess("Button15Function1");
                    sendKeyForProcess("Button15Function2");
                    sendKeyForProcess("Button15Function3");
                    sendKeyForProcess("Button15Function4");
                    sendKeyForProcess("Button15Function5");
                    sendKeyForProcess("Button15Function6");
                break;
                case R.id.buttonB_16:
                    sendKeyForProcess("Button16Function1");
                    sendKeyForProcess("Button16Function2");
                    sendKeyForProcess("Button16Function3");
                    sendKeyForProcess("Button16Function4");
                    sendKeyForProcess("Button16Function5");
                    sendKeyForProcess("Button16Function6");
                break;
                case R.id.buttonB_17:
                    sendKeyForProcess("Button17Function1");
                    sendKeyForProcess("Button17Function2");
                    sendKeyForProcess("Button17Function3");
                    sendKeyForProcess("Button17Function4");
                    sendKeyForProcess("Button17Function5");
                    sendKeyForProcess("Button17Function6");
                break;
                case R.id.buttonB_18:
                    sendKeyForProcess("Button18Function1");
                    sendKeyForProcess("Button18Function2");
                    sendKeyForProcess("Button18Function3");
                    sendKeyForProcess("Button18Function4");
                    sendKeyForProcess("Button18Function5");
                    sendKeyForProcess("Button18Function6");
                break;
                case R.id.buttonB_19:
                    sendKeyForProcess("Button19Function1");
                    sendKeyForProcess("Button19Function2");
                    sendKeyForProcess("Button19Function3");
                    sendKeyForProcess("Button19Function4");
                    sendKeyForProcess("Button19Function5");
                    sendKeyForProcess("Button19Function6");
                break;
                case R.id.buttonB_20:
                    sendKeyForProcess("Button20Function1");
                    sendKeyForProcess("Button20Function2");
                    sendKeyForProcess("Button20Function3");
                    sendKeyForProcess("Button20Function4");
                    sendKeyForProcess("Button20Function5");
                    sendKeyForProcess("Button20Function6");
                break;
                case R.id.buttonB_21:
                    sendKeyForProcess("Button21Function1");
                    sendKeyForProcess("Button21Function2");
                    sendKeyForProcess("Button21Function3");
                    sendKeyForProcess("Button21Function4");
                    sendKeyForProcess("Button21Function5");
                    sendKeyForProcess("Button21Function6");
                break;
                case R.id.buttonB_22:
                    sendKeyForProcess("Button22Function1");
                    sendKeyForProcess("Button22Function2");
                    sendKeyForProcess("Button22Function3");
                    sendKeyForProcess("Button22Function4");
                    sendKeyForProcess("Button22Function5");
                    sendKeyForProcess("Button22Function6");
                break;
                case R.id.buttonB_23:
                    sendKeyForProcess("Button23Function1");
                    sendKeyForProcess("Button23Function2");
                    sendKeyForProcess("Button23Function3");
                    sendKeyForProcess("Button23Function4");
                    sendKeyForProcess("Button23Function5");
                    sendKeyForProcess("Button23Function6");
                break;
                case R.id.buttonB_24:
                    sendKeyForProcess("Button24Function1");
                    sendKeyForProcess("Button24Function2");
                    sendKeyForProcess("Button24Function3");
                    sendKeyForProcess("Button24Function4");
                    sendKeyForProcess("Button24Function5");
                    sendKeyForProcess("Button24Function6");
                break;
            }
        }
    };

    public void sendKeyForProcess(String key){
        SharedPreferences myPrefs = this.getActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String str2 = myPrefs.getString(key, "");
        // send str2 to KeyMap.processKeyCode to get the relevant KeyCode to send
        KeyMap.processKeyCode(str2);
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
                TextViewProgress.setText(R.string.handshake_ok);
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
        sendKey("CLOSE_SOCKET");
        super.onDestroyView();
    }
}