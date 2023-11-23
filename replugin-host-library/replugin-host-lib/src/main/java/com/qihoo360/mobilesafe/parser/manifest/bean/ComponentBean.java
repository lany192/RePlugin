

package com.qihoo360.mobilesafe.parser.manifest.bean;

import android.content.IntentFilter;

import java.util.List;

/**
 * @author RePlugin Team
 */
public class ComponentBean {

    public String name;
    public List<IntentFilter> intentFilters;

    @Override
    public String toString() {
        return String.format("{name:%s, intent-filter.size():%s}", name, intentFilters.size());
    }
}
