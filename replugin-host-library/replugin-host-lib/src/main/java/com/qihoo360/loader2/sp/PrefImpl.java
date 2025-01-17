

package com.qihoo360.loader2.sp;

import android.os.Bundle;
import android.os.RemoteException;

import com.qihoo360.replugin.helper.LogDebug;

import java.util.HashMap;

import static com.qihoo360.replugin.helper.LogDebug.LOG;
import static com.qihoo360.replugin.helper.LogDebug.PLUGIN_TAG;

/**
 * @author RePlugin Team
 */
public final class PrefImpl extends IPref.Stub {

    HashMap<String, Bundle> mBundles = new HashMap<String, Bundle>();

    private Bundle load(String category) {
        synchronized (mBundles) {
            Bundle bundle = mBundles.get(category);
            if (bundle == null) {
                bundle = new Bundle();
                mBundles.put(category, bundle);
            }
            return bundle;
        }
    }

    @Override
    public String get(String category, String key, String defValue) throws RemoteException {
        Bundle bundle = load(category);
        if (LOG) {
            LogDebug.d(PLUGIN_TAG, "get: category=" + category + " bundle=" + bundle + " key=" + key);
        }
        if (bundle.containsKey(key)) {
            return bundle.getString(key);
        }
        return defValue;
    }

    @Override
    public void set(String category, String key, String value) throws RemoteException {
        Bundle bundle = load(category);
        if (LOG) {
            LogDebug.d(PLUGIN_TAG, "set: category=" + category + " bundle=" + bundle + " key=" + key + " value=" + value);
        }
        bundle.putString(key, value);
    }

    @Override
    public Bundle getAll(String category) throws RemoteException {
        Bundle bundle = load(category);
        if (LOG) {
            LogDebug.d(PLUGIN_TAG, "getAll: category=" + category + " bundle=" + bundle);
        }
        return bundle;
    }

}
