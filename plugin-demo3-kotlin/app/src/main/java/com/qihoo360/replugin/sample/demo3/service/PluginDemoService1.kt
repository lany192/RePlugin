

package com.qihoo360.replugin.sample.demo3.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

import com.qihoo360.replugin.sample.demo3.support.LogX

/**
 * @author RePlugin Team
 */
class PluginDemoService1 : Service() {

    override fun onCreate() {
        super.onCreate()

        LogX.logDebug(TAG, "onCreate()")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val action = intent.action
        Toast.makeText(this, "PluginDemoService1.action = " + action, Toast.LENGTH_SHORT).show()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        LogX.logDebug(TAG, "onDestroy()")
    }

    companion object {

        val TAG = "demo.service"
    }
}
