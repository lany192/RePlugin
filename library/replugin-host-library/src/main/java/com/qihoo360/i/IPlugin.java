package com.qihoo360.i;


/**
 * 此接口由插件负责导出
 * 表示一个具体的物理上的插件实体，例如barcode.jar
 * 具体导出细节可看Factory
 *
 * @author RePlugin Team
 *
 */
public interface IPlugin {

    /**
     * @param c 需要查询的interface的类
     * @return
     */
    IModule query(Class<? extends IModule> c);

}
