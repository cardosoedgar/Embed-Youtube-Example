package com.cardosoedgar.minhaappwebview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WebViewFragment extends Fragment{

    WebView mWebView;

    public WebViewFragment() {
    }

    @SuppressWarnings("setJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_web_view, container, false);

        mWebView = (WebView) fragmentView.findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.loadUrl("file:///android_asset/local.html");
        // Inflate the layout for this fragment
        return fragmentView;
    }

    public void play() {
        mWebView.loadUrl("javascript:play();");
    }

    public void pause() {
        mWebView.loadUrl("javascript:pause();");
    }
}
