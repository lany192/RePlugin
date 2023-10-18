package com.qihoo360.replugin.helper;

import android.os.Build;

import com.qihoo360.replugin.RePluginInternal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.List;

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

    /**
     * 根据Android API的版本，来决定是使用Remove方法（API 19），还是通过反射来做（低于API 19）
     */
    public static void remove(JSONArray jsonArray, int index) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            jsonArray.remove(index);
        } else {
            removeBelowAPI19(jsonArray, index);
        }
    }

    private static void removeBelowAPI19(JSONArray jsonArray, int index) {
        if (index < 0) {
            return;
        }
        try {
            Field valuesField = JSONArray.class.getDeclaredField("values");
            valuesField.setAccessible(true);
            @SuppressWarnings("unchecked")
            List<Object> values = (List<Object>) valuesField.get(jsonArray);
            if (index >= values.size()) {
                return;
            }
            values.remove(index);
        } catch (Exception e) {
            if (LogRelease.LOGR) {
                e.printStackTrace();
            }
        }
    }
}
