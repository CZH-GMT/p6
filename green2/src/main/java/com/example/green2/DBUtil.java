package com.example.green2;

import com.example.xts.greendaodemo.db.UserDao;

import java.util.List;

public class DBUtil {

//    public static void insert(String id, String name) {
//        User user = new User(Long.valueOf(id), name);
//        App.daoSession.insert(user);
//    }

    public static void insert(String id,String name){
        User user = new User(Long.valueOf(id), name);
        App.daoSession1.insert(user);
    }







//    public static void upDta(String oldname, String newname) {
//        User isqueryname = isqueryname(oldname);
//        if (isqueryname!=null){
//            isqueryname.setName(newname);
//           App.daoSession.update(isqueryname);
//        }
//    }


    public static void upDta(String oldname,String newname){
        User isqueryname = isqueryname(oldname);
        if (isqueryname!=null){
            isqueryname.setName(newname);
            App.daoSession1.update(isqueryname);
        }
    }






//    public static void delete(String id) {
//        User isquery = isquery(id);
//        if (isquery!=null){
//            App.daoSession.delete(isquery);
//        }
//
//    }

    public static void delete(String id){
        User isidquery = isidquery(id);
        if (isidquery!=null){
            App.daoSession1.delete(isidquery);
        }

    }






//    public static User isqueryname(String name) {
//        return App.daoSession.queryBuilder(User.class).where(UserDao.Properties.Name.eq(name)).unique();
//
//    }



    public static User isqueryname(String name){
        return App.daoSession1.queryBuilder(User.class).where(UserDao.Properties.Name.eq(name)).unique();

    }

//    public static User isquery(String id) {
//        return App.daoSession.queryBuilder(User.class).where(UserDao.Properties.Id.eq(id)).unique();
//
//    }

    public static User isidquery(String id){
        return App.daoSession1.queryBuilder(User.class).where(UserDao.Properties.Id.eq(id)).unique();
    }









//    public static List<User> queryall() {
//        return App.daoSession.loadAll(User.class);
//    }





    public static List<User> queryall(){
        return App.daoSession1.loadAll(User.class);
    }
}
