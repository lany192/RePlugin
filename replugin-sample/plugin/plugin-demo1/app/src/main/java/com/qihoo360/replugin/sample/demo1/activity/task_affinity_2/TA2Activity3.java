

package com.qihoo360.replugin.sample.demo1.activity.task_affinity_2;

import android.content.Intent;
import android.view.View;

import com.qihoo360.replugin.sample.demo1.BaseActivity;
public class TA2Activity3 extends BaseActivity {

    @Override
    public void jump(View v) {
        startActivity(new Intent(this, TA2Activity4.class));
    }

    @Override
    public String title() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String btnTxt() {
        return TA2Activity4.class.getSimpleName();
    }
}
