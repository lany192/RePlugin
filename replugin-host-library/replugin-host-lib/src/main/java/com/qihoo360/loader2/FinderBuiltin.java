

package com.qihoo360.loader2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.qihoo360.replugin.utils.Charsets;
import com.qihoo360.replugin.utils.CloseableUtils;
import com.qihoo360.loader2.Builder.PxAll;
import com.qihoo360.replugin.helper.LogDebug;
import com.qihoo360.replugin.model.PluginInfo;

import com.qihoo360.replugin.utils.IOUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static com.qihoo360.replugin.helper.LogDebug.LOG;
import static com.qihoo360.replugin.helper.LogDebug.PLUGIN_TAG;
import static com.qihoo360.replugin.helper.LogDebug.TAG_NO_PN;

/**
 * @author RePlugin Team
 */
public class FinderBuiltin {

    static final void loadPlugins(Context context, PxAll all) {
        InputStream in;

        // 读取内部配置
        in = null;
        try {
            in = context.getAssets().open("plugins-builtin.json");
            // TODO 简化参数 all
            readConfig(in, all);
        } catch (FileNotFoundException e0) {
            if (LOG) {
                LogDebug.e(PLUGIN_TAG, "plugins-builtin.json" + " not found");
            }
        } catch (Throwable e) {
            if (LOG) {
                LogDebug.d(PLUGIN_TAG, e.getMessage(), e);
            }
        }
        CloseableUtils.closeQuietly(in);
    }

    private static final void readConfig(InputStream in, PxAll all) throws IOException, JSONException {
        String str = IOUtils.toString(in, Charsets.UTF_8);
        JSONArray ja = new JSONArray(str);
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jo = ja.getJSONObject(i);
            if (jo == null) {
                continue;
            }
            String name = jo.getString("name");
            if (TextUtils.isEmpty(name)) {
                if (LOG) {
                    LogDebug.d(PLUGIN_TAG, "built-in plugins config: invalid item: name is empty, json=" + jo);
                }
                continue;
            }
            PluginInfo info = PluginInfo.buildFromBuiltInJson(jo);
            if (!info.match()) {
                if (LOG) {
                    LogDebug.e(PLUGIN_TAG, "built-in plugins config: mismatch item: " + info);
                }
                continue;
            }
            if (LOG) {
                LogDebug.d(PLUGIN_TAG, "built-in plugins config: item: " + info);
            }
            if (LOG) {
                Log.d(TAG_NO_PN, "add builtin plugin=" + info);
            }
            all.addBuiltin(info);
        }
    }

}