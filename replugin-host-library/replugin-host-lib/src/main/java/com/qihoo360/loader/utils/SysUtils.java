

package com.qihoo360.loader.utils;

import com.qihoo360.replugin.helper.LogRelease;
import com.qihoo360.replugin.utils.CloseableUtils;

import java.io.FileInputStream;

import static com.qihoo360.replugin.helper.LogRelease.LOGR;
public final class SysUtils {

    private static final String TAG = "Plugin.SysUtils";

    /**
     * 返回当前的进程名
     *
     * @return
     */
    public static String getCurrentProcessName() {
        FileInputStream in = null;
        try {
            String fn = "/proc/self/cmdline";
            in = new FileInputStream(fn);
            byte[] buffer = new byte[256];
            int len = 0;
            int b;
            while ((b = in.read()) > 0 && len < buffer.length) {
                buffer[len++] = (byte) b;
            }
            if (len > 0) {
                String s = new String(buffer, 0, len, "UTF-8");
                return s;
            }
        } catch (Throwable e) {
            if (LOGR) {
                LogRelease.e(TAG, e.getMessage(), e);
            }
        } finally {
            CloseableUtils.closeQuietly(in);
        }
        return null;
    }
}
