package com.wang.neteasenews.model.bean;

import com.wang.neteasenews.model.db.A;

import java.sql.Array;

/**
 * Created by dllo on 16/9/22.
 * 新闻界面精选详情页实体类
 */
public class NewsChosenInfoBean {

    private Array spinfo;
    private String title;
    private String source_url;
    private String body;

    public NewsChosenInfoBean() {
    }

    public NewsChosenInfoBean(Array spinfo, String source_url, String body,String title) {
        this.spinfo = spinfo;
        this.source_url = source_url;
        this.body = body;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Array getSpinfo() {
        return spinfo;
    }

    public void setSpinfo(Array spinfo) {
        this.spinfo = spinfo;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }
}
