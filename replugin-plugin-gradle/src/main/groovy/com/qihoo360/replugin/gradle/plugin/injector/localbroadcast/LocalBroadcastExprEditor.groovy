package com.qihoo360.replugin.gradle.plugin.injector.localbroadcast

import javassist.CannotCompileException
import javassist.expr.ExprEditor
import javassist.expr.MethodCall

/**
 * @author RePlugin Team
 */
public class LocalBroadcastExprEditor extends ExprEditor {

    static def TARGET_CLASS = ""
    static def includeClass = ['android.support.v4.content.LocalBroadcastManager',
                               'androidx.localbroadcastmanager.content.LocalBroadcastManager']

    static def PROXY_CLASS = 'com.qihoo360.replugin.loader.b.PluginLocalBroadcastManager'

    /** 处理以下方法 */
    static def includeMethodCall = ['getInstance',
                                    'registerReceiver',
                                    'unregisterReceiver',
                                    'sendBroadcast',
                                    'sendBroadcastSync']

    /** 待处理文件的物理路径 */
    public def filePath

    @Override
    void edit(MethodCall call) throws CannotCompileException {
        if (call.getClassName() in includeClass ) {
            TARGET_CLASS = call.getClassName()
            if (!(call.getMethodName() in includeMethodCall)) {
                // println "Skip $methodName"
                return
            }

            replaceStatement(call)
        }
    }

    def private replaceStatement(MethodCall call) {
        String method = call.getMethodName()
        if (method == 'getInstance') {
            call.replace('{$_ = ' + PROXY_CLASS + '.' + method + '($$);}')
        } else {

            def returnType = call.method.returnType.getName()
            // getInstance 之外的调用，要增加一个参数，请参看 i-library 的 LocalBroadcastClient.java
            if (returnType == 'void') {
                call.replace('{' + PROXY_CLASS + '.' + method + '($0, $$);}')
            } else {
                call.replace('{$_ = ' + PROXY_CLASS + '.' + method + '($0, $$);}')
            }
        }

        println ">>> Replace: ${filePath} <line:${call.lineNumber}> ${TARGET_CLASS}.${method}() <With> ${PROXY_CLASS}.${method}()\n"
    }
}
