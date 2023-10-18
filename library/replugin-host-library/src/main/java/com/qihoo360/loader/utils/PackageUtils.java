package com.qihoo360.loader.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.qihoo360.replugin.helper.LogDebug;


public class PackageUtils {

    /**
     * 获取PackageInfo对象
     * <p>
     * 注：getPackageArchiveInfo Android 2.x上，可能拿不到signatures，本可以通过反射去获取，但是考虑到会触发Android 的灰/黑名单，这个方法就不再继续适配2.X了
     *
     * @return
     */
    public static PackageInfo getPackageArchiveInfo(PackageManager pm, String pkgFilePath, int flags) {
        PackageInfo info = null;
        try {
            info = pm.getPackageArchiveInfo(pkgFilePath, flags);
        } catch (Throwable e) {
            if (LogDebug.LOG) {
                e.printStackTrace();
            }
        }

        return info;
    }
}