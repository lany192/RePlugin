

package com.qihoo360.replugin.base;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * 和ActivityManagerService快速封装的一些接口
 *
 * @author RePlugin Team
 */

public class AMSUtils {

    /**
     * 无需抛出异常而调用getRunningAppProcesses方法
     * @param context context对象
     * @return RunningAppProcessInfo列表
     */
    public static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcessesNoThrows(Context context) {
        try {
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            return am.getRunningAppProcesses();
        } catch (Throwable e) {
            // 可能AMS挂了，但最多返回空列表即可。毕竟不是很重要的流程
            e.printStackTrace();
        }
        return null;
    }
}
