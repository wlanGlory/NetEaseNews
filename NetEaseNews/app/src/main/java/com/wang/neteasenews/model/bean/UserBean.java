package com.wang.neteasenews.model.bean;

/**
 * Created by dllo on 16/9/13.
 * 用户中心(我)实体类
 */
public class UserBean {
    private int imgId;
    private String content;

    public UserBean() {
    }

    public UserBean(int imgId, String content) {
        this.imgId = imgId;
        this.content = content;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
