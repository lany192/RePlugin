package com.qihoo360.replugin.gradle.plugin.util

import com.qihoo360.replugin.gradle.plugin.AppConstant

/**
 * @author RePlugin Team
 */
class CmdUtil {

    /**
     * 同步阻塞执行命令
     * @param cmd 命令
     * @return 命令执行完毕返回码
     */
    public static int syncExecute(String cmd){

        int cmdReturnCode

        try {
            println "${AppConstant.TAG} \$ ${cmd}"

            Process process = cmd.execute()
            process.inputStream.eachLine {
                println "${AppConstant.TAG} - ${it}"
            }
            process.waitFor()

            cmdReturnCode = process.exitValue()

        }catch (Exception e){
            System.err.println "${AppConstant.TAG} the cmd run error !!!"
            System.err.println "${AppConstant.TAG} ${e}"
            return -1
        }

        return cmdReturnCode
    }

    private CmdUtil() {}
}
