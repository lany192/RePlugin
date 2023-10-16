

package com.qihoo360.loader2;

import android.os.IBinder;
import android.util.Log;

import com.qihoo360.replugin.RePluginInternal;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * 运行时 dump 工具类
 *
 * @author RePlugin Team
 */
public class DumpUtils {

    private static final String TAG = RePluginInternal.FOR_DEV ? DumpUtils.class.getSimpleName() : "DumpUtils";

    /**
     * dump RePlugin框架运行时的详细信息，包括：Activity 坑位映射表，正在运行的 Service，以及详细的插件信息
     *
     * @param fd
     * @param writer
     * @param args
     */
    public static void dump(FileDescriptor fd, PrintWriter writer, String[] args) {

        IBinder binder = PluginProviderStub.proxyFetchHostBinder(RePluginInternal.getAppContext());

        if (binder == null) {
            return;
        }

        IPluginHost pluginHost = IPluginHost.Stub.asInterface(binder);

        try {
            String dumpInfo = pluginHost.dump();

            if (RePluginInternal.FOR_DEV) {
                Log.d(TAG, "dumpInfo:" + dumpInfo);
            }

            if (writer != null) {
                writer.println(dumpInfo);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}