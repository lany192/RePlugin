

package com.qihoo360.replugin.component.dummy;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;

/**
 * 表示一个“仿造的”Service，启动后什么事情也不做 <p>
 * 此类可防止系统调用插件时因类找不到而崩溃。请参见 registerHookingClass 的说明
 *
 * @see com.qihoo360.replugin.RePlugin#registerHookingClass(String, ComponentName, Class)
 * @author RePlugin Team
 */
public class DummyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        stopSelf();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
