

package com.qihoo360.mobilesafe.api;

import android.content.Context;
import android.content.SharedPreferences;

import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginInternal;

import java.util.Map;
public final class Pref {

    public static SharedPreferences getSharedPreferences(String name) {
        return RePlugin.getConfig().getCallbacks().getSharedPreferences(RePluginInternal.getAppContext(), name, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getDefaultSharedPreferences() {
        return getSharedPreferences(RePluginInternal.getAppContext().getPackageName() + "_preferences");
    }

    public static SharedPreferences getTempSharedPreferences(String name) {
        String realName = name + ".temp";
        return getSharedPreferences(realName);
    }

    // -----------------------------------------------------------------------
    // 以下来自IPluginHost中的内容，兼容以前的插件框架内容（主要用于临时信息的读写）
    // -----------------------------------------------------------------------

    public static final String PREF_TEMP_FILE_PACM = "plugins_PACM";

    public static String ipcGet(String key, String defValue) {
        SharedPreferences x = getTempSharedPreferences(PREF_TEMP_FILE_PACM);
        String v = x.getString(key, defValue);
        return v;
    }

    public static void ipcSet(String key, String value) {
        SharedPreferences x = Pref.getTempSharedPreferences(PREF_TEMP_FILE_PACM);
        x.edit().putString(key, value).commit();
    }

    public static Map<String, ?> ipcGetAll() {
        SharedPreferences x = Pref.getTempSharedPreferences(PREF_TEMP_FILE_PACM);
        Map<String, ?> a = x.getAll();
        return a;
    }
}
