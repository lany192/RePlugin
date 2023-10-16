

package com.qihoo360.replugin.gradle.plugin.injector.provider

import com.qihoo360.replugin.gradle.plugin.inner.Util
import com.qihoo360.replugin.gradle.plugin.injector.BaseInjector
import javassist.ClassPool

import java.nio.file.*
import java.nio.file.attribute.BasicFileAttributes
public class ProviderInjector extends BaseInjector {

    // 处理以下方法
    public static def includeMethodCall = ['query',
                                           'getType',
                                           'insert',
                                           'bulkInsert',
                                           'delete',
                                           'update',
            /// 以下方法 replugin plugin lib 暂未支持，导致字节码修改失败。
                                           'openInputStream',
                                           'openOutputStream',
                                           'openFileDescriptor',
                                           'registerContentObserver',
                                           'acquireContentProviderClient',
                                           'notifyChange',
                                           'toCalledUri',
    ]

    // 表达式编辑器
    def editor

    @Override
    def injectClass(ClassPool pool, String dir, Map config) {

        // 不处理非 build 目录下的类
/*
        if (!dir.contains('build' + File.separator + 'intermediates')) {
            println "跳过$dir"
            return
        }
*/

        if (editor == null) {
            editor = new ProviderExprEditor()
        }

        Util.newSection()
        println dir

        Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>() {
            @Override
            FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                String filePath = file.toString()
                def stream, ctCls

                try {
                    if (filePath.contains('PluginProviderClient.class')) {
                        throw new Exception('can not replace self ')
                    }

                    stream = new FileInputStream(filePath)
                    ctCls = pool.makeClass(stream);

                    // println ctCls.name
                    if (ctCls.isFrozen()) {
                        ctCls.defrost()
                    }

                    editor.filePath = filePath

                    (ctCls.getDeclaredMethods() + ctCls.getMethods()).each {
                        it.instrument(editor)
                    }

                    ctCls.writeFile(dir)
                } catch (Throwable t) {
                    println "    [Warning] --> ${t.toString()}"
                    // t.printStackTrace()
                } finally {
                    if (ctCls != null) {
                        ctCls.detach()
                    }
                    if (stream != null) {
                        stream.close()
                    }
                }

                return super.visitFile(file, attrs)
            }
        })
    }
}
