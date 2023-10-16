

package com.qihoo360.replugin.sample.demo1.activity.single_instance;

import android.view.View;

import com.qihoo360.replugin.sample.demo1.BaseActivity;
public class TIActivity1 extends BaseActivity {

    @Override
    public void jump(View v) {
        finish();
    }

    @Override
    public String title() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String btnTxt() {
        return "back";
    }
}
