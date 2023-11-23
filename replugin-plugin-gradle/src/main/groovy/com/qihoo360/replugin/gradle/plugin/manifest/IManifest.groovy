package com.qihoo360.replugin.gradle.plugin.manifest;

/**
 * @author RePlugin Team
 */
public interface IManifest {

    /**
     * 获取 AndroidManifest 中声明的所有 Activity
     */
    List<String> getActivities()

    /**
     * 应用程序包名
     */
    String getPackageName()
}
