

package com.qihoo360.replugin.sample.demo2.databinding;

import android.view.View;
import android.widget.Toast;

/**
 * @author RePlugin Team
 */
public class Entry {
    private String text;
    private int color;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    //将点击监听事件中添加了一个参数
    public void onClick(View view,String str){
        Toast.makeText(view.getContext(),"已点击,产生了" + str,Toast.LENGTH_SHORT).show();
    }

}
