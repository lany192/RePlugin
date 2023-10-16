

package com.qihoo360.replugin.sample.demo1.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.qihoo360.replugin.sample.demo1.support.LogX;
public class PluginDemoService2 extends Service {

    public static final String TAG = "demo.service";

    @Override
    public void onCreate() {
        super.onCreate();

        LogX.logDebug(TAG, "PluginDemoService2 onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        Toast.makeText(this, "PluginDemoService2.action = " + action, Toast.LENGTH_SHORT).show();
        LogX.logDebug(TAG, "PluginDemoService2 onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogX.logDebug(TAG, "onDestroy()");
    }
}
