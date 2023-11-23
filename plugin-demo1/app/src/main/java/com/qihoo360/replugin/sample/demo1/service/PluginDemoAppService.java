

package com.qihoo360.replugin.sample.demo1.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.qihoo360.replugin.sample.demo1.support.LogX;

/**
 * @author RePlugin Team
 */
public class PluginDemoAppService extends Service {

    public static final String TAG = "demo.service.app";

    @Override
    public void onCreate() {
        super.onCreate();

        LogX.logDebug(TAG, "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        Log.d(TAG, "onStartCommand(): act=" + action);
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
