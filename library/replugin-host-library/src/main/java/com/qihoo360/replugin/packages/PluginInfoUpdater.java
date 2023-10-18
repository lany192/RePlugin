package com.qihoo360.replugin.packages;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

import com.qihoo360.loader.utils.LocalBroadcastManager;

import com.qihoo360.loader2.MP;
import com.qihoo360.replugin.base.IPC;
import com.qihoo360.replugin.helper.HostConfigHelper;
import com.qihoo360.replugin.helper.LogDebug;
import com.qihoo360.replugin.model.PluginInfo;

/**
 * 当有插件信息需要通知各进程更新时触发
 *
 * @author RePlugin Team
 */

public class PluginInfoUpdater {
    private static final String TAG = "PluginInfoUpdater";

    private static final String ACTION_UPDATE_INFO = "com.qihoo360.replugin.pms.ACTION_UPDATE_INFO";

    public static final String ACTION_UNINSTALL_PLUGIN = "ACTION_UNINSTALL_PLUGIN";

    public static void register(Context context) {
        IntentFilter filter = new IntentFilter(ACTION_UPDATE_INFO);
        LocalBroadcastManager.getInstance(context).registerReceiver(new UpdateReceiver(), filter);
    }

    static void updateIsUsed(Context context, String pluginName, boolean used) {
        if (LogDebug.LOG) {
            LogDebug.i(TAG, "updateIsUsed: Prepare to send broadcast, pn=" + pluginName + "; used=" + used);
        }
        Intent intent = new Intent(ACTION_UPDATE_INFO);
        intent.putExtra("pn", pluginName);
        intent.putExtra("used", used);
        IPC.sendLocalBroadcast2All(context, intent);
    }

    private static class UpdateReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), ACTION_UPDATE_INFO)) {
                PluginInfoUpdater.onReceiveUpdateInfo(intent);
            }
        }
    }

    private static boolean onReceiveUpdateInfo(Intent intent) {
        if (LogDebug.LOG) {
            LogDebug.i(TAG, "onReceiveUpdateInfo: in=" + intent);
        }
        String pn = intent.getStringExtra("pn");
        if (TextUtils.isEmpty(pn)) {
            return false;
        }

        // 获取“不经过Clone”的PluginInfo，因为要修改
        PluginInfo pi = MP.getPlugin(pn, false);
        if (pi == null) {
            return false;
        }

        // 若填写了used，则修改它
        if (intent.hasExtra("used")) {
            boolean used = intent.getBooleanExtra("used", false);
            if (LogDebug.LOG) {
                LogDebug.i(TAG, "onReceiveUpdateInfo: pn=" + pn + "; setIsUsed=" + used);
            }
            pi.setIsUsed(used);
        }
        return true;
    }
}
