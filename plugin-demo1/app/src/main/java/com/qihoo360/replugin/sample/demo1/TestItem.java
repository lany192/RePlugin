

package com.qihoo360.replugin.sample.demo1;

import android.view.View;

/**
 * @author RePlugin Team
 */
public class TestItem {

    public String title;

    public View.OnClickListener mClickListener;

    public TestItem(String title, View.OnClickListener listener) {
        this.title = title;
        this.mClickListener = listener;
    }
}
