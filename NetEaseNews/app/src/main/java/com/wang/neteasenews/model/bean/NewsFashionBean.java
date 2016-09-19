package com.wang.neteasenews.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/19.
 * 新闻界面时尚实体类
 */
public class NewsFashionBean {

    /**
     * postid : PHOT34IB002625A2
     * hasCover : true
     * hasHead : 1
     * replyCount : 5
     * hasImg : 1
     * digest :
     * hasIcon : true
     * docid : 9IG74V5H00963VRO_C19O5TASapwangupdateDoc
     * title : 英国皇室最爱的Mulberry也走实用主义路线了
     * order : 1
     * priority : 190
     * lmodify : 2016-09-19 08:40:08
     * boardid : photoview_bbs
     * wap_portal : [{"title":"美妆试用","subtitle":"Free Trial","imgsrc":"http://img2.cache.netease.com/m/newsapp/Trial.png","url":"http://lady.163.com/special/beauty/2015xinpin01.html"},{"title":"时尚直播","subtitle":"Fashion Live","imgsrc":"http://img2.cache.netease.com/m/newsapp/FashionLive.png","url":"http://3g.163.com/ntes/special/00340EPA/wapSpecialModule.html?sid=S1449738449563"},{"title":"星座运程","subtitle":"Horoscope","imgsrc":"http://img2.cache.netease.com/m/newsapp/Horoscope.png","url":"http://lady.163.com/special/sense/yunshi.html"}]
     * ads : [{"title":"叙利亚建儿童乐园 用火箭弹残骸做秋千","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/5101fb1e456a4636910fb661d2d6658d20160919084633.jpeg","subtitle":"","url":"00AO0001|2198841"},{"title":"受台风影响 上海黄浦江水位沿线超警戒","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/123bf85989d54dd985d7359ab001f0c720160919073815.jpeg","subtitle":"","url":"00AP0001|2198806"},{"docid":"C198F2UI05169QC9","title":"他们如此刁难空姐 丢人\"丢到了天上\"","tag":"doc","imgsrc":"http://cms-bucket.nosdn.127.net/047c55f5e78a48ff9880a9a8c69622ff20160918204230.jpeg","subtitle":"","url":"C198F2UI05169QC9"},{"title":"乌克兰民众冲撞俄使馆 抗议俄杜马选举","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/b24b0c3406754a0a95bf65cff588d16520160918213610.jpeg","subtitle":"","url":"00AO0001|2198790"},{"title":"女工每天绑铁丝4000根 为儿子挣彩礼钱","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/83beec3ab6044a84b43c45362537907a20160918211027.jpeg","subtitle":"","url":"00AP0001|2198782"}]
     * photosetID : 25A20026|102987
     * template : normal1
     * votecount : 2
     * skipID : 25A20026|102987
     * alias : Women
     * skipType : photoset
     * cid : C1348650356377
     * hasAD : 1
     * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/2772093a685549ab923e4a4c8b73c40820160919005850.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/488a3bf5fb18469b89546325c9c3a27a20160919005908.jpeg"}]
     * source : 网易原创
     * ename : nvren
     * imgsrc : http://cms-bucket.nosdn.127.net/89dfea138f3445d0b4dba086db1cf89220160919083957.jpeg
     * tname : 时尚
     * ptime : 2016-09-19 00:59:11
     */

    private List<T1348650593803Bean> T1348650593803;

    public List<T1348650593803Bean> getT1348650593803() {
        return T1348650593803;
    }

    public void setT1348650593803(List<T1348650593803Bean> T1348650593803) {
        this.T1348650593803 = T1348650593803;
    }

    public static class T1348650593803Bean {
        private String postid;
        private boolean hasCover;
        private int hasHead;
        private int replyCount;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private int order;
        private int priority;
        private String lmodify;
        private String boardid;
        private String photosetID;
        private String template;
        private int votecount;
        private String skipID;
        private String alias;
        private String skipType;
        private String cid;
        private int hasAD;
        private String source;
        private String ename;
        private String imgsrc;
        private String tname;
        private String ptime;



        private int imgType;

        public int getImgType() {
            return imgType;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        /**
         * title : 美妆试用
         * subtitle : Free Trial
         * imgsrc : http://img2.cache.netease.com/m/newsapp/Trial.png
         * url : http://lady.163.com/special/beauty/2015xinpin01.html
         */

        private List<WapPortalBean> wap_portal;
        /**
         * title : 叙利亚建儿童乐园 用火箭弹残骸做秋千
         * tag : photoset
         * imgsrc : http://cms-bucket.nosdn.127.net/5101fb1e456a4636910fb661d2d6658d20160919084633.jpeg
         * subtitle :
         * url : 00AO0001|2198841
         */

        private List<AdsBean> ads;
        /**
         * imgsrc : http://cms-bucket.nosdn.127.net/2772093a685549ab923e4a4c8b73c40820160919005850.jpeg
         */

        private List<ImgextraBean> imgextra;

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public List<WapPortalBean> getWap_portal() {
            return wap_portal;
        }

        public void setWap_portal(List<WapPortalBean> wap_portal) {
            this.wap_portal = wap_portal;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public static class WapPortalBean {
            private String title;
            private String subtitle;
            private String imgsrc;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class AdsBean {
            private String title;
            private String tag;
            private String imgsrc;
            private String subtitle;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ImgextraBean {
            private String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }
    }
}
