package com.example;

import com.example.green.User;
import com.example.xts.greendaodemo.db.UserDao;

import java.util.List;

public class DbUtil {
    public static void insert(String id,String name){
        User user = new User(Long.valueOf(id), name);
        App.daoSession.insert(user);
    }
    public static void delete(String id){
        User exist = isExist(id);
        if (exist!=null){
            App.daoSession.delete(exist);
        }



    }
    public static void Update(String oldname,String newname){
        User existByName = isExistByName(oldname);
        if (existByName!=null){
            existByName.setName(newname);
            App.daoSession.update(existByName);
        }

    }
    public static User isExistByName(String name){
        return App.daoSession.queryBuilder(User.class).where(UserDao.Properties.Id.eq(name)).unique();
    }

    public static User isExist(String id){

        //有条件查询
//        return App.daoSession.queryBuilder(User.class).where(UserDao.Properties.Id.eq(id)).unique();
        return App.daoSession.queryBuilder(User.class).where(UserDao.Properties.Id.eq(id)).unique();
    }
    public static List<User> queryAll(){
        //无条件查询
       return App.daoSession.loadAll(User.class);

    }
}

