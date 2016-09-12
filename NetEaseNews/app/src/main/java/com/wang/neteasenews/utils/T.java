package com.wang.neteasenews.utils;

import android.widget.Toast;

import com.wang.neteasenews.ui.app.NetEaseNewsApp;

/**
 * Created by dllo on 16/9/8.
 * Toast的工具类
 */
public final class T {
    // final 修饰不可继承
    // 私有构造方法:不能创建对象

    public T() {
    }
    private static boolean isDebug = true;
    public static void shortMsg(String msg){
        if(isDebug){
           Toast.makeText(NetEaseNewsApp.getContext(),msg,Toast.LENGTH_SHORT).show();
        }
    }
    public static void longMsg(String msg){
        if(isDebug){
            Toast.makeText(NetEaseNewsApp.getContext(),msg,Toast.LENGTH_LONG).show();
        }
    }

}
