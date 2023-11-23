

package com.qihoo360.replugin.component.dummy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.qihoo360.loader2.PMF;
import com.qihoo360.replugin.helper.LogRelease;

import static com.qihoo360.replugin.helper.LogDebug.PLUGIN_TAG;
import static com.qihoo360.replugin.helper.LogRelease.LOGR;

/**
 * 若坑位出现丢失或错乱，则通过读取Intent.Category来做个中转
 *
 * @author RePlugin Team
 */
public class ForwardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);

        // INFO forward activity on Create
        if (LOGR) {
            LogRelease.i(PLUGIN_TAG, "f.a: o.c");
        }

        Intent intent = getIntent();
        if (intent == null) {
            if (LOGR) {
                LogRelease.e(PLUGIN_TAG, "f.a: nul i");
            }
        }

        PMF.forward(this, intent);
    }
}
