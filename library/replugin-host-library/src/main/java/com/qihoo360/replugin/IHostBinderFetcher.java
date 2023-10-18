package com.qihoo360.replugin;

import android.os.IBinder;

/**
 * 用来实现主程序提供IBinder给其他插件
 * <p>
 * 插件获取方法：Factory.query("main", "IShare")，返回值：IBinder
 * <p>
 * TODO 未来会废弃Factory类，并做些调整
 *
 * @author RePlugin Team
 */
public interface IHostBinderFetcher {

    /**
     * 主程序需实现此方法，来返回一个IBinder对象，供插件使用
     *
     * @param module 模块名
     * @return 一个IBinder对象
     */
    IBinder query(String module);
}
