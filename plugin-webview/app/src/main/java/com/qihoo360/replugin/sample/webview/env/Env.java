

package com.qihoo360.replugin.sample.webview.env;

import android.os.Build;
import android.webkit.WebView;

import java.lang.reflect.Method;

/**
 * @author RePlugin Team
 */
public class Env {
    public static final boolean DEBUG = true;
    public static final String TAG = "webview_demo";

    private static void setWebContentsDebuggingEnabled(boolean b) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        try {
            Method m = WebView.class.getMethod("setWebContentsDebuggingEnabled", boolean.class);
            m.invoke(null, b);
        } catch (Exception e) {
            if (Env.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}