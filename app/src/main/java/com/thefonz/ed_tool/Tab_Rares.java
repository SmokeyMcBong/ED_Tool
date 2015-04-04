package com.thefonz.ed_tool;

/**
 * Created by thefonz on 18/03/15.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.thefonz.ed_tool.utils.Constants;
import com.thefonz.ed_tool.utils.Utils;

public class Tab_Rares extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View myFragmentView = inflater.inflate(R.layout.tab_rares, container, false);

        Utils.checkInternet(this.getActivity());

        final WebView myWebView1 = (WebView)  myFragmentView.findViewById(R.id.webview1);

        final Button button_back = (Button) myFragmentView
                .findViewById(R.id.button_back);
        final Button button_forward = (Button) myFragmentView
                .findViewById(R.id.button_forward);
        final Button button_refresh = (Button) myFragmentView
                .findViewById(R.id.button_refresh);

        // Configure related browser settings
        WebSettings wv1 = myWebView1.getSettings();
        wv1.setLoadsImagesAutomatically(true);
        wv1.setLightTouchEnabled(false);
        wv1.setPluginState(WebSettings.PluginState.ON);
        wv1.setJavaScriptEnabled(true);
        wv1.setLoadWithOverviewMode(true);
        wv1.setUseWideViewPort(true);
        wv1.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wv1.setBuiltInZoomControls(true);
        wv1.setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17");
        myWebView1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        myWebView1.setWebViewClient(new MyBrowser());
        // Load the initial URL
        myWebView1.loadUrl(Constants.TRADERURL);

        // Define back,forward and refresh webview control buttons
        button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(myWebView1.canGoBack()){
                    myWebView1.goBack();
                    String msg = getString(R.string.goingback);
                    Utils.showToast_Short(getActivity(), msg);
                }
            }
        });
        button_forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(myWebView1.canGoForward()){
                    myWebView1.goForward();
                    String msg = getString(R.string.goingforward);
                    Utils.showToast_Short(getActivity(), msg);
                }
            }
        });
        button_refresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myWebView1.reload();
                String msg = getString(R.string.refreshing);
                Utils.showToast_Short(getActivity(), msg);
            }
        });
        return myFragmentView;
    }
    // Manages the behavior when URLs are loaded
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains("youtube")) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                return true;
            } else {
                view.loadUrl(url);
                return true;
            }
        }
        // WebView error handler
        public void onReceivedError (WebView view, int errorCode, String description, String failingUrl) {
            final String LOGMETHOD = " onReceivedError ";
            if (errorCode == ERROR_AUTHENTICATION) {
                String LOGBODY = "ERROR_AUTHENTICATION";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_BAD_URL) {
                String LOGBODY = "ERROR_BAD_URL";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_CONNECT) {
                String LOGBODY = "ERROR_CONNECT";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_FAILED_SSL_HANDSHAKE) {
                String LOGBODY = "ERROR_FAILED_SSL_HANDSHAKE";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_FILE) {
                String LOGBODY = "ERROR_FILE";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_FILE_NOT_FOUND) {
                String LOGBODY = "ERROR_FILE_NOT_FOUND";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_HOST_LOOKUP) {
                String LOGBODY = "ERROR_HOST_LOOKUP";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_IO) {
                String LOGBODY = "ERROR_IO";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_PROXY_AUTHENTICATION) {
                String LOGBODY = "ERROR_PROXY_AUTHENTICATION";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_REDIRECT_LOOP) {
                String LOGBODY = "ERROR_REDIRECT_LOOP";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_TIMEOUT) {
                String LOGBODY = "ERROR_TIMEOUT";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_TOO_MANY_REQUESTS) {
                String LOGBODY = "ERROR_TOO_MANY_REQUESTS";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_UNKNOWN) {
                String LOGBODY = "ERROR_UNKNOWN";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_UNSUPPORTED_AUTH_SCHEME) {
                String LOGBODY = "ERROR_UNSUPPORTED_AUTH_SCHEME";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
            if (errorCode == ERROR_UNSUPPORTED_SCHEME) {
                String LOGBODY = "ERROR_UNSUPPORTED_SCHEME";
                Utils.LogError(getActivity(), Constants.TAG, LOGMETHOD, LOGBODY);
            }
        }
    }
}