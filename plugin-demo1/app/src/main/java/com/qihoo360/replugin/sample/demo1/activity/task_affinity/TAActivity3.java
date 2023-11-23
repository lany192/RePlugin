

package com.qihoo360.replugin.sample.demo1.activity.task_affinity;

import android.content.Intent;
import android.view.View;

import com.qihoo360.replugin.sample.demo1.BaseActivity;

/**
 * @author RePlugin Team
 */
public class TAActivity3 extends BaseActivity {

    @Override
    public void jump(View v) {
        startActivity(new Intent(this, TAActivity2.class));
    }

    @Override
    public String title() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String btnTxt() {
        return TAActivity2.class.getSimpleName();
    }
}
