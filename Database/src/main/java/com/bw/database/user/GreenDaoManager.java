package com.bw.database.user;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.blankj.utilcode.util.Utils;

/**
 * @package:com.bw.database.user
 * @fileName:GreenDaoManager
 * @date on:2021/9/11 8:22
 * @another:HG
 * @email:1572651596@qq.com
 */
public class GreenDaoManager {
    private static volatile GreenDaoManager greenDaoManager;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private static DaoMaster.DevOpenHelper user;
    private static UserDao userDao;
    private Context context;
    

    public static GreenDaoManager getGreenDaoManager() {
        if(greenDaoManager==null){
            synchronized (GreenDaoManager.class){
                if(greenDaoManager==null){
                    greenDaoManager = new GreenDaoManager();
                }
            }
        }
        return greenDaoManager;
    }

    public void init(Context context){
        this.context = context;
    }


    public static DaoMaster getDaoMaster() {
        if(daoMaster==null){
            user = new DaoMaster.DevOpenHelper(Utils.getApp(), "user");
            SQLiteDatabase writableDatabase = user.getWritableDatabase();
            daoMaster = new DaoMaster(writableDatabase);
        }
        return daoMaster;
    }

    public static DaoSession getDaoSession() {
        if(daoSession==null){
            if(daoMaster==null){
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
    
    public static UserDao getUserDao(){
        userDao = daoSession.getUserDao();
        return userDao ;
    }

}
