

package com.qihoo360.loader2;

import android.content.Context;

import com.qihoo360.loader2.Builder.PxAll;
import com.qihoo360.replugin.helper.LogDebug;
import com.qihoo360.replugin.model.PluginInfo;

import java.io.File;
import java.util.HashSet;

import static com.qihoo360.replugin.helper.LogDebug.LOG;
import static com.qihoo360.replugin.helper.LogDebug.PLUGIN_TAG;

/**
 * @author RePlugin Team
 */
public class Finder {

    /**
     * 扫描插件
     */
    static final void search(Context context, PxAll all) {
        // 扫描内置插件-builtin
        FinderBuiltin.loadPlugins(context, all);
    }

    private static final void searchLocalPlugins(File dir, PxAll all, HashSet<File> others) {
        File files[] = dir.listFiles();
        if (files == null) {
            if (LOG) {
                LogDebug.d(PLUGIN_TAG, "search local plugin: nothing");
            }
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                continue;
            }
            if (f.length() <= 0) {
                if (LOG) {
                    LogDebug.d(PLUGIN_TAG, "search local plugin: zero length, file=" + f.getAbsolutePath());
                }
                if (others != null) {
                    others.add(f);
                }
                continue;
            }
            PluginInfo info = PluginInfo.build(f);
            if (info == null) {
                if (others != null) {
                    others.add(f);
                }
                continue;
            }
            if (!info.match()) {
                if (LOG) {
                    LogDebug.d(PLUGIN_TAG, "search local plugin: mismatch, file=" + f.getAbsolutePath());
                }
                if (others != null) {
                    others.add(f);
                }
                continue;
            }
            all.addNormal(info);
        }
    }

}
