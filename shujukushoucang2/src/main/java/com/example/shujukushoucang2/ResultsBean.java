package com.example.shujukushoucang2;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;

@Entity(nameInDb = "girl")
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
        @Id(autoincrement = true)
        private Long idd;
       //@Unique
        @Property(nameInDb = "iddddd")
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
       @Transient
        private String who;

        @Generated(hash = 863923874)
        public ResultsBean(Long idd, String _id, String createdAt, String desc,
                String publishedAt, String source, String type, String url,
                boolean used) {
            this.idd = idd;
            this._id = _id;
            this.createdAt = createdAt;
            this.desc = desc;
            this.publishedAt = publishedAt;
            this.source = source;
            this.type = type;
            this.url = url;
            this.used = used;
        }

        @Generated(hash = 1822271928)
        public ResultsBean() {
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public boolean getUsed() {
            return this.used;
        }

        public Long getIdd() {
            return this.idd;
        }

        public void setIdd(Long idd) {
            this.idd = idd;
        }
    }