package com.example.shujukushoucang2;

import java.util.List;

public class DBUtil {
    public static void insert(ResultsBean resultsBean){
        App.daoSession.insert(resultsBean);
    }

    public static List<ResultsBean> query(){
        return App.daoSession.loadAll(ResultsBean.class);
    }
}
