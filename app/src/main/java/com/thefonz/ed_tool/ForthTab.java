package com.thefonz.ed_tool;

/**
 * Created by thefonz on 18/03/15.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ForthTab extends Fragment
{
    private WebView myWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
//        return inflater.inflate(R.layout.forth_tab, container, false);

//        myWebView = (WebView) findViewById(R.id.webview);
        View view = inflater.inflate(R.layout.forth_tab, container, false);
        final WebView myWebView = (WebView)  view.findViewById(R.id.webview);
//        return view;
        // Configure related browser settings
        myWebView.getSettings().setLoadsImagesAutomatically(true);
        myWebView.getSettings().setLightTouchEnabled(false);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17");
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        myWebView.setWebViewClient(new MyBrowser());
        // Load the initial URL
        myWebView.loadUrl("http://www.reddit.com/r/EliteDangerous/");

        myWebView.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack())
                {
                    myWebView.goBack();
                    return true;
                }else if( keyCode == KeyEvent.KEYCODE_FORWARD && myWebView.canGoForward()){
                    myWebView.goForward();
                    return true;
                }

                return false;
            }
        } );

        return view;
    }
    // Manages the behavior when URLs are loaded
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}