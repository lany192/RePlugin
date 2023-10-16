


package com.qihoo360.replugin;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;

import com.qihoo360.loader2.IPlugin;
public class Entry {

    /**
     * @param context 插件上下文
     * @param cl      HOST程序的类加载器
     * @param manager 插件管理器
     * @return
     */
    public static final IBinder create(Context context, ClassLoader cl, IBinder manager) {
        // 初始化插件框架
        RePluginFramework.init(cl);
        // 初始化Env
        RePluginEnv.init(context, cl, manager);

        return new IPlugin.Stub() {
            @Override
            public IBinder query(String name) throws RemoteException {
                return RePluginServiceManager.getInstance().getService(name);
            }
        };
    }
}
