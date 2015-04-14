package com.thefonz.ed_tool;

/**
 * Created by thefonz on 18/03/15.
 */

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.thefonz.ed_tool.tcp_client.TCPClient;
import com.thefonz.ed_tool.utils.U;

import java.util.Arrays;
import java.util.Objects;

public class Tab_ButtonBox extends Fragment {

    private TCPClient mTcpClient;
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
            String msg = "   No saved Server IP address found,\n\nPlease enter the Server IP in the Button-Box settings page";
            U.showToast_Long(getActivity(), msg);
            U.m("" + msg);
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
                    sendKey("Button1Function1");
                    sendKey("Button1Function2");
                    sendKey("Button1Function3");
                    sendKey("Button1Function4");
                    sendKey("Button1Function5");
                    sendKey("Button1Function6");
                    break;
                case R.id.buttonB_2:
                    sendKey("Button2Function1");
                    sendKey("Button2Function2");
                    sendKey("Button2Function3");
                    sendKey("Button2Function4");
                    sendKey("Button2Function5");
                    sendKey("Button2Function6");
                    break;
                case R.id.buttonB_3:
                    sendKey("Button3Function1");
                    sendKey("Button3Function2");
                    sendKey("Button3Function3");
                    sendKey("Button3Function4");
                    sendKey("Button3Function5");
                    sendKey("Button3Function6");
                    break;
                case R.id.buttonB_4:
                    sendKey("Button4Function1");
                    sendKey("Button4Function2");
                    sendKey("Button4Function3");
                    sendKey("Button4Function4");
                    sendKey("Button4Function5");
                    sendKey("Button4Function6");
                    break;
                case R.id.buttonB_5:
                    sendKey("Button5Function1");
                    sendKey("Button5Function2");
                    sendKey("Button5Function3");
                    sendKey("Button5Function4");
                    sendKey("Button5Function5");
                    sendKey("Button5Function6");
                    break;
                case R.id.buttonB_6:
                    sendKey("Button6Function1");
                    sendKey("Button6Function2");
                    sendKey("Button6Function3");
                    sendKey("Button6Function4");
                    sendKey("Button6Function5");
                    sendKey("Button6Function6");
                    break;
                case R.id.buttonB_7:
                    sendKey("Button7Function1");
                    sendKey("Button7Function2");
                    sendKey("Button7Function3");
                    sendKey("Button7Function4");
                    sendKey("Button7Function5");
                    sendKey("Button7Function6");
                    break;
                case R.id.buttonB_8:
                    sendKey("Button8Function1");
                    sendKey("Button8Function2");
                    sendKey("Button8Function3");
                    sendKey("Button8Function4");
                    sendKey("Button8Function5");
                    sendKey("Button8Function6");
                    break;
                case R.id.buttonB_9:
                    sendKey("Button9Function1");
                    sendKey("Button9Function2");
                    sendKey("Button9Function3");
                    sendKey("Button9Function4");
                    sendKey("Button9Function5");
                    sendKey("Button9Function6");
                    break;
                case R.id.buttonB_10:
                    sendKey("Button10Function1");
                    sendKey("Button10Function2");
                    sendKey("Button10Function3");
                    sendKey("Button10Function4");
                    sendKey("Button10Function5");
                    sendKey("Button10Function6");
                    break;
                case R.id.buttonB_11:
                    sendKey("Button11Function1");
                    sendKey("Button11Function2");
                    sendKey("Button11Function3");
                    sendKey("Button11Function4");
                    sendKey("Button11Function5");
                    sendKey("Button11Function6");
                    break;
                case R.id.buttonB_12:
                    sendKey("Button12Function1");
                    sendKey("Button12Function2");
                    sendKey("Button12Function3");
                    sendKey("Button12Function4");
                    sendKey("Button12Function5");
                    sendKey("Button12Function6");
                    break;
                case R.id.buttonB_13:
                    sendKey("Button13Function1");
                    sendKey("Button13Function2");
                    sendKey("Button13Function3");
                    sendKey("Button13Function4");
                    sendKey("Button13Function5");
                    sendKey("Button13Function6");
                    break;
                case R.id.buttonB_14:
                    sendKey("Button14Function1");
                    sendKey("Button14Function2");
                    sendKey("Button14Function3");
                    sendKey("Button14Function4");
                    sendKey("Button14Function5");
                    sendKey("Button14Function6");
                    break;
                case R.id.buttonB_15:
                    sendKey("Button15Function1");
                    sendKey("Button15Function2");
                    sendKey("Button15Function3");
                    sendKey("Button15Function4");
                    sendKey("Button15Function5");
                    sendKey("Button15Function6");
                    break;
                case R.id.buttonB_16:
                    sendKey("Button16Function1");
                    sendKey("Button16Function2");
                    sendKey("Button16Function3");
                    sendKey("Button16Function4");
                    sendKey("Button16Function5");
                    sendKey("Button16Function6");
                    break;
                case R.id.buttonB_17:
                    sendKey("Button17Function1");
                    sendKey("Button17Function2");
                    sendKey("Button17Function3");
                    sendKey("Button17Function4");
                    sendKey("Button17Function5");
                    sendKey("Button17Function6");
                    break;
                case R.id.buttonB_18:
                    sendKey("Button18Function1");
                    sendKey("Button18Function2");
                    sendKey("Button18Function3");
                    sendKey("Button18Function4");
                    sendKey("Button18Function5");
                    sendKey("Button18Function6");
                    break;
                case R.id.buttonB_19:
                    sendKey("Button19Function1");
                    sendKey("Button19Function2");
                    sendKey("Button19Function3");
                    sendKey("Button19Function4");
                    sendKey("Button19Function5");
                    sendKey("Button19Function6");
                    break;
                case R.id.buttonB_20:
                    sendKey("Button20Function1");
                    sendKey("Button20Function2");
                    sendKey("Button20Function3");
                    sendKey("Button20Function4");
                    sendKey("Button20Function5");
                    sendKey("Button20Function6");
                    break;
                case R.id.buttonB_21:
                    sendKey("Button21Function1");
                    sendKey("Button21Function2");
                    sendKey("Button21Function3");
                    sendKey("Button21Function4");
                    sendKey("Button21Function5");
                    sendKey("Button21Function6");
                    break;
                case R.id.buttonB_22:
                    sendKey("Button22Function1");
                    sendKey("Button22Function2");
                    sendKey("Button22Function3");
                    sendKey("Button22Function4");
                    sendKey("Button22Function5");
                    sendKey("Button22Function6");
                    break;
                case R.id.buttonB_23:
                    sendKey("Button23Function1");
                    sendKey("Button23Function2");
                    sendKey("Button23Function3");
                    sendKey("Button23Function4");
                    sendKey("Button23Function5");
                    sendKey("Button23Function6");
                    break;
                case R.id.buttonB_24:
                    sendKey("Button24Function1");
                    sendKey("Button24Function2");
                    sendKey("Button24Function3");
                    sendKey("Button24Function4");
                    sendKey("Button24Function5");
                    sendKey("Button24Function6");
                    break;
            }
        }
    };

    public void sendKey(String key){
        SharedPreferences myPrefs = this.getActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String str2 = myPrefs.getString(key, "");
        if (mTcpClient != null) {
            mTcpClient.sendMessage(str2);
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
                }
            });
            mTcpClient.run();

            return null;
        }

        @Override
        protected void onProgressUpdate(String... message) {
            super.onProgressUpdate(message);
            if (Objects.equals(Arrays.toString(message), "[handshakeAccepted]")) {
                U.m("Result from server = " + Arrays.toString(message));
                U.m(" Connection Successful ");
                showBar();
                progressBar.setVisibility(View.GONE);
                TextViewProgress.setText("Connection Successful");
                mHandler.postDelayed(new Runnable() {
                    public void run() {
                        hideBar();
                    }
                }, 2000);
            }
        }
    }
}