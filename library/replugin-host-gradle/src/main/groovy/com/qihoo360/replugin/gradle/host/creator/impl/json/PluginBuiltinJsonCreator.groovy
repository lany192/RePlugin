

package com.qihoo360.replugin.gradle.host.creator.impl.json

import com.qihoo360.replugin.gradle.host.AppConstant
import com.qihoo360.replugin.gradle.compat.VariantCompat
import com.qihoo360.replugin.gradle.host.creator.IFileCreator
import groovy.io.FileType
import groovy.json.JsonOutput


public class PluginBuiltinJsonCreator implements IFileCreator {

    def variant
    def config
    File fileDir
    def fileName
    def pluginInfos = []

    def PluginBuiltinJsonCreator(def project, def variant, def cfg) {
        this.config = cfg
        this.variant = variant
        // make sure processResources Task execute after mergeAssets Task, get real gradle task
        // 在 com.android.tools.build:gradle:3.3.2 及之前 outputDir 为 File 类型。
        // 但从 com.android.tools.build:gradle:3.4.1 开始 Google 将此类型改为 `Provider<Directory>`。
        final def out = VariantCompat.getMergeAssetsTask(variant)?.outputDir
        fileDir = File.class.isInstance(out) ? out : out?.get()?.getAsFile()
        fileName = config.builtInJsonFileName
    }

    @Override
    String getFileName() {
        fileName
    }

    @Override
    File getFileDir() {
        fileDir
    }

    @Override
    String getFileContent() {
        //查找插件文件并抽取信息,如果没有就直接返回null
        File pluginDirFile = new File(fileDir?.getAbsolutePath() + File.separator + config.pluginDir)
        if (!pluginDirFile.exists()) {
            println "${AppConstant.TAG} The ${pluginDirFile.absolutePath} does not exist "
            println "${AppConstant.TAG} pluginsInfo=null"
            return null
        }

        new File(fileDir.getAbsolutePath() + File.separator + config.pluginDir)
                .traverse(type: FileType.FILES, nameFilter: ~/.*\${config.pluginFilePostfix}/) {

            PluginInfoParser parser = null
            try {
                parser = new PluginInfoParser(it.absoluteFile, config)
            } catch (Exception e) {
                if (config.enablePluginFileIllegalStopBuild) {
                    System.err.println "${AppConstant.TAG} the plugin(${it.absoluteFile.absolutePath}) is illegal !!!"
                    throw new Exception(e)
                }
            }

            if (null != parser) {
                pluginInfos << parser.pluginInfo
            }
        }

        //插件为0个
        if (pluginInfos.isEmpty()) {
            println "${AppConstant.TAG} pluginsSize=0"
            println "${AppConstant.TAG} pluginsInfo=null"
            return null
        }

        //构建插件们的json信息
        def jsonOutput = new JsonOutput()
        String pluginInfosJson = jsonOutput.toJson(pluginInfos)
        //格式化打印插件们的json信息
        println "${AppConstant.TAG} pluginsSize=${pluginInfos.size()}"
        println "${AppConstant.TAG} pluginsInfo=${jsonOutput.prettyPrint(pluginInfosJson)}"

        return pluginInfosJson
    }

}
