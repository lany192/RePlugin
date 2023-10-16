

package com.qihoo360.replugin.gradle.plugin.injector

import org.gradle.api.Project
public abstract class BaseInjector implements IClassInjector {

    protected Project project

    protected String variantDir

    @Override
    public Object name() {
        return getClass().getSimpleName()
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setVariantDir(String variantDir) {
        this.variantDir = variantDir;
    }
}
