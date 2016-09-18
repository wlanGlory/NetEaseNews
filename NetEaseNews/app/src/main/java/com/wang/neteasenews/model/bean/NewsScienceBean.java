package com.wang.neteasenews.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 * 新闻界面科技部分实体类
 */
public class NewsScienceBean {

    /**
     * rolls : 5
     * result : 0
     * ads : [{"monitorReplaceDeviceId":0,"id":"53297","ratio":"20.0","show_num":3,"sub_title":"广告","action_params":{"link_url":"http://clickc.admaster.com.cn/c/a70421,b1255494,c3078,i0,m101,h"},"main_title":"华为儿童手表 五重精准定位 时刻安全保护","vdeg":"","category":"T1348649580692","thirdplat":0,"location":"20","action":"1","ad_type":0,"is_dsp_backup":0,"monitor":"","ad_loc":4,"video_url":"","monitorShowUrl":"","flight_id":"716","vdet":"","res_url":["http://img1.126.net/channel6/2016/024015/0917d.jpg","","",""],"expired_time":1474300799000,"loop_time":1,"content":"","style":"3","is_sens":0,"show_time":"2.5","vdog":"","vdot":"","monitorClickUrl":""},{"monitorReplaceDeviceId":0,"id":"53298","ratio":"20.0","show_num":3,"sub_title":"广告","action_params":{"link_url":"http://clickc.admaster.com.cn/c/a70421,b1255495,c3078,i0,m101,h"},"main_title":"HUAWEI 麦芒5 光学防抖 持久续航 立即购买","vdeg":"","category":"T1348649580692","thirdplat":0,"location":"20","action":"1","ad_type":0,"is_dsp_backup":0,"monitor":"","ad_loc":4,"video_url":"","monitorShowUrl":"","flight_id":"716","vdet":"","res_url":["http://img1.126.net/channel6/2016/024015/0917e.jpg","","",""],"expired_time":1474300799000,"loop_time":1,"content":"","style":"3","is_sens":0,"show_time":"2.5","vdog":"","vdot":"","monitorClickUrl":""},{"monitorReplaceDeviceId":0,"id":"53296","ratio":"20.0","show_num":3,"sub_title":"广告","action_params":{"link_url":"http://clickc.admaster.com.cn/c/a70421,b1255493,c3078,i0,m101,h"},"main_title":"HUAWEI P9 徕卡双镜头 摄影新潮流","vdeg":"","category":"T1348649580692","thirdplat":0,"location":"20","action":"1","ad_type":0,"is_dsp_backup":0,"monitor":"","ad_loc":4,"video_url":"","monitorShowUrl":"","flight_id":"716","vdet":"","res_url":["http://img1.126.net/channel6/2016/024015/0917c.jpg","","",""],"expired_time":1474300799000,"loop_time":1,"content":"","style":"3","is_sens":0,"show_time":"2.5","vdog":"","vdot":"","monitorClickUrl":""},{"monitorReplaceDeviceId":0,"id":"53295","ratio":"20.0","show_num":3,"sub_title":"广告","action_params":{"link_url":"http://clickc.admaster.com.cn/c/a70421,b1255492,c3078,i0,m101,h"},"main_title":"HUAWEI P9 徕卡双镜头 摄影新潮流","vdeg":"","category":"T1348649580692","thirdplat":0,"location":"20","action":"1","ad_type":0,"is_dsp_backup":0,"monitor":"","ad_loc":4,"video_url":"","monitorShowUrl":"","flight_id":"716","vdet":"","res_url":["http://img1.126.net/channel6/2016/024015/0917b.jpg","","",""],"expired_time":1474300799000,"loop_time":1,"content":"","style":"3","is_sens":0,"show_time":"2.5","vdog":"","vdot":"","monitorClickUrl":""},{"monitorReplaceDeviceId":0,"id":"53294","ratio":"20.0","show_num":3,"sub_title":"广告","action_params":{"link_url":"http://clickc.admaster.com.cn/c/a70421,b1255491,c3078,i0,m101,h"},"main_title":"HUAWEI P9 徕卡双镜头 摄影新潮流","vdeg":"","category":"T1348649580692","thirdplat":0,"location":"20","action":"1","ad_type":0,"is_dsp_backup":0,"monitor":"","ad_loc":4,"video_url":"","monitorShowUrl":"","flight_id":"716","vdet":"","res_url":["http://img1.126.net/channel6/2016/024015/0917a.jpg","","",""],"expired_time":1474300799000,"loop_time":1,"content":"","style":"3","is_sens":0,"show_time":"2.5","vdog":"","vdot":"","monitorClickUrl":""}]
     * next_req : 600
     * error :
     */

    private int rolls;
    private int result;
    private int next_req;
    private String error;
    /**
     * monitorReplaceDeviceId : 0
     * id : 53297
     * ratio : 20.0
     * show_num : 3
     * sub_title : 广告
     * action_params : {"link_url":"http://clickc.admaster.com.cn/c/a70421,b1255494,c3078,i0,m101,h"}
     * main_title : 华为儿童手表 五重精准定位 时刻安全保护
     * vdeg :
     * category : T1348649580692
     * thirdplat : 0
     * location : 20
     * action : 1
     * ad_type : 0
     * is_dsp_backup : 0
     * monitor :
     * ad_loc : 4
     * video_url :
     * monitorShowUrl :
     * flight_id : 716
     * vdet :
     * res_url : ["http://img1.126.net/channel6/2016/024015/0917d.jpg","","",""]
     * expired_time : 1474300799000
     * loop_time : 1
     * content :
     * style : 3
     * is_sens : 0
     * show_time : 2.5
     * vdog :
     * vdot :
     * monitorClickUrl :
     */

    private List<AdsBean> ads;

    public int getRolls() {
        return rolls;
    }

    public void setRolls(int rolls) {
        this.rolls = rolls;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getNext_req() {
        return next_req;
    }

    public void setNext_req(int next_req) {
        this.next_req = next_req;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<AdsBean> getAds() {
        return ads;
    }

    public void setAds(List<AdsBean> ads) {
        this.ads = ads;
    }

    public static class AdsBean {
        private int monitorReplaceDeviceId;
        private String id;
        private String ratio;
        private int show_num;
        private String sub_title;
        /**
         * link_url : http://clickc.admaster.com.cn/c/a70421,b1255494,c3078,i0,m101,h
         */

        private ActionParamsBean action_params;
        private String main_title;
        private String vdeg;
        private String category;
        private int thirdplat;
        private String location;
        private String action;
        private int ad_type;
        private int is_dsp_backup;
        private String monitor;
        private int ad_loc;
        private String video_url;
        private String monitorShowUrl;
        private String flight_id;
        private String vdet;
        private long expired_time;
        private int loop_time;
        private String content;
        private String style;
        private int is_sens;
        private String show_time;
        private String vdog;
        private String vdot;
        private String monitorClickUrl;
        private List<String> res_url;

        public int getMonitorReplaceDeviceId() {
            return monitorReplaceDeviceId;
        }

        public void setMonitorReplaceDeviceId(int monitorReplaceDeviceId) {
            this.monitorReplaceDeviceId = monitorReplaceDeviceId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRatio() {
            return ratio;
        }

        public void setRatio(String ratio) {
            this.ratio = ratio;
        }

        public int getShow_num() {
            return show_num;
        }

        public void setShow_num(int show_num) {
            this.show_num = show_num;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
        }

        public ActionParamsBean getAction_params() {
            return action_params;
        }

        public void setAction_params(ActionParamsBean action_params) {
            this.action_params = action_params;
        }

        public String getMain_title() {
            return main_title;
        }

        public void setMain_title(String main_title) {
            this.main_title = main_title;
        }

        public String getVdeg() {
            return vdeg;
        }

        public void setVdeg(String vdeg) {
            this.vdeg = vdeg;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getThirdplat() {
            return thirdplat;
        }

        public void setThirdplat(int thirdplat) {
            this.thirdplat = thirdplat;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public int getAd_type() {
            return ad_type;
        }

        public void setAd_type(int ad_type) {
            this.ad_type = ad_type;
        }

        public int getIs_dsp_backup() {
            return is_dsp_backup;
        }

        public void setIs_dsp_backup(int is_dsp_backup) {
            this.is_dsp_backup = is_dsp_backup;
        }

        public String getMonitor() {
            return monitor;
        }

        public void setMonitor(String monitor) {
            this.monitor = monitor;
        }

        public int getAd_loc() {
            return ad_loc;
        }

        public void setAd_loc(int ad_loc) {
            this.ad_loc = ad_loc;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public String getMonitorShowUrl() {
            return monitorShowUrl;
        }

        public void setMonitorShowUrl(String monitorShowUrl) {
            this.monitorShowUrl = monitorShowUrl;
        }

        public String getFlight_id() {
            return flight_id;
        }

        public void setFlight_id(String flight_id) {
            this.flight_id = flight_id;
        }

        public String getVdet() {
            return vdet;
        }

        public void setVdet(String vdet) {
            this.vdet = vdet;
        }

        public long getExpired_time() {
            return expired_time;
        }

        public void setExpired_time(long expired_time) {
            this.expired_time = expired_time;
        }

        public int getLoop_time() {
            return loop_time;
        }

        public void setLoop_time(int loop_time) {
            this.loop_time = loop_time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public int getIs_sens() {
            return is_sens;
        }

        public void setIs_sens(int is_sens) {
            this.is_sens = is_sens;
        }

        public String getShow_time() {
            return show_time;
        }

        public void setShow_time(String show_time) {
            this.show_time = show_time;
        }

        public String getVdog() {
            return vdog;
        }

        public void setVdog(String vdog) {
            this.vdog = vdog;
        }

        public String getVdot() {
            return vdot;
        }

        public void setVdot(String vdot) {
            this.vdot = vdot;
        }

        public String getMonitorClickUrl() {
            return monitorClickUrl;
        }

        public void setMonitorClickUrl(String monitorClickUrl) {
            this.monitorClickUrl = monitorClickUrl;
        }

        public List<String> getRes_url() {
            return res_url;
        }

        public void setRes_url(List<String> res_url) {
            this.res_url = res_url;
        }

        public static class ActionParamsBean {
            private String link_url;

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }
        }
    }
}
