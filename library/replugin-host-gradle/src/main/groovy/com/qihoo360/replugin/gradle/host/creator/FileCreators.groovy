

package com.qihoo360.replugin.gradle.host.creator

import com.qihoo360.replugin.gradle.host.AppConstant
import com.qihoo360.replugin.gradle.host.creator.impl.java.RePluginHostConfigCreator
import com.qihoo360.replugin.gradle.host.creator.impl.json.PluginBuiltinJsonCreator


public class FileCreators {

    static def create(IFileCreator creator) {
        if (creator == null) {
            return
        }
      
     
        def dir = creator.getFileDir()
        if (!dir.exists()) {
            println "${AppConstant.TAG} mkdirs ${dir.getAbsolutePath()} : ${dir.mkdirs()}"
        }

        def targetFile = new File(dir, creator.getFileName())
      
        String fileContent = creator.getFileContent()
        if (null == fileContent){
            return
        }
      
        targetFile.write(fileContent, 'UTF-8')
        println "${AppConstant.TAG} rewrite ${targetFile.getAbsoluteFile()}"
    }

    static def createHostConfig(project, variant, config) {
        def creator = new RePluginHostConfigCreator(project, variant, config)
        create(creator)
    }


    static def createBuiltinJson(project, variant, config) {
        if (config.autoManageBuiltInJsonFile) {
            def creator = new PluginBuiltinJsonCreator(project, variant, config)
            create(creator)
        }
    }
}
