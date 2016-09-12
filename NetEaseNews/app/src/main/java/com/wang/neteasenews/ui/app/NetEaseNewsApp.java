package com.wang.neteasenews.ui.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/9/8.
 * 当前应用 每个应用只有一个
 * Context 环境
 * 此App需要注册
 */
public class NetEaseNewsApp extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }

    public static Context getContext() {
        return context;
    }
}
