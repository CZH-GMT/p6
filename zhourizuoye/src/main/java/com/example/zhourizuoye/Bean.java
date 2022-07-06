package com.example.zhourizuoye;

import java.util.List;

public class Bean {

    /**
     * error : false
     * results : [{"_id":"596819b7421aa90ca209c45f","createdAt":"2017-07-14T09:09:11.591Z","desc":"RIP","publishedAt":"2017-07-14T13:24:31.177Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fhj53yz5aoj21hc0xcn41.jpg","used":true,"who":"代码家"},{"_id":"5966c4b8421aa90ca209c452","createdAt":"2017-07-13T08:54:16.862Z","desc":"7-13","publishedAt":"2017-07-13T12:28:15.167Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fhhz28n9vyj20u00u00w9.jpg","used":true,"who":"daimajia"},{"_id":"59656ba8421aa97de5c7c91b","createdAt":"2017-07-12T08:22:00.873Z","desc":"7-12","publishedAt":"2017-07-12T13:05:59.766Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fhgsi7mqa9j20ku0kuh1r.jpg","used":true,"who":"daimajia"},{"_id":"59641954421aa90c9203d362","createdAt":"2017-07-11T08:18:28.124Z","desc":"佐佐木希","publishedAt":"2017-07-11T13:46:33.911Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fhfmsbxvllj20u00u0q80.jpg","used":true,"who":"代码家"},{"_id":"5962c411421aa90ca209c425","createdAt":"2017-07-10T08:02:25.353Z","desc":"7-10","publishedAt":"2017-07-10T12:48:49.297Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fhegpeu0h5j20u011iae5.jpg","used":true,"who":"daimajia"},{"_id":"595ed766421aa90ca209c407","createdAt":"2017-07-07T08:35:50.172Z","desc":"7-7","publishedAt":"2017-07-07T12:14:57.685Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fhb0t7ob2mj20u011itd9.jpg","used":true,"who":"daimajia"},{"_id":"595d82f6421aa90ca3bb6aaa","createdAt":"2017-07-06T08:23:18.945Z","desc":"07-06","publishedAt":"2017-07-06T11:57:03.770Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034gy1fh9utulf4kj20u011itbo.jpg","used":true,"who":"代码家"},{"_id":"595c2f23421aa90ca209c3f0","createdAt":"2017-07-05T08:13:23.237Z","desc":"2017-07-5","publishedAt":"2017-07-05T11:15:30.556Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fh8ox6bmjlj20u00u0mz7.jpg","used":true,"who":"daimajia"},{"_id":"595ad246421aa90ca3bb6a91","createdAt":"2017-07-04T07:24:54.820Z","desc":"7-4","publishedAt":"2017-07-04T11:50:36.484Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fh7hwi9lhzj20u011hqa9.jpg","used":true,"who":"daimajia"},{"_id":"5941db7b421aa92c794633cd","createdAt":"2017-06-15T08:57:31.47Z","desc":"6-15","publishedAt":"2017-06-15T13:55:57.947Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fgllsthvu1j20u011in1p.jpg","used":true,"who":"代码家"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }


}
