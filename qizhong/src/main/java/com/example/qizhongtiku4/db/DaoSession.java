package com.example.qizhongtiku4.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.qizhong.SubBean;

import com.example.qizhongtiku4.db.SubBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig subBeanDaoConfig;

    private final SubBeanDao subBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        subBeanDaoConfig = daoConfigMap.get(SubBeanDao.class).clone();
        subBeanDaoConfig.initIdentityScope(type);

        subBeanDao = new SubBeanDao(subBeanDaoConfig, this);

        registerDao(SubBean.class, subBeanDao);
    }
    
    public void clear() {
        subBeanDaoConfig.clearIdentityScope();
    }

    public SubBeanDao getSubBeanDao() {
        return subBeanDao;
    }

}
