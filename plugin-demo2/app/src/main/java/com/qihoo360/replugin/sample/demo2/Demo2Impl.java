
package com.qihoo360.replugin.sample.demo2;

import android.os.RemoteException;
import android.widget.Toast;

import com.qihoo360.replugin.RePlugin;

/**
 * @author RePlugin Team
 */
public class Demo2Impl extends IDemo2.Stub {
    @Override
    public void hello(String str) throws RemoteException {
        Toast.makeText(RePlugin.getPluginContext(), str, Toast.LENGTH_SHORT).show();
    }
}
