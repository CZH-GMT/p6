package com.example.gouwucheanli;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public  class ResultsBean {
        /**
         * _id : 5b27c7bf421aa923c0fbfda1
         * createdAt : 2018-06-18T22:54:55.614Z
         * desc : 2018-06-20
         * publishedAt : 2018-06-20T00:00:00.0Z
         * source : web
         * type : 福利
         * url : http://ww1.sinaimg.cn/large/0065oQSqly1fsfq1ykabxj30k00pracv.jpg
         * used : true
         * who : lijinshanmx
         */

        @Id
        private Long id;
        private String mid;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        @Generated(hash = 1824533969)
        public ResultsBean(Long id, String mid, String createdAt, String desc,
                String publishedAt, String source, String type, String url,
                boolean used, String who) {
            this.id = id;
            this.mid = mid;
            this.createdAt = createdAt;
            this.desc = desc;
            this.publishedAt = publishedAt;
            this.source = source;
            this.type = type;
            this.url = url;
            this.used = used;
            this.who = who;
        }
        @Generated(hash = 1822271928)
        public ResultsBean() {
        }
        public Long getId() {
            return this.id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getMid() {
            return this.mid;
        }
        public void setMid(String mid) {
            this.mid = mid;
        }
        public String getCreatedAt() {
            return this.createdAt;
        }
        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
        public String getDesc() {
            return this.desc;
        }
        public void setDesc(String desc) {
            this.desc = desc;
        }
        public String getPublishedAt() {
            return this.publishedAt;
        }
        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }
        public String getSource() {
            return this.source;
        }
        public void setSource(String source) {
            this.source = source;
        }
        public String getType() {
            return this.type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public String getUrl() {
            return this.url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public boolean getUsed() {
            return this.used;
        }
        public void setUsed(boolean used) {
            this.used = used;
        }
        public String getWho() {
            return this.who;
        }
        public void setWho(String who) {
            this.who = who;
        }


    }