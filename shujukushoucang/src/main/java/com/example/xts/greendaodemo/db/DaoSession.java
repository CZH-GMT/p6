package com.example.xts.greendaodemo.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.shujukushoucang.GrilBean;

import com.example.xts.greendaodemo.db.GrilBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig grilBeanDaoConfig;

    private final GrilBeanDao grilBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        grilBeanDaoConfig = daoConfigMap.get(GrilBeanDao.class).clone();
        grilBeanDaoConfig.initIdentityScope(type);

        grilBeanDao = new GrilBeanDao(grilBeanDaoConfig, this);

        registerDao(GrilBean.class, grilBeanDao);
    }
    
    public void clear() {
        grilBeanDaoConfig.clearIdentityScope();
    }

    public GrilBeanDao getGrilBeanDao() {
        return grilBeanDao;
    }

}
