package com.qihoo360.replugin.gradle.plugin.injector.identifier

import com.qihoo360.replugin.gradle.plugin.inner.CommonData
import javassist.CannotCompileException
import javassist.expr.ExprEditor
import javassist.expr.MethodCall

/**
 * @author RePlugin Team
 */
public class GetIdentifierExprEditor extends ExprEditor {

    public def filePath

    @Override
    void edit(MethodCall m) throws CannotCompileException {
        String clsName = m.getClassName()
        String methodName = m.getMethodName()

        if (clsName.equalsIgnoreCase('android.content.res.Resources')) {
            if (methodName == 'getIdentifier') {
                m.replace('{ $3 = \"' + CommonData.appPackage + '\"; ' +
                        '$_ = $proceed($$);' +
                        ' }')
                println " GetIdentifierCall => ${filePath} ${methodName}():${m.lineNumber}"
            }
        }
    }
}
