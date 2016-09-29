package com.wang.neteasenews.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/29.
 * 话题界面话题部分头布局实体类
 */
public class TopicTopicHeaderBean {

    /**
     * focusNum : 3260
     * picUrl : http://dingyue.nosdn.127.net/qKmxW6eJiG2qzGgawRtHY545xhaayQAMsmdNQpqApYzio1464165947765.jpg
     * topicId : SJ08035584748205376495
     * topicName : 端午这样过
     */

    private List<话题Bean> 话题;

    public List<话题Bean> get话题() {
        return 话题;
    }

    public void set话题(List<话题Bean> 话题) {
        this.话题 = 话题;
    }

    public static class 话题Bean {
        private int focusNum;
        private String picUrl;
        private String topicId;
        private String topicName;

        public int getFocusNum() {
            return focusNum;
        }

        public void setFocusNum(int focusNum) {
            this.focusNum = focusNum;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getTopicId() {
            return topicId;
        }

        public void setTopicId(String topicId) {
            this.topicId = topicId;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }
    }
}
