
package com.qihoo360.mobilesafe.svcmanager;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.qihoo360.mobilesafe.core.BuildConfig;
import com.qihoo360.replugin.base.IPC;

/**
 * Provider used for getting the ServiceChannel from other process only
 *
 * @author RePlugin Team
 */
public class ServiceProvider extends ContentProvider {
    private static final boolean DEBUG = BuildConfig.DEBUG;

    private static final String TAG = "ServerProvider";

    public static final String AUTHORITY = IPC.getPackageName() + ".svcmanager";

    public static final String PATH_SERVER_CHANNEL = "severchannel";

    @Override
    public boolean onCreate() {
        if (DEBUG) {
            Log.d(TAG, "[onCreate]" + " App = " + getContext().getApplicationContext());
        }

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG) {
            Log.d(TAG, "[query] uri = " + (uri == null ? "null" : uri.toString()));
        }

        return ServiceChannelImpl.sServiceChannelCursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
