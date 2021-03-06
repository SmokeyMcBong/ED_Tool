/**
 * Created by theFONZ on 18/03/15.
 */

package com.thefonz.ed_tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.thefonz.ed_tool.utils.Constants;
import com.thefonz.ed_tool.utils.Helper;

public class Tab_Galnet extends Fragment {

    private LinearLayout progressLayout;
    private ProgressBar progressBar;
    private TextView TextViewProgress;
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myFragmentView = inflater.inflate(R.layout.tab_galnet, container, false);

        webView = (WebView) myFragmentView.findViewById(R.id.webView);
        progressLayout = (LinearLayout) myFragmentView.findViewById(R.id.progressLayout);
        progressBar = (ProgressBar) myFragmentView.findViewById(R.id.progressBar);
        TextViewProgress = (TextView ) myFragmentView.findViewById(R.id.textViewProgress);

        final Button button_back = (Button) myFragmentView
                .findViewById(R.id.button_back);
        final Button button_forward = (Button) myFragmentView
                .findViewById(R.id.button_forward);
        final Button button_refresh = (Button) myFragmentView
                .findViewById(R.id.button_refresh);

        // Configure related browser settings
        WebSettings wv3 = webView.getSettings();
        webView.setInitialScale(125);
//        wv3.setLoadsImagesAutomatically(false);
        wv3.setLightTouchEnabled(false);
        wv3.setPluginState(WebSettings.PluginState.ON);
        wv3.setJavaScriptEnabled(true);
        wv3.setLoadWithOverviewMode(true);
        wv3.setUseWideViewPort(false);
//        wv3.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wv3.setBuiltInZoomControls(true);
        wv3.setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17");
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        webView.setWebViewClient(new MyBrowser());
        // Load the initial URL
        webView.loadUrl(Constants.RSSFEEDURL);

        // Define back,forward and refresh webview control buttons
        button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(webView.canGoBack()){
                    showBar();
                    webView.goBack();
                }
            }
        });
        button_forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(webView.canGoForward()){
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

    // Show and Hide the progressbar methods...
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
        // WebView SSL error handler
        @Override
        public void onReceivedSslError(WebView view, @NonNull SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors
        }
        // Send onReceivedError to General webView Error handler
        public void onReceivedError (WebView view, int errorCode, String description, String failingUrl) {
            Context context = getActivity();
            String tabName = "Tab_Galnet";
            Helper.webView_ErrorHandler(tabName, errorCode, description, failingUrl);
        }
    }
}