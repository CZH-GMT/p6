package com.example.ceshitiku4;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.qizhongtiku4.db.DaoMaster;
import com.example.qizhongtiku4.db.DaoSession;

public class App extends Application {

    public  static DaoSession daoSession;

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
