package com.qihoo360.replugin.component.process;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.qihoo360.loader2.PluginProviderStub;
import com.qihoo360.mobilesafe.core.BuildConfig;
import com.qihoo360.replugin.base.IPC;

import java.io.FileDescriptor;
import java.io.PrintWriter;


public class ProcessPitProviderBase extends ContentProvider {

    private static final String TAG = "ProviderBase";

    public static final String AUTHORITY_PREFIX = IPC.getPackageName() + ".loader.p.main";

    public static final Uri buildUri(int index) {
        String str = "";
        if (index < 0) {
            str += "N";
            index *= -1;
        }
        str += index;
        Uri uri = Uri.parse("content://" + AUTHORITY_PREFIX + str + "/main");
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "buildUri: uri=" + uri);
        }
        return uri;
    }

    /**
     * API Level 18 Override有效
     * @param fd
     * @param writer
     * @param args
     */
    @SuppressLint("Override")
    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        // TODO Jiongxuan Zhang
//        if (RePluginInternal.FOR_DEV) {
//            MobileSafeApplication.getInstance().dump(fd, writer, args);
//            //
//        }
    }

    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return PluginProviderStub.stubPlugin(uri, values);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

}
