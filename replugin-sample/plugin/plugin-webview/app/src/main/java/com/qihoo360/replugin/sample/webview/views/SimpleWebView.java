

package com.qihoo360.replugin.sample.webview.views;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.qihoo360.replugin.sample.webview.utils.WebViewResourceHelper;
public class SimpleWebView extends WebView {

    private static String sUserAgent;

    public SimpleWebView(Context context) {
        this(context, null);
    }

    public SimpleWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // webview 插件化后对资源的统一处理
        WebViewResourceHelper.addChromeResourceIfNeeded(context);
    }

    public SimpleWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // webview 插件化后对资源的统一处理
        WebViewResourceHelper.addChromeResourceIfNeeded(context);
    }

    public String getUserAgentEx() {
        if (sUserAgent == null) {
            WebSettings ws = getSettings();
            sUserAgent = ws.getUserAgentString();
        }

        // 此处可自定义自己的UserAgent
        return sUserAgent;
    }

    @Override
    public void loadUrl(String url) {
        // 此处可“种植”Cookie（Q&T）
        super.loadUrl(url);
    }
}
