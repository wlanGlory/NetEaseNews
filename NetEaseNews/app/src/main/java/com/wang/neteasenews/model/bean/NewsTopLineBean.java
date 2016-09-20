package com.wang.neteasenews.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 * 新闻界面头条实体类
 */
public class NewsTopLineBean {


    /**
     * ads : [{"imgsrc":"http://cms-bucket.nosdn.127.net/0aab1f7c407445dd9acf697914b5acb820160920095501.jpeg","subtitle":"","tag":"doc","title":"他拒绝做富二代女婿,出家成了最帅和尚","url":"C1D7PAVE05169QC9"},{"imgsrc":"http://cms-bucket.nosdn.127.net/80f159688fc0465b8f946a1576a69aee20160920141201.jpeg","subtitle":"","tag":"doc","title":"她丑得惊人，却完成了最华丽的逆袭！","url":"C1D8E2JF05169QC9"},{"imgsrc":"http://cms-bucket.nosdn.127.net/764cbd0e7fdb420db619e8eafc3ad2b420160920105948.jpeg","subtitle":"","tag":"photoset","title":"郑州6.5亿建新立交 通车两月堵车严重","url":"00AP0001|2199228"},{"imgsrc":"http://cms-bucket.nosdn.127.net/2cf5b326b63741338be4d332a7ef7f5c20160920105811.jpeg","subtitle":"","tag":"photoset","title":"外媒记录过去16年中国人海照 画面震撼","url":"00AP0001|2199218"}]
     * adtype : 0
     * clkNum : 0
     * docid : 9IG74V5H00963VRO_3R710001|2197565
     * hasAD : 1
     * hasHead : 1
     * img : http://cms-bucket.nosdn.127.net/b14645aee8044b84b0f7206f5db6dfe920160920072246.jpeg
     * imgType : 0
     * imgsrc : http://cms-bucket.nosdn.127.net/b14645aee8044b84b0f7206f5db6dfe920160920072246.jpeg
     * interest : P
     * lmodify : 2016-09-20 17:02:24
     * photosetID : 3R710001|2197565
     * picCount : 0
     * program : LMA1
     * prompt : 成功为您推荐10条新内容
     * ptime : 2016-09-20 07:21:44
     * recType : 0
     * recprog : base
     * replyCount : 0
     * skipID : 3R710001|2197565
     * skipType : photoset
     * subtitle :
     * tag : photoset
     * template : normal1
     * title : 看客:欢愉之境，民众靠它"吞云吐雾"
     */

    private List<T1348647909107Bean> T1348647909107;

    public List<T1348647909107Bean> getT1348647909107() {
        return T1348647909107;
    }

    public void setT1348647909107(List<T1348647909107Bean> T1348647909107) {
        this.T1348647909107 = T1348647909107;
    }

    public static class T1348647909107Bean {
        private int adtype;
        private int clkNum;
        private String docid;
        private int hasAD;
        private int hasHead;
        private String img;
        private int imgType;
        private String imgsrc;
        private String interest;
        private String lmodify;
        private String photosetID;
        private int picCount;
        private String program;
        private String prompt;
        private String ptime;
        private int recType;
        private String recprog;
        private int replyCount;
        private String skipID;
        private String skipType;
        private String subtitle;
        private String tag;
        private String template;
        private String title;


        private String source;

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        /**
         * imgsrc : http://cms-bucket.nosdn.127.net/0aab1f7c407445dd9acf697914b5acb820160920095501.jpeg
         * subtitle :
         * tag : doc
         * title : 他拒绝做富二代女婿,出家成了最帅和尚
         * url : C1D7PAVE05169QC9
         */

        private List<AdsBean> ads;

        public int getAdtype() {
            return adtype;
        }

        public void setAdtype(int adtype) {
            this.adtype = adtype;
        }

        public int getClkNum() {
            return clkNum;
        }

        public void setClkNum(int clkNum) {
            this.clkNum = clkNum;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getImgType() {
            return imgType;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getInterest() {
            return interest;
        }

        public void setInterest(String interest) {
            this.interest = interest;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public int getPicCount() {
            return picCount;
        }

        public void setPicCount(int picCount) {
            this.picCount = picCount;
        }

        public String getProgram() {
            return program;
        }

        public void setProgram(String program) {
            this.program = program;
        }

        public String getPrompt() {
            return prompt;
        }

        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public int getRecType() {
            return recType;
        }

        public void setRecType(int recType) {
            this.recType = recType;
        }

        public String getRecprog() {
            return recprog;
        }

        public void setRecprog(String recprog) {
            this.recprog = recprog;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public static class AdsBean {
            private String imgsrc;
            private String subtitle;
            private String tag;
            private String title;
            private String url;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
