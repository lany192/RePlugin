


package com.qihoo360.mobilesafe.svcmanager;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.os.IBinder;

/**
 * A Matrix Cursor implementation that a binder object is embedded in its extra
 * data.
 *
 * @author RePlugin Team
 */
/* PACKAGE */class ServiceChannelCursor extends MatrixCursor {

    public static final String SERVER_CHANNEL_BUNDLE_KEY = "servicechannel";

    /* PACKAGE */static final String[] DEFAULT_COLUMNS = {
        "s"
    };

    static final ServiceChannelCursor makeCursor(IBinder binder) {
        return new ServiceChannelCursor(DEFAULT_COLUMNS, binder);
    }

    static final IBinder getBinder(Cursor cursor) {
        Bundle bundle = cursor.getExtras();
        bundle.setClassLoader(ParcelBinder.class.getClassLoader());
        ParcelBinder parcelBinder = bundle.getParcelable(SERVER_CHANNEL_BUNDLE_KEY);
        return parcelBinder.getIbinder();
    }

    Bundle mBinderExtra = new Bundle();

    public ServiceChannelCursor(String[] columnNames, IBinder binder) {
        super(columnNames);

        mBinderExtra.putParcelable(SERVER_CHANNEL_BUNDLE_KEY, new ParcelBinder(binder));
    }

    @Override
    public Bundle getExtras() {
        return mBinderExtra;
    }
}
