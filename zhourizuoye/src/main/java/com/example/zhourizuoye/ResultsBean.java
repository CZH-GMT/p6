package com.example.zhourizuoye;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public  class ResultsBean {
        /**
         * _id : 596819b7421aa90ca209c45f
         * createdAt : 2017-07-14T09:09:11.591Z
         * desc : RIP
         * publishedAt : 2017-07-14T13:24:31.177Z
         * source : chrome
         * type : 福利
         * url : https://ws1.sinaimg.cn/large/610dc034ly1fhj53yz5aoj21hc0xcn41.jpg
         * used : true
         * who : 代码家
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