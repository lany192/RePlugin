

package com.qihoo360.replugin.sample.demo1.activity.notify_test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import com.qihoo360.replugin.sample.demo1.R;

import static com.qihoo360.replugin.sample.demo1.support.NotifyUtils.NOTIFY_KEY;
import static com.qihoo360.replugin.sample.demo1.support.NotifyUtils.TAG;


/**
 * @author RePlugin Team
 */
public class NotifyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_notify);
        try {
            ((TextView)findViewById(R.id.btn_show_notify)).setText(getIntent().getStringExtra(NOTIFY_KEY));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            finish();
        }
    }
}
