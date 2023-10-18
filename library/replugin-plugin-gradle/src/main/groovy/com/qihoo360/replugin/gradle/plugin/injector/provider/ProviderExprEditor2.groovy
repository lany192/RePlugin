package com.qihoo360.replugin.gradle.plugin.injector.provider

import javassist.CannotCompileException
import javassist.expr.ExprEditor
import javassist.expr.MethodCall


public class ProviderExprEditor2 extends ExprEditor {

    static def PROVIDER_CLASS = 'com.qihoo360.loader2.mgr.PluginProviderClient2'

    public def filePath

    @Override
    void edit(MethodCall m) throws CannotCompileException {
        String clsName = m.getClassName()
        String methodName = m.getMethodName()

        if (clsName.equalsIgnoreCase('android.content.ContentProviderClient')) {
            println " ${filePath} ContentProviderClient.${methodName}():${m.lineNumber}"
            if (!(methodName in ProviderInjector2.includeMethodCall)) {
                // println "跳过$methodName"
                return
            }
            replaceStatement(m, methodName, m.lineNumber)
        }
    }

    def private replaceStatement(MethodCall methodCall, String method, def line) {
        methodCall.replace('{$_ = ' + PROVIDER_CLASS + '.' + method + '(com.qihoo360.replugin.RePlugin.getPluginContext(), $$);}')
        println ">>> Replace: ${filePath} Provider.${method}():${line}"
    }
}
