

package com.qihoo360.replugin.sample.webview.common;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
public class CommonWebChromeClient extends WebChromeClient {

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        try {
            if (view instanceof CommonWebView) {
                CommonWebView webview = (CommonWebView) view;
                webview.injectJavascriptInterfaces();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onProgressChanged(view, newProgress);
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        try {
            if (view instanceof CommonWebView) {
                CommonWebView webview = (CommonWebView) view;
                if (webview.handleJsInterface(view, url, message, defaultValue, result)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onJsPrompt(view, url, message, defaultValue, result);
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        try {
            if (view instanceof CommonWebView) {
                CommonWebView webview = (CommonWebView) view;
                webview.injectJavascriptInterfaces();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
