

package com.qihoo360.replugin.component.service.server;

import com.qihoo360.replugin.utils.basic.ArraySet;

/**
 * 用来表示每个进程（Client端）与Service的绑定关系
 *
 * NOTE 类似于Android的AppBindRecord
 *
 * @author RePlugin Team
 */
class ProcessBindRecord {

    // 被绑定的Service信息
    final ServiceRecord service;

    // 绑定此Service所用的Intent信息
    final IntentBindRecord intent;

    // 哪个进程（Client）建立了绑定关系
    final ProcessRecord client;

    // 在此Service、此进程、此Intent下面的所有连接
    final ArraySet<ConnectionBindRecord> connections = new ArraySet<>();

    ProcessBindRecord(ServiceRecord service, IntentBindRecord intent,
                      ProcessRecord client) {
        this.service = service;
        this.intent = intent;
        this.client = client;
    }

    public String toString() {
        return "ProcessBindRecord{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + service.shortName + ":" + client.pid + "}";
    }
}
