package com.and2long.customview;

import android.content.Context;

/**
 * Created by and2long on 2017/1/18.
 */

public class DpUtils {

    /**
     * @param context 上下文
     * @param dpValue value
     * @return value
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    /**
     * @param context 上下文
     * @param pxValue value
     * @return value
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
