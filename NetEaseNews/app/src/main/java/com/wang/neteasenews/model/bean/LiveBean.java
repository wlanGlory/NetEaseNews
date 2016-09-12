package com.wang.neteasenews.model.bean;

/**
 * Created by dllo on 16/9/12.
 */
public class LiveBean {
    private String title;
    private int imgId;
    private int time;
    private String date;

    public LiveBean() {
    }

    public LiveBean(String title, int imgId, int time, String date) {
        this.title = title;
        this.imgId = imgId;
        this.time = time;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
