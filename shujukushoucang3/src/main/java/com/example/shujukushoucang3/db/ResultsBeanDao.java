package com.example.shujukushoucang3.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.shujukushoucang3.ResultsBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "RESULTS_BEAN".
*/
public class ResultsBeanDao extends AbstractDao<ResultsBean, Long> {

    public static final String TABLENAME = "RESULTS_BEAN";

    /**
     * Properties of entity ResultsBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Mid = new Property(1, String.class, "mid", false, "MID");
        public final static Property CreatedAt = new Property(2, String.class, "createdAt", false, "CREATED_AT");
        public final static Property Desc = new Property(3, String.class, "desc", false, "DESC");
        public final static Property PublishedAt = new Property(4, String.class, "publishedAt", false, "PUBLISHED_AT");
        public final static Property Source = new Property(5, String.class, "source", false, "SOURCE");
        public final static Property Type = new Property(6, String.class, "type", false, "TYPE");
        public final static Property Url = new Property(7, String.class, "url", false, "URL");
        public final static Property Used = new Property(8, boolean.class, "used", false, "USED");
        public final static Property Who = new Property(9, String.class, "who", false, "WHO");
    }


    public ResultsBeanDao(DaoConfig config) {
        super(config);
    }
    
    public ResultsBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"RESULTS_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"MID\" TEXT," + // 1: mid
                "\"CREATED_AT\" TEXT," + // 2: createdAt
                "\"DESC\" TEXT," + // 3: desc
                "\"PUBLISHED_AT\" TEXT," + // 4: publishedAt
                "\"SOURCE\" TEXT," + // 5: source
                "\"TYPE\" TEXT," + // 6: type
                "\"URL\" TEXT," + // 7: url
                "\"USED\" INTEGER NOT NULL ," + // 8: used
                "\"WHO\" TEXT);"); // 9: who
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RESULTS_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ResultsBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String mid = entity.getMid();
        if (mid != null) {
            stmt.bindString(2, mid);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(3, createdAt);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(4, desc);
        }
 
        String publishedAt = entity.getPublishedAt();
        if (publishedAt != null) {
            stmt.bindString(5, publishedAt);
        }
 
        String source = entity.getSource();
        if (source != null) {
            stmt.bindString(6, source);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(7, type);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(8, url);
        }
        stmt.bindLong(9, entity.getUsed() ? 1L: 0L);
 
        String who = entity.getWho();
        if (who != null) {
            stmt.bindString(10, who);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ResultsBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String mid = entity.getMid();
        if (mid != null) {
            stmt.bindString(2, mid);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(3, createdAt);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(4, desc);
        }
 
        String publishedAt = entity.getPublishedAt();
        if (publishedAt != null) {
            stmt.bindString(5, publishedAt);
        }
 
        String source = entity.getSource();
        if (source != null) {
            stmt.bindString(6, source);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(7, type);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(8, url);
        }
        stmt.bindLong(9, entity.getUsed() ? 1L: 0L);
 
        String who = entity.getWho();
        if (who != null) {
            stmt.bindString(10, who);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ResultsBean readEntity(Cursor cursor, int offset) {
        ResultsBean entity = new ResultsBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // mid
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // createdAt
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // desc
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // publishedAt
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // source
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // type
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // url
            cursor.getShort(offset + 8) != 0, // used
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // who
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ResultsBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCreatedAt(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDesc(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPublishedAt(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSource(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setType(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setUrl(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setUsed(cursor.getShort(offset + 8) != 0);
        entity.setWho(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ResultsBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ResultsBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ResultsBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
