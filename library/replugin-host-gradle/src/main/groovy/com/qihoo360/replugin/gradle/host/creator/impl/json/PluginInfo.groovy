package com.qihoo360.replugin.gradle.host.creator.impl.json

/**
 * 插件信息模型
 * @author RePlugin Team
 */
class PluginInfo {

    /** 插件文件路径 */
    def path
    /** 插件包名 */
    def pkg
    /** 插件名 */
    def name
    /** 插件最低兼容版本 */
    Long low
    /** 插件最高兼容版本 */
    Long high
    /** 插件版本号 */
    Long ver
    /** 框架版本号 */
    Long frm

}
