

package com.qihoo360.replugin.component.process;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.qihoo360.loader2.PluginProviderStub;
import com.qihoo360.replugin.base.IPC;


public class ProcessPitProviderPersist extends ContentProvider {

    private static final String TAG = "ProcessPitProviderPersist";

    private static final String AUTHORITY_PREFIX = IPC.getPackageName() + ".loader.p.main";

    public static final Uri URI = Uri.parse("content://" + AUTHORITY_PREFIX + "/main");

    public static boolean sInvoked;

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
        sInvoked = true;
        return PluginProviderStub.stubMain(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }
}
