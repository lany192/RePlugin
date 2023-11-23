package com.qihoo360.replugin.gradle.plugin.injector

import com.qihoo360.replugin.gradle.plugin.injector.identifier.GetIdentifierInjector
import com.qihoo360.replugin.gradle.plugin.injector.localbroadcast.LocalBroadcastInjector
import com.qihoo360.replugin.gradle.plugin.injector.provider.ProviderInjector
import com.qihoo360.replugin.gradle.plugin.injector.provider.ProviderInjector2
import com.qihoo360.replugin.gradle.plugin.injector.loaderactivity.LoaderActivityInjector

/**
 * @author RePlugin Team
 */
public enum Injectors {

    LOADER_ACTIVITY_CHECK_INJECTOR('LoaderActivityInjector', new LoaderActivityInjector(), '替换 Activity 为 LoaderActivity'),
    LOCAL_BROADCAST_INJECTOR('LocalBroadcastInjector', new LocalBroadcastInjector(), '替换 LocalBroadcast 调用'),
    PROVIDER_INJECTOR('ProviderInjector', new ProviderInjector(), '替换 Provider 调用'),
    PROVIDER_INJECTOR2('ProviderInjector2', new ProviderInjector2(), '替换 ContentProviderClient 调用'),
    GET_IDENTIFIER_INJECTOR('GetIdentifierInjector', new GetIdentifierInjector(), '替换 Resource.getIdentifier 调用')

    IClassInjector injector
    String nickName
    String desc

    Injectors(String nickName, IClassInjector injector, String desc) {
        this.injector = injector
        this.nickName = nickName
        this.desc = desc;
    }
}

