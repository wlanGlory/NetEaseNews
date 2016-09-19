package com.wang.neteasenews.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/19.
 * 新闻界面财经实体类
 */
public class NewsFinanceBean {

    /**
     * postid : C1ATA3AD002580S6
     * hasCover : false
     * hasHead : 1
     * replyCount : 6197
     * ltitle : 大学毕业生不如农民工？薪酬差距仅1.2倍
     * hasImg : 1
     * digest : 许林（化名）是一位大学生的家长，在刚刚过去的中秋节聚会上，谈起他上大学二年级的儿子，不禁对孩子未来找工作前景颇为担忧。因为，他的直观感受是，大学毕业生现在已经越
     * hasIcon : true
     * docid : C1ATA3AD002580S6
     * title : 大学毕业生不如农民工？薪酬差距仅1.2倍
     * order : 1
     * priority : 254
     * lmodify : 2016-09-19 17:28:22
     * boardid : money_bbs
     * ads : [{"docid":"C1AD3NCE002580SM","title":"全球最大石油公司之一埃克森美孚遭调查","tag":"doc","imgsrc":"http://cms-bucket.nosdn.127.net/fb0faa44fa9b494585ba7e78ab2e160b20160919073749.jpeg","subtitle":"","url":"C1AD3NCE002580SM"}]
     * url_3w : http://money.163.com/16/0919/11/C1ATA3AD002580S6.html
     * template : normal1
     * votecount : 5722
     * alias : Business
     * cid : C1348648727071
     * url : http://3g.163.com/money/16/0919/11/C1ATA3AD002580S6.html
     * hasAD : 1
     * source : 21世纪经济报道
     * ename : caijing
     * subtitle :
     * imgsrc : http://cms-bucket.nosdn.127.net/71c6217210d74dd0b14423a58f4ee99220160919172812.jpeg
     * tname : 财经
     * ptime : 2016-09-19 11:25:00
     */

    private List<T1348648756099Bean> T1348648756099;

    public List<T1348648756099Bean> getT1348648756099() {
        return T1348648756099;
    }

    public void setT1348648756099(List<T1348648756099Bean> T1348648756099) {
        this.T1348648756099 = T1348648756099;
    }

    public static class T1348648756099Bean {
        private String postid;
        private boolean hasCover;
        private int hasHead;
        private int replyCount;
        private String ltitle;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private int order;
        private int priority;
        private String lmodify;
        private String boardid;
        private String url_3w;
        private String template;
        private int votecount;
        private String alias;
        private String cid;
        private String url;
        private int hasAD;
        private String source;
        private String ename;
        private String subtitle;
        private String imgsrc;
        private String tname;
        private String ptime;
        /**
         * docid : C1AD3NCE002580SM
         * title : 全球最大石油公司之一埃克森美孚遭调查
         * tag : doc
         * imgsrc : http://cms-bucket.nosdn.127.net/fb0faa44fa9b494585ba7e78ab2e160b20160919073749.jpeg
         * subtitle :
         * url : C1AD3NCE002580SM
         */

        private List<AdsBean> ads;

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

        public String getLtitle() {
            return ltitle;
        }

        public void setLtitle(String ltitle) {
            this.ltitle = ltitle;
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

        public String getUrl_3w() {
            return url_3w;
        }

        public void setUrl_3w(String url_3w) {
            this.url_3w = url_3w;
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

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public static class AdsBean {
            private String docid;
            private String title;
            private String tag;
            private String imgsrc;
            private String subtitle;
            private String url;

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
    }
}
