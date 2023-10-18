package com.qihoo360.replugin.base;

import android.content.Context;
import android.content.Intent;

import com.qihoo360.replugin.helper.HostConfigHelper;

import com.qihoo360.loader.utils.LocalBroadcastManager;

import java.util.concurrent.Callable;

/**
 * 和LocalBroadcastManager有关的帮助类
 *
 * @author RePlugin Team
 * @see androidx.localbroadcastmanager.content.LocalBroadcastManager
 */

public class LocalBroadcastHelper {

    /**
     * 和LocalBroadcastManager.sendBroadcastSync类似，唯一的区别是执行所在线程：前者只在调用所在线程，本方法则在UI线程。
     * <p>
     * 可防止onReceiver在其它线程中被调用到。特别适用于AIDL、没有Looper的线程中调用此方法。
     *
     * @param intent 要发送的Intent信息
     * @see LocalBroadcastManager#sendBroadcastSync(Intent)
     */
    public static void sendBroadcastSyncUi(final Context context, final Intent intent) {
        try {
            ThreadUtils.syncToMainThread(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    LocalBroadcastManager.getInstance(context).sendBroadcastSync(intent);
                    return null;
                }
            }, 10000);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
}
