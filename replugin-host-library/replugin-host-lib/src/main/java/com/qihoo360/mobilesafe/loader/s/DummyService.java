

package com.qihoo360.mobilesafe.loader.s;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author RePlugin Team
 */
public class DummyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
