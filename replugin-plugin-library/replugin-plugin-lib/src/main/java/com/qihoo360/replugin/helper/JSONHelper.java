

package com.qihoo360.replugin.helper;

import com.qihoo360.replugin.RePluginInternal;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 和JSON操作有关的帮助类
 *
 * @author RePlugin Team
 */

public class JSONHelper {

    private static final boolean LOG = RePluginInternal.FOR_DEV;

    /**
     * 不抛出异常，直接Put
     *
     * @param jo    JSONObject对象
     * @param key   键
     * @param value 值
     */
    public static <T> void putNoThrows(JSONObject jo, String key, T value) {
        try {
            jo.put(key, value);
        } catch (JSONException e) {
            if (LOG) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 克隆一份JSON对象
     *
     * @param from JSON对象
     * @return 克隆后的JSON对象
     */
    public static JSONObject cloneNoThrows(JSONObject from) {
        try {
            // 不能用new JsonObject(JSONObject, String[])版本，因为不是深拷贝
            return new JSONObject(from.toString());
        } catch (JSONException e) {
            // 不太可能走到这里
            if (LOG) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
