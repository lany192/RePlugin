package com.qihoo360.replugin.gradle.plugin.injector.provider

import javassist.CannotCompileException
import javassist.expr.ExprEditor
import javassist.expr.MethodCall

/**
 * @author RePlugin Team
 */
public class ProviderExprEditor extends ExprEditor {

    static def PROVIDER_CLASS = 'com.qihoo360.replugin.loader.p.PluginProviderClient'

    public def filePath

    @Override
    void edit(MethodCall m) throws CannotCompileException {
        final String clsName = m.getClassName()
        final String methodName = m.getMethodName()
        if (!clsName.equalsIgnoreCase('android.content.ContentResolver')) {
            return
        }
        if (!(methodName in ProviderInjector.includeMethodCall)) { // println "跳过$methodName"
            return
        }
        try {
            replaceStatement(m, methodName, m.lineNumber)
        } catch (Exception e) { //确保不影响其他 MethodCall
            println "    [Warning] --> ProviderExprEditor : ${e.toString()}"
        }
    }

    def private replaceStatement(MethodCall methodCall, String method, def line) {
        if (methodCall.getMethodName() == 'registerContentObserver' || methodCall.getMethodName() == 'notifyChange') {
            methodCall.replace('{' + PROVIDER_CLASS + '.' + method + '(com.qihoo360.replugin.RePlugin.getPluginContext(), $$);}')
        } else {
            methodCall.replace('{$_ = ' + PROVIDER_CLASS + '.' + method + '(com.qihoo360.replugin.RePlugin.getPluginContext(), $$);}')
        }
        println ">>> Replace: ${filePath} Provider.${method}():${line}"
    }
}
