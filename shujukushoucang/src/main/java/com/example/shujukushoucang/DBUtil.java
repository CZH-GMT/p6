package com.example.shujukushoucang;

import java.util.List;

public class DBUtil {
    public static void insert(GrilBean grilBean){
        App.daoSession.insert(grilBean);

    }
    public static List<GrilBean> quary(){
        return App.daoSession.loadAll(GrilBean.class);

    }
}
