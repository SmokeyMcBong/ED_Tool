/**
 * Created by theFONZ on 18/03/15.
 */

package com.thefonz.ed_tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.thefonz.ed_tool.utils.Constants;
import com.thefonz.ed_tool.utils.Helper;

public class Tab_Rares extends Fragment
{
    private LinearLayout progressLayout;
    private ProgressBar progressBar;
    private TextView TextViewProgress;
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myFragmentView = inflater.inflate(R.layout.tab_rares, container, false);

        webView = (WebView) myFragmentView.findViewById(R.id.webView);
        progressLayout = (LinearLayout) myFragmentView.findViewById(R.id.progressLayout);
        progressBar = (ProgressBar) myFragmentView.findViewById(R.id.progressBar);
        TextViewProgress = (TextView ) myFragmentView.findViewById(R.id.textViewProgress);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String downloadType = SP.getString("tradeRouteSite", "2");
        String TRADEURL = null;

        assert downloadType != null;
            if (downloadType.equalsIgnoreCase("1")) {
                TRADEURL = Constants.TRADEURL1;
            }
            else if (downloadType.equalsIgnoreCase("2")) {
                TRADEURL = Constants.TRADEURL2;
            }
            else if (downloadType.equalsIgnoreCase("3")) {
                TRADEURL = Constants.TRADEURL3;
            }

        final Button button_back = (Button) myFragmentView
                .findViewById(R.id.button_back);
        final Button button_forward = (Button) myFragmentView
                .findViewById(R.id.button_forward);
        final Button button_refresh = (Button) myFragmentView
                .findViewById(R.id.button_refresh);

        // Configure related browser settings
        WebSettings wv1 = webView.getSettings();
        wv1.setLoadsImagesAutomatically(true);
        wv1.setLightTouchEnabled(false);
        wv1.setPluginState(WebSettings.PluginState.ON);
        wv1.setJavaScriptEnabled(true);
        wv1.setLoadWithOverviewMode(true);
        wv1.setUseWideViewPort(true);
        wv1.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wv1.setBuiltInZoomControls(true);
        wv1.setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17");
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        webView.setWebViewClient(new MyBrowser());
        // Load the initial URL
        webView.loadUrl(TRADEURL);

        // Define back,forward and refresh webview control buttons
        button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    showBar();
                    webView.goBack();
                }
            }
        });
        button_forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (webView.canGoForward()) {
                    showBar();
                    webView.goForward();
                }
            }
        });
        button_refresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showBar();
                String currentURL = webView.getUrl();
                webView.loadUrl(currentURL);
            }
        });
        return myFragmentView;
    }

    // Attempt to set screen orientation to full sensor
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            Activity a = getActivity();
            if(a != null) a.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        }
    }

    // Show and Hide the progressbar layout methods...
    private void showBar() {
        progressLayout.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        TextViewProgress.setVisibility(View.VISIBLE);
    }
    private void hideBar() {
        progressLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        TextViewProgress.setVisibility(View.GONE);
    }

    // Manages the behavior when URLs are loaded
    private class MyBrowser extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            showBar();
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains("youtube")) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                return true;
            } else {
                showBar();
                view.loadUrl(url);
                return true;
            }
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            hideBar();
        }
        // Send onReceivedError to General webView Error handler
        public void onReceivedError (WebView view, int errorCode, String description, String failingUrl) {
            Context context = getActivity();
            String tabName = "Tab_Rares";
            Helper.webView_ErrorHandler(tabName, errorCode, description, failingUrl);
        }
    }
}