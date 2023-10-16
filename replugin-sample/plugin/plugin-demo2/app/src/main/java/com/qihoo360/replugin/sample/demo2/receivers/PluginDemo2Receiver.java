

package com.qihoo360.replugin.sample.demo2.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
public class PluginDemo2Receiver extends BroadcastReceiver {

    public static final String ACTION = "com.qihoo360.repluginapp.receiver.ACTION1";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            if (action.equals(ACTION)) {
                String name = intent.getStringExtra("name");
                Toast.makeText(context, "Plugin2-action: " + action + ", name = " + name, Toast.LENGTH_LONG).show();
            }
        }
    }
}
