package com.qihoo360.replugin;

import android.app.Application;
import android.content.Context;

import com.qihoo360.mobilesafe.core.BuildConfig;

/**
 * 对框架暴露的一些通用的接口。
 * <p>
 * 注意：插件框架内部使用，外界请不要调用。
 *
 * @author RePlugin Team
 */
public class RePluginInternal {

    public static final boolean FOR_DEV = BuildConfig.DEBUG;

    // FIXME 不建议缓存Application对象，容易导致InstantRun失效（警告中写着，具体原因待分析）
    static Context sAppContext;

    static void init(Application app) {
        sAppContext = app;
    }

    /**
     * 获取宿主注册时的Context对象
     */
    public static Context getAppContext() {
        return sAppContext;
    }

    /**
     * 获取宿主注册时的ClassLoader
     */
    public static ClassLoader getAppClassLoader() {
        return getAppContext().getClassLoader();
    }
}
