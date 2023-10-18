

package com.qihoo360.replugin.gradle.host.creator;


public interface IFileCreator {

    /**
     * 要生成的文件所在目录
     */
    File getFileDir()

    /**
     * 要生成的文件的名称
     */
    String getFileName()

    /**
     * 要生成的文件内容
     */
    String getFileContent()
}
