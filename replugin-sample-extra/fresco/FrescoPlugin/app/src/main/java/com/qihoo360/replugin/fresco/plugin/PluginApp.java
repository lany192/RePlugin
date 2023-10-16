

package com.qihoo360.replugin.fresco.plugin;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fresco.patch.FrescoPatch;
public class PluginApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        FrescoPatch.initialize(this);
    }
}
