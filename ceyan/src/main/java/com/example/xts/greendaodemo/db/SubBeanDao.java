package com.example.xts.greendaodemo.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.ceyan.SubBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SUB_BEAN".
*/
public class SubBeanDao extends AbstractDao<SubBean, Long> {

    public static final String TABLENAME = "SUB_BEAN";

    /**
     * Properties of entity SubBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Mid = new Property(0, Long.class, "mid", true, "_id");
        public final static Property ApkLink = new Property(1, String.class, "apkLink", false, "APK_LINK");
        public final static Property Audit = new Property(2, int.class, "audit", false, "AUDIT");
        public final static Property Author = new Property(3, String.class, "author", false, "AUTHOR");
        public final static Property CanEdit = new Property(4, boolean.class, "canEdit", false, "CAN_EDIT");
        public final static Property ChapterId = new Property(5, int.class, "chapterId", false, "CHAPTER_ID");
        public final static Property ChapterName = new Property(6, String.class, "chapterName", false, "CHAPTER_NAME");
        public final static Property Collect = new Property(7, boolean.class, "collect", false, "COLLECT");
        public final static Property CourseId = new Property(8, int.class, "courseId", false, "COURSE_ID");
        public final static Property Desc = new Property(9, String.class, "desc", false, "DESC");
        public final static Property DescMd = new Property(10, String.class, "descMd", false, "DESC_MD");
        public final static Property EnvelopePic = new Property(11, String.class, "envelopePic", false, "ENVELOPE_PIC");
        public final static Property Fresh = new Property(12, boolean.class, "fresh", false, "FRESH");
        public final static Property Host = new Property(13, String.class, "host", false, "HOST");
        public final static Property Id = new Property(14, int.class, "id", false, "ID");
        public final static Property Link = new Property(15, String.class, "link", false, "LINK");
        public final static Property NiceDate = new Property(16, String.class, "niceDate", false, "NICE_DATE");
        public final static Property NiceShareDate = new Property(17, String.class, "niceShareDate", false, "NICE_SHARE_DATE");
        public final static Property Origin = new Property(18, String.class, "origin", false, "ORIGIN");
        public final static Property Prefix = new Property(19, String.class, "prefix", false, "PREFIX");
        public final static Property ProjectLink = new Property(20, String.class, "projectLink", false, "PROJECT_LINK");
        public final static Property PublishTime = new Property(21, long.class, "publishTime", false, "PUBLISH_TIME");
        public final static Property RealSuperChapterId = new Property(22, int.class, "realSuperChapterId", false, "REAL_SUPER_CHAPTER_ID");
        public final static Property SelfVisible = new Property(23, int.class, "selfVisible", false, "SELF_VISIBLE");
        public final static Property ShareDate = new Property(24, long.class, "shareDate", false, "SHARE_DATE");
        public final static Property ShareUser = new Property(25, String.class, "shareUser", false, "SHARE_USER");
        public final static Property SuperChapterId = new Property(26, int.class, "superChapterId", false, "SUPER_CHAPTER_ID");
        public final static Property SuperChapterName = new Property(27, String.class, "superChapterName", false, "SUPER_CHAPTER_NAME");
        public final static Property Title = new Property(28, String.class, "title", false, "TITLE");
        public final static Property Type = new Property(29, int.class, "type", false, "TYPE");
        public final static Property UserId = new Property(30, int.class, "userId", false, "USER_ID");
        public final static Property Visible = new Property(31, int.class, "visible", false, "VISIBLE");
        public final static Property Zan = new Property(32, int.class, "zan", false, "ZAN");
    }


    public SubBeanDao(DaoConfig config) {
        super(config);
    }
    
    public SubBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SUB_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: mid
                "\"APK_LINK\" TEXT," + // 1: apkLink
                "\"AUDIT\" INTEGER NOT NULL ," + // 2: audit
                "\"AUTHOR\" TEXT," + // 3: author
                "\"CAN_EDIT\" INTEGER NOT NULL ," + // 4: canEdit
                "\"CHAPTER_ID\" INTEGER NOT NULL ," + // 5: chapterId
                "\"CHAPTER_NAME\" TEXT," + // 6: chapterName
                "\"COLLECT\" INTEGER NOT NULL ," + // 7: collect
                "\"COURSE_ID\" INTEGER NOT NULL ," + // 8: courseId
                "\"DESC\" TEXT," + // 9: desc
                "\"DESC_MD\" TEXT," + // 10: descMd
                "\"ENVELOPE_PIC\" TEXT," + // 11: envelopePic
                "\"FRESH\" INTEGER NOT NULL ," + // 12: fresh
                "\"HOST\" TEXT," + // 13: host
                "\"ID\" INTEGER NOT NULL ," + // 14: id
                "\"LINK\" TEXT," + // 15: link
                "\"NICE_DATE\" TEXT," + // 16: niceDate
                "\"NICE_SHARE_DATE\" TEXT," + // 17: niceShareDate
                "\"ORIGIN\" TEXT," + // 18: origin
                "\"PREFIX\" TEXT," + // 19: prefix
                "\"PROJECT_LINK\" TEXT," + // 20: projectLink
                "\"PUBLISH_TIME\" INTEGER NOT NULL ," + // 21: publishTime
                "\"REAL_SUPER_CHAPTER_ID\" INTEGER NOT NULL ," + // 22: realSuperChapterId
                "\"SELF_VISIBLE\" INTEGER NOT NULL ," + // 23: selfVisible
                "\"SHARE_DATE\" INTEGER NOT NULL ," + // 24: shareDate
                "\"SHARE_USER\" TEXT," + // 25: shareUser
                "\"SUPER_CHAPTER_ID\" INTEGER NOT NULL ," + // 26: superChapterId
                "\"SUPER_CHAPTER_NAME\" TEXT," + // 27: superChapterName
                "\"TITLE\" TEXT," + // 28: title
                "\"TYPE\" INTEGER NOT NULL ," + // 29: type
                "\"USER_ID\" INTEGER NOT NULL ," + // 30: userId
                "\"VISIBLE\" INTEGER NOT NULL ," + // 31: visible
                "\"ZAN\" INTEGER NOT NULL );"); // 32: zan
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SUB_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SubBean entity) {
        stmt.clearBindings();
 
        Long mid = entity.getMid();
        if (mid != null) {
            stmt.bindLong(1, mid);
        }
 
        String apkLink = entity.getApkLink();
        if (apkLink != null) {
            stmt.bindString(2, apkLink);
        }
        stmt.bindLong(3, entity.getAudit());
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(4, author);
        }
        stmt.bindLong(5, entity.getCanEdit() ? 1L: 0L);
        stmt.bindLong(6, entity.getChapterId());
 
        String chapterName = entity.getChapterName();
        if (chapterName != null) {
            stmt.bindString(7, chapterName);
        }
        stmt.bindLong(8, entity.getCollect() ? 1L: 0L);
        stmt.bindLong(9, entity.getCourseId());
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(10, desc);
        }
 
        String descMd = entity.getDescMd();
        if (descMd != null) {
            stmt.bindString(11, descMd);
        }
 
        String envelopePic = entity.getEnvelopePic();
        if (envelopePic != null) {
            stmt.bindString(12, envelopePic);
        }
        stmt.bindLong(13, entity.getFresh() ? 1L: 0L);
 
        String host = entity.getHost();
        if (host != null) {
            stmt.bindString(14, host);
        }
        stmt.bindLong(15, entity.getId());
 
        String link = entity.getLink();
        if (link != null) {
            stmt.bindString(16, link);
        }
 
        String niceDate = entity.getNiceDate();
        if (niceDate != null) {
            stmt.bindString(17, niceDate);
        }
 
        String niceShareDate = entity.getNiceShareDate();
        if (niceShareDate != null) {
            stmt.bindString(18, niceShareDate);
        }
 
        String origin = entity.getOrigin();
        if (origin != null) {
            stmt.bindString(19, origin);
        }
 
        String prefix = entity.getPrefix();
        if (prefix != null) {
            stmt.bindString(20, prefix);
        }
 
        String projectLink = entity.getProjectLink();
        if (projectLink != null) {
            stmt.bindString(21, projectLink);
        }
        stmt.bindLong(22, entity.getPublishTime());
        stmt.bindLong(23, entity.getRealSuperChapterId());
        stmt.bindLong(24, entity.getSelfVisible());
        stmt.bindLong(25, entity.getShareDate());
 
        String shareUser = entity.getShareUser();
        if (shareUser != null) {
            stmt.bindString(26, shareUser);
        }
        stmt.bindLong(27, entity.getSuperChapterId());
 
        String superChapterName = entity.getSuperChapterName();
        if (superChapterName != null) {
            stmt.bindString(28, superChapterName);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(29, title);
        }
        stmt.bindLong(30, entity.getType());
        stmt.bindLong(31, entity.getUserId());
        stmt.bindLong(32, entity.getVisible());
        stmt.bindLong(33, entity.getZan());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SubBean entity) {
        stmt.clearBindings();
 
        Long mid = entity.getMid();
        if (mid != null) {
            stmt.bindLong(1, mid);
        }
 
        String apkLink = entity.getApkLink();
        if (apkLink != null) {
            stmt.bindString(2, apkLink);
        }
        stmt.bindLong(3, entity.getAudit());
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(4, author);
        }
        stmt.bindLong(5, entity.getCanEdit() ? 1L: 0L);
        stmt.bindLong(6, entity.getChapterId());
 
        String chapterName = entity.getChapterName();
        if (chapterName != null) {
            stmt.bindString(7, chapterName);
        }
        stmt.bindLong(8, entity.getCollect() ? 1L: 0L);
        stmt.bindLong(9, entity.getCourseId());
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(10, desc);
        }
 
        String descMd = entity.getDescMd();
        if (descMd != null) {
            stmt.bindString(11, descMd);
        }
 
        String envelopePic = entity.getEnvelopePic();
        if (envelopePic != null) {
            stmt.bindString(12, envelopePic);
        }
        stmt.bindLong(13, entity.getFresh() ? 1L: 0L);
 
        String host = entity.getHost();
        if (host != null) {
            stmt.bindString(14, host);
        }
        stmt.bindLong(15, entity.getId());
 
        String link = entity.getLink();
        if (link != null) {
            stmt.bindString(16, link);
        }
 
        String niceDate = entity.getNiceDate();
        if (niceDate != null) {
            stmt.bindString(17, niceDate);
        }
 
        String niceShareDate = entity.getNiceShareDate();
        if (niceShareDate != null) {
            stmt.bindString(18, niceShareDate);
        }
 
        String origin = entity.getOrigin();
        if (origin != null) {
            stmt.bindString(19, origin);
        }
 
        String prefix = entity.getPrefix();
        if (prefix != null) {
            stmt.bindString(20, prefix);
        }
 
        String projectLink = entity.getProjectLink();
        if (projectLink != null) {
            stmt.bindString(21, projectLink);
        }
        stmt.bindLong(22, entity.getPublishTime());
        stmt.bindLong(23, entity.getRealSuperChapterId());
        stmt.bindLong(24, entity.getSelfVisible());
        stmt.bindLong(25, entity.getShareDate());
 
        String shareUser = entity.getShareUser();
        if (shareUser != null) {
            stmt.bindString(26, shareUser);
        }
        stmt.bindLong(27, entity.getSuperChapterId());
 
        String superChapterName = entity.getSuperChapterName();
        if (superChapterName != null) {
            stmt.bindString(28, superChapterName);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(29, title);
        }
        stmt.bindLong(30, entity.getType());
        stmt.bindLong(31, entity.getUserId());
        stmt.bindLong(32, entity.getVisible());
        stmt.bindLong(33, entity.getZan());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public SubBean readEntity(Cursor cursor, int offset) {
        SubBean entity = new SubBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // mid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // apkLink
            cursor.getInt(offset + 2), // audit
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // author
            cursor.getShort(offset + 4) != 0, // canEdit
            cursor.getInt(offset + 5), // chapterId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // chapterName
            cursor.getShort(offset + 7) != 0, // collect
            cursor.getInt(offset + 8), // courseId
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // desc
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // descMd
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // envelopePic
            cursor.getShort(offset + 12) != 0, // fresh
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // host
            cursor.getInt(offset + 14), // id
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // link
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // niceDate
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // niceShareDate
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // origin
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // prefix
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // projectLink
            cursor.getLong(offset + 21), // publishTime
            cursor.getInt(offset + 22), // realSuperChapterId
            cursor.getInt(offset + 23), // selfVisible
            cursor.getLong(offset + 24), // shareDate
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // shareUser
            cursor.getInt(offset + 26), // superChapterId
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // superChapterName
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // title
            cursor.getInt(offset + 29), // type
            cursor.getInt(offset + 30), // userId
            cursor.getInt(offset + 31), // visible
            cursor.getInt(offset + 32) // zan
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SubBean entity, int offset) {
        entity.setMid(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setApkLink(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAudit(cursor.getInt(offset + 2));
        entity.setAuthor(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCanEdit(cursor.getShort(offset + 4) != 0);
        entity.setChapterId(cursor.getInt(offset + 5));
        entity.setChapterName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCollect(cursor.getShort(offset + 7) != 0);
        entity.setCourseId(cursor.getInt(offset + 8));
        entity.setDesc(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setDescMd(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setEnvelopePic(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setFresh(cursor.getShort(offset + 12) != 0);
        entity.setHost(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setId(cursor.getInt(offset + 14));
        entity.setLink(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setNiceDate(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setNiceShareDate(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setOrigin(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setPrefix(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setProjectLink(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setPublishTime(cursor.getLong(offset + 21));
        entity.setRealSuperChapterId(cursor.getInt(offset + 22));
        entity.setSelfVisible(cursor.getInt(offset + 23));
        entity.setShareDate(cursor.getLong(offset + 24));
        entity.setShareUser(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setSuperChapterId(cursor.getInt(offset + 26));
        entity.setSuperChapterName(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setTitle(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setType(cursor.getInt(offset + 29));
        entity.setUserId(cursor.getInt(offset + 30));
        entity.setVisible(cursor.getInt(offset + 31));
        entity.setZan(cursor.getInt(offset + 32));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(SubBean entity, long rowId) {
        entity.setMid(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(SubBean entity) {
        if(entity != null) {
            return entity.getMid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SubBean entity) {
        return entity.getMid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
