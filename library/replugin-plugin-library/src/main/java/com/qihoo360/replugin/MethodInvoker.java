package com.qihoo360.replugin;

import com.qihoo360.replugin.helper.LogDebug;
import com.qihoo360.replugin.utils.ReflectUtils;

import java.lang.reflect.Method;

/**
 * method-invoker的封装
 *
 * @author RePlugin Team
 */

public class MethodInvoker {

    private static final String TAG = "MethodInvoker";

    private ClassLoader mLoader;

    private String mClassName;

    private String mMethodName;

    private Class<?>[] mParamTypes;

    private Method mMethod;

    private boolean mInitialized;

    private boolean mAvailable;

    public MethodInvoker(ClassLoader loader, String className, String methodName, Class<?>[] paramTypes) {
        mLoader = loader;
        mClassName = className;
        mMethodName = methodName;
        mParamTypes = paramTypes;
        mMethod = null;
        mInitialized = false;
        mAvailable = false;
    }

    public Object call(Object methodReceiver, Object... methodParamValues) {
        if (!mInitialized) {
            try {
                mInitialized = true;
                mMethod = ReflectUtils.getMethod(mLoader, mClassName, mMethodName, mParamTypes);
                mAvailable = true;
            } catch (Exception e) {
                if (LogDebug.LOG) {
                    LogDebug.d(TAG, "get method error !!! (Maybe the version of replugin-host-lib is too low)", e);
                }
            }
        }

        if (mMethod != null) {
            try {
                return ReflectUtils.invokeMethod(mMethod, methodReceiver, methodParamValues);
            } catch (Exception e) {
                if (LogDebug.LOG) {
                    LogDebug.d(TAG, "invoker method error !!! (Maybe the version of replugin-host-lib is too low)", e);
                }
            }
        }

        return null;
    }

    public ClassLoader getClassLoader() {
        return mLoader;
    }

    public boolean isAvailable() {
        return mAvailable;
    }
}
