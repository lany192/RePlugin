

package com.qihoo360.loader2;

import android.os.Build;

/**
 * @author RePlugin Team
 */
public class BuildCompat {

    public static final String ARM = "arm";

    public static final String ARM64 = "arm64";

    public static final String[] SUPPORTED_ABIS;

    public static final String[] SUPPORTED_32_BIT_ABIS;

    public static final String[] SUPPORTED_64_BIT_ABIS;

    static {
        //init SUPPORTED_ABIS
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (Build.SUPPORTED_ABIS != null) {
                SUPPORTED_ABIS = new String[Build.SUPPORTED_ABIS.length];
                System.arraycopy(Build.SUPPORTED_ABIS, 0, SUPPORTED_ABIS, 0, SUPPORTED_ABIS.length);
            } else {
                SUPPORTED_ABIS = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            }
        } else {
            SUPPORTED_ABIS = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }

        //init SUPPORTED_32_BIT_ABIS
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (Build.SUPPORTED_32_BIT_ABIS != null) {
                SUPPORTED_32_BIT_ABIS = new String[Build.SUPPORTED_32_BIT_ABIS.length];
                System.arraycopy(Build.SUPPORTED_32_BIT_ABIS, 0, SUPPORTED_32_BIT_ABIS, 0, SUPPORTED_32_BIT_ABIS.length);
            } else {
                SUPPORTED_32_BIT_ABIS = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            }
        } else {
            SUPPORTED_32_BIT_ABIS = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }

        //init SUPPORTED_64_BIT_ABIS
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (Build.SUPPORTED_64_BIT_ABIS != null) {
                SUPPORTED_64_BIT_ABIS = new String[Build.SUPPORTED_64_BIT_ABIS.length];
                System.arraycopy(Build.SUPPORTED_64_BIT_ABIS, 0, SUPPORTED_64_BIT_ABIS, 0, SUPPORTED_64_BIT_ABIS.length);
            } else {
                SUPPORTED_64_BIT_ABIS = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            }
        } else {
            SUPPORTED_64_BIT_ABIS = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
    }
}
