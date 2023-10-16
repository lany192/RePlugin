

package com.qihoo360.replugin.sample.demo1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public abstract class BaseActivity extends Activity {

    TextView name;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple);
        name = (TextView) findViewById(R.id.name);
        btn = (Button) findViewById(R.id.btn);
        name.setText(title());
        btn.setText(btnTxt());
    }

    public abstract void jump(View v);

    public abstract String title();

    public abstract String btnTxt();
}
