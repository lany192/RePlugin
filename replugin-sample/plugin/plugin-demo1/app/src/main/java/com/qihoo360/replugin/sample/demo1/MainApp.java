

package com.qihoo360.replugin.sample.demo1;

import android.app.Application;
import android.content.Intent;

import com.qihoo360.replugin.sample.demo1.service.PluginDemoAppService;
public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 在插件启动时就去开启一个服务，以模拟个别插件的复杂行为
        testStartService();
    }

    private void testStartService() {
        Intent i = new Intent(this, PluginDemoAppService.class);
        i.setAction("MyNameIsApp");
        startService(i);
    }
}
