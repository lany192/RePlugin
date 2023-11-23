

package com.qihoo360.replugin.fresco.host;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fresco.patch.FrescoPatch;
import com.qihoo360.replugin.RePluginApplication;
import com.qihoo360.replugin.RePluginConfig;

/**
 * HostApp
 *
 * @author RePlugin Team
 */
public class HostApp extends RePluginApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化Fresco
        Fresco.initialize(this);

        // 初始化FrescoPath
        FrescoPatch.initialize(this);
    }

    /**
     * RePlugin允许提供各种“自定义”的行为，让您“无需修改源代码”，即可实现相应的功能
     */
    @Override
    protected RePluginConfig createConfig() {
        RePluginConfig c = new RePluginConfig();

        // 允许“插件使用宿主类”
        // 打开这个开关之后，当插件ClassLoader找不到类时，会去看宿主是否有这个类
        // 从而，实现插件复用宿主中的Java类
        c.setUseHostClassIfNotFound(true);

        return c;
    }
}