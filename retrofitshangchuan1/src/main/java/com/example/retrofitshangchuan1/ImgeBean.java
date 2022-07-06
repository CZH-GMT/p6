package com.example.retrofitshangchuan1;

public class ImgeBean {

    /**
     * data : {"tmp_path":"tmp_uploads/942243f7244a033a0a939f01eccc8eee.jpg","url":"https://www.liulongbin.top:8888/tmp_uploads/942243f7244a033a0a939f01eccc8eee.jpg"}
     * meta : {"msg":"上传成功","status":200}
     */

    private DataBean data;
    private MetaBean meta;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public static class DataBean {
        /**
         * tmp_path : tmp_uploads/942243f7244a033a0a939f01eccc8eee.jpg
         * url : https://www.liulongbin.top:8888/tmp_uploads/942243f7244a033a0a939f01eccc8eee.jpg
         */

        private String tmp_path;
        private String url;

        public String getTmp_path() {
            return tmp_path;
        }

        public void setTmp_path(String tmp_path) {
            this.tmp_path = tmp_path;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class MetaBean {
        /**
         * msg : 上传成功
         * status : 200
         */

        private String msg;
        private int status;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
