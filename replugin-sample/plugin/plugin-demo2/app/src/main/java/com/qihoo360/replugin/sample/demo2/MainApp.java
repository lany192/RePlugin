

package com.qihoo360.replugin.sample.demo2;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.qihoo360.replugin.RePlugin;
public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RePlugin.registerPluginBinder("demo2test", new Demo2Impl());
    }

    public static void helloFromDemo1(Context c, String text) {
        Toast.makeText(c, "Demo2: hello! " + text, Toast.LENGTH_SHORT).show();
    }
}
