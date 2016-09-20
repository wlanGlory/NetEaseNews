package com.wang.neteasenews.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.wang.neteasenews.ui.app.NetEaseNewsApp;

/**
 * Created by dllo on 16/9/13.
 * 屏幕大小工具类
 */
public class ScreenSizeUtil {
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }

    public static int getScreenSize(Context context, int state) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        switch (state) {
            case 1:
                return metrics.widthPixels;
            case 2:
                return metrics.heightPixels;
            default:
                return metrics.heightPixels;
        }
    }
}
