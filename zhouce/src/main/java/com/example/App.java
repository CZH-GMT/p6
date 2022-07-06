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
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "app", null);
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        daoSession = new DaoMaster(writableDatabase).newSession();
    }
}
