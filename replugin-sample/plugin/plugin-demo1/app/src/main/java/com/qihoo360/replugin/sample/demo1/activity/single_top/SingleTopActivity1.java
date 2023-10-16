

package com.qihoo360.replugin.sample.demo1.activity.single_top;

import android.content.Intent;
import android.view.View;

import com.qihoo360.replugin.sample.demo1.BaseActivity;
public class SingleTopActivity1 extends BaseActivity {

    @Override
    public void jump(View v) {
        startActivity(new Intent(this, SingleTopActivity1.class));
    }

    @Override
    public String title() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String btnTxt() {
        return "Start Self";
    }
}
