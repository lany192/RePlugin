

package com.qihoo360.replugin.sample.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

import com.qihoo360.replugin.sample.webview.views.SimpleWebPage;

/**
 * @author RePlugin Team
 */
public class MainActivity extends Activity {

    private SimpleWebPage mWP;

    static final String testUrl = "https://github.com/Qihoo360/RePlugin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.webview);
        LinearLayout rootView = (LinearLayout) findViewById(R.id.root);

        // 添加webview视图
        mWP = new SimpleWebPage(this);
        rootView.addView(mWP);
        mWP.getWebView().loadUrl(testUrl);
    }

}
