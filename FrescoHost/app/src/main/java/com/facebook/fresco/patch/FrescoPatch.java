

package com.facebook.fresco.patch;

import android.content.Context;

import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 为 “自己编译好的fresco drawee 模块(对应drawee-modified-1.7.1.jar)” 设置回调接口
 *
 * @author RePlugin Team
 */
public class FrescoPatch {

    /**
     * 初始化
     * <p>
     * 为SimpleDraweeView设置回调
     * 为GenericDraweeHierarchyInflater设置回调
     */
    public static void initialize(Context context) {
        DraweeStyleableCallbackImpl draweeStyleableCallback = new DraweeStyleableCallbackImpl(context);
        SimpleDraweeView.setDraweeStyleableCallback(draweeStyleableCallback);
        GenericDraweeHierarchyInflater.setDraweeStyleableCallback(draweeStyleableCallback);
    }
}