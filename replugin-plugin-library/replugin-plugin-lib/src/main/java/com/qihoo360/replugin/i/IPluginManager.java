

package com.qihoo360.replugin.i;


/**
 * 负责插件和插件之间的interface互通，可通过插件Entry得到，也可通过wrapper类Factory直接调用
 *
 * @author RePlugin Team
 */
public interface IPluginManager {

    /**
     * 自动分配插件进程
     */
    int PROCESS_AUTO = Integer.MIN_VALUE;

    /**
     * UI进程
     */
    int PROCESS_UI = -1;

    /**
     * 常驻进程
     */
    int PROCESS_PERSIST = -2;
}
