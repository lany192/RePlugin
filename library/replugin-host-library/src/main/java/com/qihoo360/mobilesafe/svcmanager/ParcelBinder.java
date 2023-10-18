
package com.qihoo360.mobilesafe.svcmanager;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;


class ParcelBinder implements Parcelable {

    private final IBinder mBinder;

    private ParcelBinder(Parcel source) {
        mBinder = source.readStrongBinder();
    }

    public ParcelBinder(IBinder binder) {
        this.mBinder = binder;
    }

    public IBinder getIbinder() {
        return mBinder;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(mBinder);
    }

    public static final Parcelable.Creator<ParcelBinder> CREATOR = new Parcelable.Creator<ParcelBinder>() {

        @Override
        public ParcelBinder createFromParcel(Parcel source) {
            return new ParcelBinder(source);
        }

        @Override
        public ParcelBinder[] newArray(int size) {
            return new ParcelBinder[size];
        }

    };

}
