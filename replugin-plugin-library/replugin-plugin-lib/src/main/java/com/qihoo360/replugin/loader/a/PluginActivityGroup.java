

package com.qihoo360.replugin.loader.a;

import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.qihoo360.replugin.RePluginInternal;
import com.qihoo360.replugin.helper.LogRelease;
import com.qihoo360.replugin.loader.PluginResource;

/**
 * @author RePlugin Team
 */
public abstract class PluginActivityGroup extends ActivityGroup {

    private PluginResource pluginResource;

    @Override
    protected void attachBaseContext(Context newBase) {
        newBase = RePluginInternal.createActivityContext(this, newBase);
        pluginResource = new PluginResource(newBase);
        super.attachBaseContext(newBase);
    }

    @Override
    public Resources getResources() {
        if (pluginResource != null){
            return pluginResource;
        }
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //
        RePluginInternal.handleActivityCreateBefore(this, savedInstanceState);

        super.onCreate(savedInstanceState);

        //
        RePluginInternal.handleActivityCreate(this, savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        //
        RePluginInternal.handleActivityDestroy(this);

        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //
        RePluginInternal.handleRestoreInstanceState(this, savedInstanceState);

        try {
            super.onRestoreInstanceState(savedInstanceState);
        } catch (Throwable e) {
            // Added by Jiongxuan Zhang
            // Crash Hash: B1F67129BC6A67C882AF2BBE62202BF0
            // java.lang.IllegalArgumentException: Wrong state class异常
            // 原因：恢复现场时，Activity坑位找错了。通常是用于占坑的Activity的层级过深导致
            // 举例：假如我们只有一个坑位可用，A和B分别是清理和通讯录的两个Activity
            //      如果进程重启，系统原本恢复B，却走到了A，从而出现此问题
            // 解决：将其Catch住，这样系统在找ViewState时不会出错。
            // 后遗症：
            // 1、可能无法恢复系统级View的保存的状态；
            // 2、如果自己代码处理不当，可能会出现异常。故自己代码一定要用SecExtraUtils来获取Bundle数据
            if (LogRelease.LOGR) {
                LogRelease.e("PluginActivityGroup", "o r i s: p=" + getPackageCodePath() + "; " + e.getMessage(), e);
            }
        }
    }

    @Override
    public void startActivity(Intent intent) {
        //
        if (RePluginInternal.startActivity(this, intent)) {
            return;
        }

        super.startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        //
        if (RePluginInternal.startActivityForResult(this, intent, requestCode)) {
            return;
        }

        super.startActivityForResult(intent, requestCode);
    }
}
