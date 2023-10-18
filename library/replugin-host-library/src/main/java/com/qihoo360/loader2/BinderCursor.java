package com.qihoo360.loader2;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

import com.qihoo360.replugin.helper.LogDebug;
import com.qihoo360.replugin.model.PluginInfo;

import static com.qihoo360.replugin.helper.LogDebug.LOG;
import static com.qihoo360.replugin.helper.LogDebug.PLUGIN_TAG;


public class BinderCursor extends MatrixCursor {

    static final String BINDER_KEY = "binder";

    Bundle mBinderExtra = new Bundle();

    public static class BinderParcelable implements Parcelable {

        IBinder mBinder;

        public static final Parcelable.Creator<BinderParcelable> CREATOR = new Parcelable.Creator<BinderParcelable>() {
            @Override
            public BinderParcelable createFromParcel(Parcel source) {
                return new BinderParcelable(source);
            }

            @Override
            public BinderParcelable[] newArray(int size) {
                return new BinderParcelable[size];
            }
        };

        BinderParcelable(IBinder binder) {
            mBinder = binder;
        }

        BinderParcelable() {
            //
        }

        BinderParcelable(Parcel source) {
            mBinder = source.readStrongBinder();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeStrongBinder(mBinder);
        }
    }

    public BinderCursor(String[] columnNames, IBinder binder) {
        super(columnNames);

        if (binder != null) {
            Parcelable value = new BinderParcelable(binder);
            mBinderExtra.putParcelable(BINDER_KEY, value);
        }
    }

    @Override
    public Bundle getExtras() {
        return mBinderExtra;
    }

    public static final Cursor queryBinder(IBinder binder) {
        if (LOG) {
            LogDebug.d(PLUGIN_TAG, "query binder = " + binder);
        }
        return new BinderCursor(PluginInfo.QUERY_COLUMNS, binder);
    }

    public static final IBinder getBinder(Cursor cursor) {
        Bundle extras = cursor.getExtras();
        extras.setClassLoader(BinderCursor.class.getClassLoader());
        BinderParcelable w = (BinderParcelable) extras.getParcelable(BINDER_KEY);
        if (LOG) {
            LogDebug.d(PLUGIN_TAG, "get binder = " + w.mBinder);
        }
        return w.mBinder;
    }
}
