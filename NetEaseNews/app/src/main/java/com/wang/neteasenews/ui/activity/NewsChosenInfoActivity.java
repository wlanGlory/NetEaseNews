package com.wang.neteasenews.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wang.neteasenews.R;

import com.wang.neteasenews.model.net.VolleyInstance;
import com.wang.neteasenews.model.net.VolleyResult;
import com.wang.neteasenews.utils.ScreenSizeUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 新闻界面精选详情页
 *
 * hello
 */
public class NewsChosenInfoActivity extends AbsBaseActivity {
    //    private String CHOSEN_INFOURL = "http://c.3g.163.com/nc/article/C1HD4ND1000146BE/full.html";
    private String CHOSEN_INFOURL_LEFT = "http://c.3g.163.com/nc/article/";
    private String CHOSEN_INFOURL_RIGHT = "/full.html";

    private Intent intent;
    private String CHOSEN_INFOURL;
    private WebView webView;
    private TextView tv;
    private ImageView imageView;
    private String chosen_infourl_middle;
    private String body;
    private String image;
    private String title;
    // 定义和new对象

    @Override
    protected int setLayout() {
        return R.layout.activity_newschosen_info;
    }

    @Override
    protected void initViews() {
        webView = byView(R.id.newschosen_info_webview);
        tv = (TextView) findViewById(R.id.newschosen_info_tv);
        imageView = (ImageView) findViewById(R.id.newschosen_info_img);
    }

    @Override
    protected void initDatas() {
        intent = getIntent();
        final int width = ScreenSizeUtil.getScreenWidth(getApplicationContext());
        final int height = ScreenSizeUtil.getScreenHeight(getApplicationContext());

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }
        });

//        // 设置WebView加载网页的属性
//        WebSettings webSettings = webView.getSettings();
//        // 让WebView能够执行javaScript
//        webSettings.setJavaScriptEnabled(true);
//        // 让JavaScript可以自动打开windows
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        // 设置缓存
//        webSettings.setAppCacheEnabled(true);
//        // 设置缓存模式,一共有四种模式
//        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        // 设置缓存路径
//        // webSettings.setAppCachePath("");
//        // 支持缩放(适配到当前屏幕)
//        webSettings.setSupportZoom(true);
//        // 将图片调整到合适的大小
//        webSettings.setUseWideViewPort(true);
//        // 支持内容重新布局,一共有四种方式
//        // 默认的是NARROW_COLUMNS
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        // 设置可以被显示的屏幕控制
//        webSettings.setDisplayZoomControls(true);
//        // 设置默认字体大小
//        webSettings.setDefaultFontSize(12);

        chosen_infourl_middle = intent.getStringExtra("postid");

        CHOSEN_INFOURL = CHOSEN_INFOURL_LEFT + chosen_infourl_middle + CHOSEN_INFOURL_RIGHT;
        VolleyInstance.getInstance().setRequset(CHOSEN_INFOURL, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                // 解析
                // 1.把resultStr换成JSONObject或者JSONArray
                try {
                    JSONObject obj = new JSONObject(resultStr);
                    JSONObject obj1 = obj.getJSONObject(chosen_infourl_middle);

                    body = obj1.getString("body");
                    title = obj1.getString("title");
                    JSONArray arr = obj1.getJSONArray("img");
                    JSONObject object = arr.getJSONObject(0);
                    image = object.getString("src");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // 2. getJSOBObjec("key")
                // 这个key值是不确定的 由上级界面传来

                tv.setText(title);
                Picasso.with(NewsChosenInfoActivity.this).load(image).resize(width,height/2).into(imageView);
                webView.loadData(body, "text/html; charset=UTF-8", null);
            }

            @Override
            public void failure() {

            }
        });


    }

}


//                    Log.d("xxx", "*****************************" + body);
//========================================================
//                    //        // 设置WebView加载网页的属性
//                    WebSettings webSettings = webView.getSettings();
//                    // 让WebView能够执行javaScript
//                    webSettings.setJavaScriptEnabled(true);
//                    // 让JavaScript可以自动打开windows
//                    webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//                    // 设置缓存
//                    webSettings.setAppCacheEnabled(true);
//                    // 设置缓存模式,一共有四种模式
//                    webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//                    // 设置缓存路径
//                    // webSettings.setAppCachePath("");
//                    // 支持缩放(适配到当前屏幕)
//                    webSettings.setSupportZoom(true);
//                    // 将图片调整到合适的大小
//                    webSettings.setUseWideViewPort(true);
//                    // 支持内容重新布局,一共有四种方式
//                    // 默认的是NARROW_COLUMNS
//                    webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//                    // 设置可以被显示的屏幕控制
//                    webSettings.setDisplayZoomControls(true);
//                    // 设置默认字体大小
//                    webSettings.setDefaultFontSize(12);
//                    //========================================================
//                    webView.loadUrl(url);
