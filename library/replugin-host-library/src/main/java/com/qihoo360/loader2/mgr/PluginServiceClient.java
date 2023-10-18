package com.qihoo360.loader2.mgr;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/**
 * （该类仅为兼容360手机卫士的旧插件而存在，因涉及到反射而保留此类）
 *
 * @deprecated 请使用新类
 * @see com.qihoo360.replugin.component.service.PluginServiceClient
 * @author RePlugin Team
 */
public class PluginServiceClient {

    /**
     * @deprecated
     */
    public static ComponentName startService(Context context, Intent intent) {
        return com.qihoo360.replugin.component.service.PluginServiceClient.startService(context, intent);
    }

    /**
     * @deprecated
     */
    public static boolean stopService(Context context, Intent intent) {
        return com.qihoo360.replugin.component.service.PluginServiceClient.stopService(context, intent);
    }

    /**
     * @deprecated
     */
    public static boolean bindService(Context context, Intent intent, ServiceConnection sc, int flags) {
        return com.qihoo360.replugin.component.service.PluginServiceClient.bindService(context, intent, sc, flags);
    }

    /**
     * @deprecated
     */
    public static boolean unbindService(Context context, ServiceConnection sc) {
        return com.qihoo360.replugin.component.service.PluginServiceClient.unbindService(context, sc);
    }

    /**
     * @deprecated
     */
    public static void stopSelf(Service s) {
        com.qihoo360.replugin.component.service.PluginServiceClient.stopSelf(s);
    }
}

