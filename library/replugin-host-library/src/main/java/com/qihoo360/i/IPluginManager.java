package com.qihoo360.i;

/**
 * 注意：这里目前仅放置一些常量，大部分方法已移动至 PluginCommImpl 中
 *
 * @author RePlugin Team
 */
public interface IPluginManager {

    /**
     * 插件Activity上下文通过startActivity启动，用系统默认的启动方法
     * 如果设置该值，总是为boolean值true
     */
    String KEY_COMPATIBLE = "compatible";

    /**
     * 通过Intent的extra参数指出目标插件名
     * 插件Activity上下文通过startActivity启动其它插件Activity时用到
     * 如果不指定，则默认用当前Activity的插件
     * 如果设置了KEY_COMPATIBLE，则忽略此参数
     */
    String KEY_PLUGIN = "plugin";

    /**
     * 通过Intent的extra参数指出目标Activity名
     * 如果不指定，则默认用ComponentName参数的类名来启动
     * 如果设置了KEY_COMPATIBLE，则忽略此参数
     */
    String KEY_ACTIVITY = "activity";

    /**
     * 通过Intent的extra参数指出需要在指定进程中启动
     * 只能启动standard的Activity，不能启动singleTask、singleInstance等
     * 不指定时，自动分配插件进程，即PROCESS_AUTO
     */
    String KEY_PROCESS = "process";

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
