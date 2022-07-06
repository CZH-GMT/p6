package com.example.shujukushoucang3;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.shujukushoucang3.db.DaoMaster;
import com.example.shujukushoucang3.db.DaoSession;


public class App extends Application {


    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initDB();
    }

    private void initDB() {

        DaoMaster.DevOpenHelper app = new DaoMaster.DevOpenHelper(this, "app", null);
        SQLiteDatabase writableDatabase = app.getWritableDatabase();
        daoSession = new DaoMaster(writableDatabase).newSession();
    }
}
