package com.bawei.s1dirsir.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Pic = new Property(1, String.class, "Pic", false, "PIC");
        public final static Property Title = new Property(2, String.class, "Title", false, "TITLE");
        public final static Property Str = new Property(3, String.class, "Str", false, "STR");
        public final static Property Price = new Property(4, String.class, "Price", false, "PRICE");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PIC\" TEXT," + // 1: Pic
                "\"TITLE\" TEXT," + // 2: Title
                "\"STR\" TEXT," + // 3: Str
                "\"PRICE\" TEXT);"); // 4: Price
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String Pic = entity.getPic();
        if (Pic != null) {
            stmt.bindString(2, Pic);
        }
 
        String Title = entity.getTitle();
        if (Title != null) {
            stmt.bindString(3, Title);
        }
 
        String Str = entity.getStr();
        if (Str != null) {
            stmt.bindString(4, Str);
        }
 
        String Price = entity.getPrice();
        if (Price != null) {
            stmt.bindString(5, Price);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String Pic = entity.getPic();
        if (Pic != null) {
            stmt.bindString(2, Pic);
        }
 
        String Title = entity.getTitle();
        if (Title != null) {
            stmt.bindString(3, Title);
        }
 
        String Str = entity.getStr();
        if (Str != null) {
            stmt.bindString(4, Str);
        }
 
        String Price = entity.getPrice();
        if (Price != null) {
            stmt.bindString(5, Price);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // Pic
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // Str
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // Price
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPic(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setStr(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPrice(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}