package com.qihoo360.i;

/**
 * 所有可查询的接口都从此interface继承
 * 在插件体系中，module是一种略高于interface的概念
 * 一个插件可导出一个到多个module，这些module可输出自己业务的各种interface
 *
 * @author RePlugin Team
 *
 */
public interface IModule {

    /**
     * 万能接口：当不能升级adapter.jar的时候再考虑使用
     * @param args
     * @return
     */
    Object invoke(Object...args);
}
