

/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\work\\p\\mobilesafe_v6_frame\\main\\src\\android\\app\\IActivityWatcher.aidl
 */

package com.qihoo360.loader2.alc;

/**
 * Callback interface to watch the user's traversal through activities.
 * {@hide}
 */
public interface IActivityWatcher extends android.os.IInterface {

    /** Local-side IPC implementation stub class. */
    public abstract static class Stub extends android.os.Binder implements IActivityWatcher {
        private static final java.lang.String DESCRIPTOR = "android.app.IActivityWatcher";

        /** Construct the stub at attach it to the interface. */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_ACTIVITY_RESUMING: {
                    data.enforceInterface(DESCRIPTOR);
                    int arg0;
                    arg0 = data.readInt();
                    this.activityResuming(arg0);
                    return true;
                }
                case TRANSACTION_CLOSING_SYSTEM_DIALOGS: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String arg0;
                    arg0 = data.readString();
                    this.closingSystemDialogs(arg0);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        static final int TRANSACTION_ACTIVITY_RESUMING = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);

        static final int TRANSACTION_CLOSING_SYSTEM_DIALOGS = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    }

    public void activityResuming(int activityId) throws android.os.RemoteException;

    public void closingSystemDialogs(java.lang.String reason) throws android.os.RemoteException;
}
