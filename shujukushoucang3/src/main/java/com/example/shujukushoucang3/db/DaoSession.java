package com.example.shujukushoucang3.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.shujukushoucang3.ResultsBean;

import com.example.shujukushoucang3.db.ResultsBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig resultsBeanDaoConfig;

    private final ResultsBeanDao resultsBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        resultsBeanDaoConfig = daoConfigMap.get(ResultsBeanDao.class).clone();
        resultsBeanDaoConfig.initIdentityScope(type);

        resultsBeanDao = new ResultsBeanDao(resultsBeanDaoConfig, this);

        registerDao(ResultsBean.class, resultsBeanDao);
    }
    
    public void clear() {
        resultsBeanDaoConfig.clearIdentityScope();
    }

    public ResultsBeanDao getResultsBeanDao() {
        return resultsBeanDao;
    }

}
