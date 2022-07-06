package com.example;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.xts.greendaodemo.db.DaoMaster;
import com.example.xts.greendaodemo.db.DaoSession;

public class App extends Application {

    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initDB();
    }

    private void initDB() {


        //创建帮助类
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "app", null);
        //获取数据库对象
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();

        //获取daosession
        daoSession = new DaoMaster(writableDatabase).newSession();

    }
}
