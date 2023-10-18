

package com.qihoo360.replugin.packages;

import android.text.TextUtils;

import com.qihoo360.replugin.utils.CloseableUtils;
import com.qihoo360.replugin.utils.basic.SecurityUtil;

import com.qihoo360.replugin.utils.FileUtils;
import com.qihoo360.replugin.utils.IOUtils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 将原来的APK转换成卫士主程序能支持的“可发布插件”格式
 * <p>
 * 即：在APK之前添加一段“文件头”信息，包括插件版本、MD5等
 * <p>
 * 注意：内部框架使用
 *
 * @author RePlugin Team
 */
class PluginPublishFileGenerator {

    /**
     * 开始写入
     *
     * @param srcPath 原APK路径
     * @param outPath 目标Jar包路径
     * @param low     最小协议版本
     * @param high    当前协议版本
     * @param ver     插件版本
     * @return 是否写入成功
     */
    static boolean write(String srcPath, String outPath, int low, int high, int ver) {
        FileOutputStream os = null;
        FileInputStream is = null;
        DataOutputStream dis = null;
        try {
            is = FileUtils.openInputStream(new File(srcPath));
            os = FileUtils.openOutputStream(new File(outPath));
            dis = new DataOutputStream(os);
            // 插件基础字段
            dis.writeInt(low);
            dis.writeInt(high);
            dis.writeInt(ver);
            // md5
            String md5 = SecurityUtil.getFileMD5(srcPath);
            if (TextUtils.isEmpty(md5)) {
                return false;
            }
            dis.writeUTF(md5);
            // 扩展字段(custom)
            dis.writeInt(0);
            // 文件长度
            dis.writeInt((int) new File(srcPath).length());
            // Jar包内容
            IOUtils.copy(is, dis);
            return true;
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            CloseableUtils.closeQuietly(dis);
            CloseableUtils.closeQuietly(os);
            CloseableUtils.closeQuietly(is);
        }
        return false;
    }


}
