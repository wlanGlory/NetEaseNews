package com.wang.neteasenews.model.net;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wang.neteasenews.ui.app.NetEaseNewsApp;

/**
 * Created by dllo on 16/9/16.
 * Volley单例类
 * Volley使用单例类:节省内存,避免多线程访问对象冲突
 * 应用: 线程池 网络 数据 sp 下载
 * 常用的命名:xxInstance xxSingleton
 */
public class VolleyInstance {
    // 定义请求队列
    private RequestQueue requestQueue;
    private static  VolleyInstance instance;

    public VolleyInstance() {
        requestQueue = Volley.newRequestQueue(NetEaseNewsApp.getContext());

    }
    public static VolleyInstance getInstance(){
        // 如果该对象是null
        if(instance == null){
            // 全部线程同步扫描
            synchronized (VolleyInstance.class){
                // 如果该对象还是空
                if(instance == null){
                    instance = new VolleyInstance();
                }
            }
        }
        return instance;
    }
    // 对外提供请求方法
    public void setRequset(String url,final VolleyResult result){
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                result.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.failure();
            }
        });
        requestQueue.add(sr);
    }
}
