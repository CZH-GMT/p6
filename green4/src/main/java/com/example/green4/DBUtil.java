package com.example.green4;

import com.example.xts.greendaodemo.db.UserDao;

import java.util.List;

public class DBUtil {

    public static void insert(String id,String name){

        User user = new User(Long.valueOf(id),name);
        App.daoSession.insert(user);
    }

    public static User isname(String name){
       return App.daoSession.queryBuilder(User.class).where(UserDao.Properties.Name.eq(name)).unique();
    }
    public static User isid(String id){
        return App.daoSession.queryBuilder(User.class).where(UserDao.Properties.Id.eq(id)).unique();
    }

    public static void delete(String id){
        User isid = isid(id);
        if (isid!=null){
            App.daoSession.delete(isid);
        }
    }
    public static void updata(String oldname,String newname){
        User isname = isname(oldname);
        if (oldname!=null){
            isname.setName(newname);
            App.daoSession.update(isname);
        }
    }
    public static List<User> query(){
      return App.daoSession.loadAll(User.class);
    }


}
