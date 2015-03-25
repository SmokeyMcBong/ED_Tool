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
import android.widget.Toast;

public class ForthTab extends Fragment
{
    private WebView myWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.forth_tab, container, false);

        final WebView myWebView2 = (WebView)  view.findViewById(R.id.webview2);

        final Button button_back = (Button) view
                .findViewById(R.id.button_back);
        final Button button_forward = (Button) view
                .findViewById(R.id.button_forward);
        final Button button_refresh = (Button) view
                .findViewById(R.id.button_refresh);

        // Configure related browser settings
        WebSettings wv2 = myWebView2.getSettings();
        wv2.setLoadsImagesAutomatically(true);
        wv2.setLightTouchEnabled(false);
        wv2.setPluginState(WebSettings.PluginState.ON);
        wv2.setJavaScriptEnabled(true);
        wv2.setLoadWithOverviewMode(true);
        wv2.setUseWideViewPort(true);
        wv2.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wv2.setBuiltInZoomControls(true);
        wv2.setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17");
        myWebView2.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        myWebView2.setWebViewClient(new MyBrowser());
        // Load the initial URL
        myWebView2.loadUrl("http://www.reddit.com/r/EliteDangerous/");

        // Define back,forward and refresh webview control buttons
        button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(myWebView2.canGoBack()){
                    myWebView2.goBack();
                    Toast toast = Toast.makeText(getActivity(),
                            R.string.goingback,
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        button_forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(myWebView2.canGoForward()){
                    myWebView2.goForward();
                    Toast toast = Toast.makeText(getActivity(),
                            R.string.goingforward,
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        button_refresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myWebView2.reload();
                Toast toast = Toast.makeText(getActivity(),
                        R.string.refreshing,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return view;
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
            if (errorCode == ERROR_AUTHENTICATION) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_AUTHENTICATION,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_BAD_URL) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_BAD_URL,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_CONNECT) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_CONNECT,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_FAILED_SSL_HANDSHAKE) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_FAILED_SSL_HANDSHAKE,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_FILE) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_FILE,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_FILE_NOT_FOUND) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_FILE_NOT_FOUND,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_HOST_LOOKUP) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_HOST_LOOKUP,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_IO) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_IO,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_PROXY_AUTHENTICATION) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_PROXY_AUTHENTICATION,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_REDIRECT_LOOP) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_REDIRECT_LOOP,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_TIMEOUT) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_TIMEOUT,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_TOO_MANY_REQUESTS) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_TOO_MANY_REQUESTS,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_UNKNOWN) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_UNKNOWN,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_UNSUPPORTED_AUTH_SCHEME) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_UNSUPPORTED_AUTH_SCHEME,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
            if (errorCode == ERROR_UNSUPPORTED_SCHEME) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.ERROR_UNSUPPORTED_SCHEME,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}