

package com.qihoo360.replugin.sample.demo2.databinding;

import android.app.Activity;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.qihoo360.replugin.sample.demo2.R;
public class DataBindingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabindingTestBinding binding = DataBindingUtil.setContentView(this, R.layout.databinding_test);
        Entry entry = new Entry();
        entry.setText("文本数据1");
        entry.setColor(0xff0000ff);
        //设置测试字符串
        binding.setStr("我是监听绑定的数据测试");
        binding.setEntry(entry);
    }
}
