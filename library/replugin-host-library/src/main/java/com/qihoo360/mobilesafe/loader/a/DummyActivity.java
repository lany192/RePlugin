package com.qihoo360.mobilesafe.loader.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.qihoo360.replugin.helper.LogRelease;

import static com.qihoo360.replugin.helper.LogDebug.PLUGIN_TAG;
import static com.qihoo360.replugin.helper.LogRelease.LOGR;


public class DummyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // INFO dummy activity on create finish me.
        if (LOGR) {
            LogRelease.i(PLUGIN_TAG, "d a o c f m");
        }

        // 之所以传Null，是因为系统会直接解析savedInstanceState
        // 这时如果常驻进程已被杀，这时立即恢复后，由于插件还没有准备好，故会出现崩溃情况
        // 详细见：Crash Hash = 5C863A3E0CACDAEA9DBD05B9A7D353FE
        super.onCreate(null);
        setIntent(new Intent());
        try {
            finish();
        } catch (Exception e) {

        }
    }
}
